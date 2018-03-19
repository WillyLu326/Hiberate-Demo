package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {

		// Create SessionFactory
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// Get Current Session
		Session session = factory.getCurrentSession();
		
		try {
			// Create Student Object
			Student student = new Student("Willy", "Lu", "luzh0326@gmail.com");
			
			// Start Transaction
			session.beginTransaction();
			
			// Save
			session.save(student);
			
			// Commit Transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
