package com.hibernate.demo;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class QueryStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// Begin Transaction
			session.beginTransaction();
			
			// Query all students
			@SuppressWarnings("unchecked")
			List<Student> students = session.createQuery("from Student").getResultList();
			printList(students);
			
			
			// Query Students who's last name is Lu
			@SuppressWarnings("unchecked")
			List<Student> students2 = session.createQuery("from Student s where s.lastName='Lu'").getResultList();
			printList(students2);
			
			// Commit Transaction
			session.getTransaction().commit();
			
		} finally {
			
		}

	}

	private static void printList(List<Student> students) {
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}
}
