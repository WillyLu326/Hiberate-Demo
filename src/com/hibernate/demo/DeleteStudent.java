package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class DeleteStudent {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// Get Student Id
			int studentId = 2;
			
			// Begin Transaction
			session.beginTransaction();
			
			// Get Student from DB
			Student student = session.get(Student.class, studentId);
			
			// Delete student
			session.delete(student);
			
			// Commit Transaction
			session.getTransaction().commit();
			
		} finally {
			
		}
									
	}
}
