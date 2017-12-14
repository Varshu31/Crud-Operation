package com.scp.crud.studentCrud;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilityClass {
	public static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() throws MyException
	{
		try{
	if(sessionFactory==null)
	{
		Configuration configuration = new Configuration();
		sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
	}	
		}catch(Exception e){
			throw new MyException("Exception in configuration");
		}
	return sessionFactory;
}

}
