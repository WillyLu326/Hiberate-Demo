package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// Get Student Id
			int studentId = 2;
			
			// Begin Session Transaction
			session.beginTransaction();
			
			// Retrieve Student from DB
			Student student = session.get(Student.class, studentId);
			
			// Update Student -> persistence object
			student.setFirstName("Bingjie");
			
			session.getTransaction().commit();
			
		} finally {
			
		}
	}

}
