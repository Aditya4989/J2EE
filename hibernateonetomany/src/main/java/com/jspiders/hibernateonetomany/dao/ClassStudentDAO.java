package com.jspiders.hibernateonetomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetomany.dto.ClassDTO;
import com.jspiders.hibernateonetomany.dto.StudentsDTO;

public class ClassStudentDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("OneToMany");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}

	public static void main(String[] args) {
		try {
			openConnection();
			transaction.begin();

			StudentsDTO student1 = new StudentsDTO();
			student1.setId(1);
			student1.setName("Aditya");
			student1.setContact(9112740106L);
			student1.setAddress("Pune");
			student1.setEmail("adityachakkar123@gmail.com");
			manager.persist(student1);

			StudentsDTO student2 = new StudentsDTO();
			student2.setId(2);
			student2.setName("Shri");
			student2.setContact(8329422131l);
			student2.setAddress("Pune");
			student2.setEmail("shrichakkar123@gmail.com");
			manager.persist(student2);

			StudentsDTO student3 = new StudentsDTO();
			student3.setId(3);
			student3.setName("Siddhesh");
			student3.setContact(9675457656l);
			student3.setAddress("Pune");
			student3.setEmail("siddheshkatale123@gmail.com");
			manager.persist(student3);

			List<StudentsDTO> students = Arrays.asList(student1, student2, student3);

			ClassDTO class1 = new ClassDTO();
			class1.setId(1);
			class1.setName("Qspiders");
			class1.setAddress("Wakad");
			class1.setContact(9886577776l);
			class1.setStudents(students);
			manager.persist(class1);

			transaction.commit();
		} finally {
			closeConnection();
		}
	}
}
