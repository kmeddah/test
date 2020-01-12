package com.project.BookService;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.spring.config.HibernateUtils;
import com.project.spring.model.Book;

public class App {

	private static Session s;
	private static Transaction tx;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s = HibernateUtils.getSession();
		tx = s.beginTransaction();
		Book book = new Book("Comprendre l'Empire", "Alain Soral");
		s.persist(book);
		tx.commit();
	}

}
