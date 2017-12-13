package com.scp.crud.studentCrud;

import java.util.List;

public interface StudentInterface {
	public void addStudent(StudentClass stud);
	public StudentClass getStudent(Integer id);
	public void deleteStudent(int id);
	public StudentClass updateStudent(StudentClass stud);
	public List<StudentClass> getAllStudent();
	public List<StudentClass> searchStudentWithCriteria(StudentClass stud);

}
