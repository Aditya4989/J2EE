package com.jspiders.hibernatemanytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatemanytoone.dto.PeopleDTO;
import com.jspiders.hibernatemanytoone.dto.VillageDTO;

public class VillagePeopleDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("ManyToOne");
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
	
	public static void main(String[] args) {
		try {
			openConnection();
			transaction.begin();
			
			VillageDTO village = new VillageDTO();
			village.setId(1);
			village.setName("Bhawadi");
			village.setLocation_city("Pune");
			manager.persist(village);
			
			VillageDTO village2 = new VillageDTO();
			village2.setId(2);
			village2.setName("Kudalewadi");
			village2.setLocation_city("Pune");
			manager.persist(village2);
			
			PeopleDTO people1 = new PeopleDTO();
			people1.setId(1);
			people1.setName("Aditya");
			people1.setContact(9112740106l);
			people1.setAge(23);
			people1.setVillage(village);
			manager.persist(people1);
			
			PeopleDTO people2 = new PeopleDTO();
			people2.setId(2);
			people2.setName("Akshay");
			people2.setContact(9876876787l);
			people2.setAge(24);
			people1.setVillage(village2);
			manager.persist(people2);
			
			PeopleDTO people3 = new PeopleDTO();
			people3.setId(3);
			people3.setName("Deep");
			people3.setContact(9756975776l);
			people3.setAge(24);
			people3.setVillage(village);
			manager.persist(people3);
			
			PeopleDTO people4 = new PeopleDTO();
			people4.setId(4);
			people4.setName("Abhishek");
			people4.setContact(9854675365l);
			people4.setAge(25);
			people4.setVillage(village2);
			manager.persist(people4);
			
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
}
