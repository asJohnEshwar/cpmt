package com.cb.tracker.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionUtility {
	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		System.out.println("Hibernate file loaded");
		//StandardServiceRegistry registry = new  StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		StandardServiceRegistry registry = new  StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		//Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
}
}
