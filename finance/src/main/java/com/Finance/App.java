package com.Finance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Util.HibernateUtil;

public class App {
    public static void main(String[] args) {
    	 //get sessionFactory
    	SessionFactory factory=HibernateUtil.getSessionFactory();
    	//create a session(connection)
    	Session session=factory.openSession();
    	
    	//Begin a Transaction
    	Transaction tx=session.beginTransaction();
    
    	//close session
    	session.close();
    	
    	//close Session factory
    	factory.close();
    }
}
