package com.jspiders.hibernateonetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import com.jspiders.hibernateonetoone.dto.AadharDTO;
import com.jspiders.hibernateonetoone.dto.PersonDTO;

public class PersonAadharDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("OneToOne");
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

			AadharDTO aadhar1 = new AadharDTO();
			aadhar1.setId(1);
			aadhar1.setAadhar_no(592443980263l);
			aadhar1.setDoi("01-01-2003");

			AadharDTO aadhar2 = new AadharDTO();
			aadhar2.setId(2);
			aadhar2.setAadhar_no(976586459634l);
			aadhar2.setDoi("06-12-2004");

			AadharDTO aadhar3 = new AadharDTO();
			aadhar3.setId(3);
			aadhar3.setAadhar_no(973412549104l);
			aadhar3.setDoi("13-04-2010");

			PersonDTO person1 = new PersonDTO();
			person1.setId(1);
			person1.setName("Aditya");
			person1.setContact(9112740106l);
			person1.setDob("22-05-2001");
			person1.setAddress("Pune");
			person1.setAadhar(aadhar1);
			manager.persist(person1);

			PersonDTO person2 = new PersonDTO();
			person2.setId(2);
			person2.setName("Pratik");
			person2.setContact(9527319009l);
			person2.setDob("02-04-2000");
			person2.setAddress("Pune");
			person2.setAadhar(aadhar2);
			manager.persist(person2);

			PersonDTO person3 = new PersonDTO();
			person3.setId(3);
			person3.setName("Deep");
			person3.setContact(7646759352l);
			person3.setDob("27-09-2000");
			person3.setAddress("Pune");
			person3.setAadhar(aadhar3);
			manager.persist(person3);

			aadhar1.setPerson(person1);
			aadhar2.setPerson(person2);
			aadhar3.setPerson(person3);

			manager.persist(aadhar1);
			manager.persist(aadhar2);
			manager.persist(aadhar3);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
}
