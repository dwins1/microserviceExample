package com.app.inventory.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.inventory.models.JobTitle;
import com.app.inventory.models.User;
import com.app.inventory.models.UserDetail;

public final class HibernateUtil {
	private static SessionFactory sessionFactory=null;
    
    private HibernateUtil() {  
    	Configuration configuration= new Configuration()
								.configure()
								.addAnnotatedClass(User.class)
								.addAnnotatedClass(UserDetail.class)
								.addAnnotatedClass(JobTitle.class);
    	
    	sessionFactory=configuration.buildSessionFactory();
    }
    
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
       	 new HibernateUtil();
        }
        return sessionFactory;
    }
}




//Singleton Pattern
/*
public class HibernateUtil {

	private static SessionFactory sessionFactory=null;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			Configuration configuration= new Configuration()
										.configure()
										.addAnnotatedClass(User.class)
										.addAnnotatedClass(UserDetail.class)
										.addAnnotatedClass(JobTitle.class);
		sessionFactory=configuration.buildSessionFactory();									
		}
		
		return sessionFactory;
	}
}*/
