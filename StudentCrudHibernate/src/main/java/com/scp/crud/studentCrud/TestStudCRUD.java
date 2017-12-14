package com.scp.crud.studentCrud;

public class TestStudCRUD {
	
	public enum SearchParam{
		id,
		name,
		address,
		
	}
	
public static void main(String[] args) throws Exception
{ 
	StudentClass st1=new StudentClass(1,"Nikita","nagar");
	StudentClass st2=new StudentClass(2,"Varsha","kolhapur");
	StudentClass st3=new StudentClass(3,"Rajashri","kolhapur");
	StudentClass st4=new StudentClass(4,"Rajashri","vagholi");
	StudentInterface si= new StudentOperation();
	
	si.addStudent(st4);
	
	System.out.println("");
	//System.out.println(si.getStudent(3));
	//si.deleteStudent(2);
	System.out.println("********************");
	//st2.setName("Sachin");
	//si.updateStudent(st2);
	System.out.println(si.getAllStudent());
	System.out.println(si.searchStudentWithCriteria(st3,TestStudCRUD.SearchParam.address,TestStudCRUD.SearchParam.name));
	
}
}
