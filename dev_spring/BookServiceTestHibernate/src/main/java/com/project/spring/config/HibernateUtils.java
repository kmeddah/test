package com.project.spring.config;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ComponentScans(value = {
		@ComponentScan("com.project.spring.dao"),
		@ComponentScan("com.project.spring.service")
})
public class HibernateUtils {
	
	private static SessionFactory buildSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}
	
	public static Session getSession() throws HibernateException {
		return buildSessionFactory().openSession();
	}
}
