package com.jspiders.springrest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springrest.pojo.StudentPojo;

@Repository
public class StudentRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpql;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("rest");
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
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public StudentPojo addStudent(StudentPojo pojo) {
		openConnection();
		transaction.begin();
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}


//search student by using @RequestBody
		//using this annotation we have to search the data inside the body in postman
	public StudentPojo searchStudent(int id) {
		openConnection();
		transaction.begin();
		StudentPojo student = manager.find(StudentPojo.class, id);
		if (student != null) {
			transaction.commit();
			closeConnection();
			return student;
		}
		transaction.commit();
		closeConnection();
		return null;
	}
	
//search student by using @PathVariable
	//using this annotation we have to search the data inside the body in postman	
	public StudentPojo searchStudentPath(int id) {
		openConnection();
		transaction.begin();
		StudentPojo student = manager.find(StudentPojo.class, id);
		if (student != null) {
			transaction.commit();
			closeConnection();
			return student;
		}
		transaction.commit();
		closeConnection();
		return null;
	}
	
	
	public List<StudentPojo> searchAllStudents() {
		openConnection();
		transaction.begin();
		jpql = "from StudentPojo";
		query = manager.createQuery(jpql);
		List<StudentPojo> students = query.getResultList();
		transaction.commit();
		closeConnection();
		return students;
		
	}

	public StudentPojo removeStudent(int id) {
		openConnection();
		transaction.begin();
		StudentPojo student = manager.find(StudentPojo.class, id);
		
		if (student != null ) {
			manager.remove(student);
			transaction.commit();
			closeConnection();
			return student;
		}
		
		transaction.commit();
		closeConnection();
		return null;
	}

	public StudentPojo updateStudent(StudentPojo pojo) {
		openConnection();
		transaction.begin();
		
		StudentPojo student = manager.find(StudentPojo.class, pojo.getId());
		student.setName(pojo.getName());
		student.setEmail(pojo.getEmail());
		student.setContact(pojo.getContact());
		student.setAddress(pojo.getAddress());
		
		manager.persist(student);
		
		transaction.commit();
		closeConnection();
		return student;
	}


	
}
