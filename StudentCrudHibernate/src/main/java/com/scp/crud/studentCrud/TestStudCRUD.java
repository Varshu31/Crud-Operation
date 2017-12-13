package com.scp.crud.studentCrud;

public class TestStudCRUD {
public static void main(String[] args)
{ 
		System.out.println("################################");
	StudentClass st=new StudentClass(1,"Nikita","nagar");
	
	StudentInterface si= new StudentOperation();
	
	System.out.println("*******************");
	//si.addStudent(st);
	System.out.println("");
	System.out.println(si.getStudent(3));
	//si.deleteStudent(2);
	si.updateStudent(st);
	System.out.println(si.getAllStudent());
	System.out.println(si.searchStudentWithCriteria(st));
	
}
}
