package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class ReadStudent {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			// Create a student
			Student tempStudent = new Student("Zheng", "Lu", "zheng.lu@verizonwireless.com");
			System.out.println("Student 1: " + tempStudent.toString());
			
			// Begin the transaction
			session.beginTransaction();
			
			// Save into DB
			session.save(tempStudent);
			System.out.println("Student 2: " + tempStudent.toString());
			
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Student 3: " + tempStudent.toString());
			
			System.out.println("==========================================");
			
			// Find this student from DB
			session = factory.getCurrentSession();
			
			// Begin Transaction
			session.beginTransaction();
			
			// Get tempStudent
			Student student = session.get(Student.class, tempStudent.getId());
			
			// Print this student
			System.out.println("Student is: " + student.toString());
			
		} finally {
			
		}
		
	}
}
