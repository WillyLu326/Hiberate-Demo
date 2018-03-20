package com.hibernate.demo;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class QueryStudent {

	@SuppressWarnings("unchecked")
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
			List<Student> students = session.createQuery("from Student").getResultList();
			printList(students);
			
			
			// Query Students who's last name is Lu
			List<Student> students2 = session.createQuery("from Student s where s.lastName='Lu'").getResultList();
			printList(students2);
			
			// Query Students who's last name is Lu or first Name is Willy
			List<Student> students3 = session.createQuery("from Student s where s.lastName='Lu' OR s.firstName='Willy'").getResultList();
			printList(students3);
			
			// Query Students who's last name is Lu and first Name is Willy
			List<Student> students4 = session.createQuery("from Student s where s.lastName='Lu' AND s.firstName='Willy'").getResultList();
			printList(students4);
			
			// Query Students who's email is like '...@gmail.com'
			List<Student> students5 = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").getResultList();
			printList(students5);
			
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
