package com.scp.crud.studentCrud;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.scp.crud.studentCrud.TestStudCRUD.SearchParam;

public class StudentOperation implements StudentInterface{
	
	
	public void checkNullFieldsOfException(StudentClass student) throws MyException{
		if(null==student || null==student.getName() || student.getName().trim().length()<=1 
				|| null== student.getAddress() || student.getAddress().trim().length()<=1)
		{
			throw new MyException("Object and it's fields cannot be null");
			
			
		}
	}
	private void resourceCleanupActivities(Session session, Transaction trac) {
		if(null!=trac)
			trac.commit();
		if(null!=session)
			session.close();
	}
	
	public boolean addStudent(StudentClass student) throws MyException {
		checkNullFieldsOfException(student);
		Session session= UtilityClass.getSessionFactory().openSession();			
		Transaction trac=session.beginTransaction();
		try{
		session.save(student);
		}
		catch(Exception e){
			trac.rollback();
			throw new MyException("Exception during adding data");
		
		}
		finally {
				resourceCleanupActivities(session,trac);
			
		}
		
		return true;
		
		
		}
	
		public boolean updateStudent(StudentClass student) throws MyException {
			checkNullFieldsOfException(student);
			Session session= UtilityClass.getSessionFactory().openSession();			
			Transaction trac=session.beginTransaction();
		if(null==getStudent(student.getId()))
		{
			throw new MyException("Given Identifier doesn't exist");
		}
		try{
			session.update(student);
			} 
		catch(Exception e)
		{
				throw new MyException("Exception during updating data");
		}
		finally {
			resourceCleanupActivities(session,trac);
		
		}
	return true;
		
	}
	public boolean deleteStudent(int id) throws MyException {
		Session session= UtilityClass.getSessionFactory().openSession();			
		Transaction trac=session.beginTransaction();
		if(null==getStudent(id))
		{
			throw new MyException("Given Identifier doesn't exist in deleting");
		}
		try{
			
			session.delete(session.get(StudentClass.class, id));
			} catch(Exception e)
		{
				throw new MyException("Exception during deleting data");
		}
		finally {
			resourceCleanupActivities(session,trac);
		
		}
	
		return true;
	}
	
	public StudentClass getStudent(int id) throws HibernateException, MyException {
		
		Session session= UtilityClass.getSessionFactory().openSession();			
		Transaction trac=session.beginTransaction();
		if(id<=0){
			throw new MyException("Given Identifier doesn't exist in getting dat");
		}
		StudentClass stud= new StudentClass();
		
		try{
			stud = (StudentClass) session.get(StudentClass.class, id);
			
		}catch(Exception e)
		{
			throw new MyException("Exception during getting data");
		}
		finally {
			resourceCleanupActivities(session,trac);
		}
		
		return stud;
	   }
     
	public List<StudentClass> getAllStudent() throws MyException {
		Session session= UtilityClass.getSessionFactory().openSession();			
		Transaction tran=session.beginTransaction();
		List<StudentClass> students=null;
		try{
			students = session.createQuery("from StudentClass").list();
			
		}catch(Exception e){
			
			throw new MyException("Exception during getting all data");
		}
				
		return students; 
		
		
	}

	public List<StudentClass> searchStudentWithCriteria(StudentClass stud, TestStudCRUD.SearchParam... params) throws MyException {
		List<StudentClass> studlist= new ArrayList();
		Session session= UtilityClass.getSessionFactory().openSession();			
		Transaction tran=session.beginTransaction();
		Criteria criteria = session.createCriteria(StudentClass.class);
		try{
		for(TestStudCRUD.SearchParam param : params)
		{
			if(param==SearchParam.id){
				
				criteria.add(Restrictions.eq("id", stud.getId())).list();
			}
			if(param==SearchParam.name){
				
				criteria.add(Restrictions.eq("name", stud.getName())).list();
			}
			if(param==SearchParam.address){
				
				criteria.add(Restrictions.eq("address", stud.getAddress())).list();
			}
			
		}
		studlist=criteria.list();
		}catch(Exception e){
			throw new MyException("Exception in searching fields");
			
		}
		
		return studlist;	
		 
		  
	}
	

	
}