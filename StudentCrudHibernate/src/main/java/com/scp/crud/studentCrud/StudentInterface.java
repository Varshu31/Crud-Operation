package com.scp.crud.studentCrud;

import java.util.List;

import org.hibernate.HibernateException;

import com.scp.crud.studentCrud.TestStudCRUD.SearchParam;

public interface StudentInterface {
	public boolean addStudent(StudentClass stud) throws Exception;
	public boolean updateStudent(StudentClass stud) throws Exception;
	public boolean deleteStudent(int id) throws Exception;
	public StudentClass getStudent(int id) throws Exception;
	public List<StudentClass> getAllStudent() throws Exception;
	public List<StudentClass> searchStudentWithCriteria(StudentClass stud,SearchParam... params) throws Exception;

}
