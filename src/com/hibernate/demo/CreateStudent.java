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
			System.out.println("Create Student Obj");
			Student student = new Student("Willy", "Lu", "luzh0326@gmail.com");
			
			// Start Transaction
			System.out.println("Begin Transaction");
			session.beginTransaction();
			
			// Save
			System.out.println("Save Obj");
			session.save(student);
			
			// Commit Transaction
			System.out.println("Commit Transaction");
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
