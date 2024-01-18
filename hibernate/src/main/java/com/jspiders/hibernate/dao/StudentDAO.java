package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentDTO;

public class StudentDAO {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("hibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		StudentDTO dto = new StudentDTO();
		dto.setSid(5);
		dto.setSname("Aditya");
		dto.setEmail("aditya123@gmail.com");
		dto.setMarks(80);
		dto.setSaddr("Pune");
		
		entityManager.persist(dto);
		entityTransaction.commit();
		
		if (entityManagerFactory != null) {
		   entityManagerFactory.close();
		}
		if (entityManager!=null) {
			entityManager.close();
		}
		if (entityTransaction.isActive()) {
			entityTransaction.rollback();
		}
	}
}
