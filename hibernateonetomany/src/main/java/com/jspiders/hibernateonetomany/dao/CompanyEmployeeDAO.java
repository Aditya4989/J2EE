package com.jspiders.hibernateonetomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetomany.dto.CompanyDTO;
import com.jspiders.hibernateonetomany.dto.EmployeeDTO;

public class CompanyEmployeeDAO {

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

			EmployeeDTO emp1 = new EmployeeDTO();
			emp1.setId(1);
			emp1.setName("Aditya");
			emp1.setEmail("aditya123@gmail.com");
			emp1.setDesignation("Developer");
			emp1.setSalary(30000);
			manager.persist(emp1);

			EmployeeDTO emp2 = new EmployeeDTO();
			emp2.setId(2);
			emp2.setName("Pranav");
			emp2.setEmail("Pranav@gmail.com");
			emp2.setDesignation("Manager");
			emp2.setSalary(50000);
			manager.persist(emp2);

			EmployeeDTO emp3 = new EmployeeDTO();
			emp3.setId(3);
			emp3.setName("Rushikesh");
			emp3.setEmail("rushikesh@gmail.com");
			emp3.setDesignation("S-Engineer");
			emp3.setSalary(30000);
			manager.persist(emp3);

			List<EmployeeDTO> employees = Arrays.asList(emp1, emp2, emp3);

			CompanyDTO company1 = new CompanyDTO();
			company1.setId(1);
			company1.setName("TCS");
			company1.setDoe("10-05-1985");
			company1.setAddress("Pune");
			company1.setEmployees(employees);
			manager.persist(company1);

			transaction.commit();

		} finally {
			closeConnection();
		}
	}
}
