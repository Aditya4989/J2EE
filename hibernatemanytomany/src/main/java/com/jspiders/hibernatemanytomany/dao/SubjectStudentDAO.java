package com.jspiders.hibernatemanytomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatemanytomany.dto.StudentDTO;
import com.jspiders.hibernatemanytomany.dto.SubjectDTO;

public class SubjectStudentDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("ManyToMany");
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
			
			SubjectDTO sub1 = new SubjectDTO();
			sub1.setId(1);
			sub1.setName("Core Java");
			sub1.setDuration(3);
			manager.persist(sub1);
			
			SubjectDTO sub2 = new SubjectDTO();
			sub2.setId(2);
			sub2.setName("Advance Java");
			sub2.setDuration(3);
			manager.persist(sub2);
			
			List<SubjectDTO> subjects = Arrays.asList(sub1,sub2);
			
			StudentDTO stud1 = new StudentDTO();
			stud1.setId(1);
			stud1.setName("Amar");
			stud1.setEmail("amar@gmail.com");
			stud1.setAddress("Pune");
			stud1.setSubjects(subjects);
			manager.persist(stud1);
			
			StudentDTO stud2 = new StudentDTO();
			stud2.setId(2);
			stud2.setName("Akbar");
			stud2.setEmail("akbar@gmail.com");
			stud2.setAddress("Mumbai");
			stud2.setSubjects(subjects);
			manager.persist(stud2);
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
	}
}
