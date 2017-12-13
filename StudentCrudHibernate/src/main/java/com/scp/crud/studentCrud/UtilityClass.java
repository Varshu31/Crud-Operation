package com.scp.crud.studentCrud;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilityClass {
	public static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory()
	{
	if(sessionFactory==null)
	{
		Configuration configuration = new Configuration();
		sessionFactory = configuration.configure("hibernate.hbm.xml").buildSessionFactory();
	}	
	
	return sessionFactory;
}

}
