package com.scp.crud.studentCrud;
import java.util.Iterator;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class StudentOperation implements StudentInterface{
	
	
	
	public void addStudent(StudentClass student) {
		Session session= UtilityClass.getSessionFactory().openSession();			
		Transaction tran=session.beginTransaction();
		session.save(student);
		tran.commit();
		session.close();
		
		
	}
	
	public StudentClass getStudent(Integer id) {
		Session session= UtilityClass.getSessionFactory().openSession();
		// TODO Auto-generated method stub
		return  (StudentClass) session.get(StudentClass.class, id);
	}

	public void deleteStudent(int id) {
		Session session= UtilityClass.getSessionFactory().openSession();
		// TODO Auto-generated method stub
		Transaction tr= session.beginTransaction();
		StudentClass s=(StudentClass) session.get(StudentClass.class, id);
	     session.delete(s);
		  tr.commit();
		  System.out.println("*********delete **********");
		  
	}

	public StudentClass updateStudent(StudentClass stud) {
		Session session= UtilityClass.getSessionFactory().openSession();			
		Transaction tran=session.beginTransaction();
		StudentClass s1=(StudentClass) session.get(StudentClass.class, stud.getId());
		s1.setName("Neha");
		session.update(s1);
		tran.commit();
		session.close();
		
		System.out.println("Updated Successfully");
		return s1;
		
}

	public List<StudentClass> getAllStudent() {
		Session session= UtilityClass.getSessionFactory().openSession();			
		Transaction tran=session.beginTransaction();
		Query query = session.createQuery("from StudentClass");
		List<StudentClass> students =  query.list();
		tran.commit();
		session.close();
		
		return students; 
		
		
	}

	public List<StudentClass> searchStudentWithCriteria(StudentClass stud) {
		Session session= UtilityClass.getSessionFactory().openSession();			
		Transaction tran=session.beginTransaction();
		Criteria criteria = session.createCriteria(StudentClass.class);
		  criteria.add(Restrictions.eq("name", "Neha"));
		    List studlist = criteria.list();
		    tran.commit();
		    session.close();
		return studlist;
	}
}