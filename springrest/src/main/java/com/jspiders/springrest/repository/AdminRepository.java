package com.jspiders.springrest.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springrest.pojo.AdminPOJO;

@Repository
public class AdminRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
//	private static Query query;
//	private static String jpql;
	
	private static void openConection() {
		factory = Persistence.createEntityManagerFactory("rest");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager!=null) {
			manager.close();
		}
		if (transaction!=null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	

	public AdminPOJO createAdmin(AdminPOJO pojo) {
		openConection();
		transaction.begin();
		
		manager.persist(pojo);
		
		transaction.commit();
		closeConnection();
		return null;
	}

	public AdminPOJO loginAdmin(AdminPOJO pojo) {
		openConection();
		transaction.begin();
		
		AdminPOJO admin = manager.find(AdminPOJO.class, pojo.getUsername());
		
		if (admin != null) {
			if (admin.getPassword().equals(pojo.getPassword())) {
				transaction.commit();
				closeConnection();
				return admin;
			}
		}
		
		transaction.commit();
		closeConnection();
		return null;
	}
}
