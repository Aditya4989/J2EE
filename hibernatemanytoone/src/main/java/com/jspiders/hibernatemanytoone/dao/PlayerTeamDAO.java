package com.jspiders.hibernatemanytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatemanytoone.dto.PlayerDTO;
import com.jspiders.hibernatemanytoone.dto.TeamDTO;

public class PlayerTeamDAO {

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
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	public static void main(String[] args) {
		try {
			openConnection();
			transaction.begin();
			
			TeamDTO team1 = new TeamDTO();
			team1.setId(1);
			team1.setName("CSK");
			team1.setCity("Chennai");
			manager.persist(team1);
			
			TeamDTO team2 = new TeamDTO();
			team2.setId(2);
			team2.setName("Mumbai");
			team2.setCity("Mumbai");
			manager.persist(team2);
			
			PlayerDTO player1 = new PlayerDTO();
			player1.setId(1);
			player1.setName("M.S.Dhoni");
			player1.setRole("WK/Batsman");
			player1.setJersey(07);
			player1.setAge(41);
			player1.setTeam(team1);
			manager.persist(player1);
			
			PlayerDTO player2 = new PlayerDTO();
			player2.setId(2);
			player2.setName("Rohit Sharma");
			player2.setRole("Batsman");
			player2.setJersey(45);
			player2.setAge(36);
			player2.setTeam(team2);
		    manager.persist(player2);
		    
		    PlayerDTO player3 = new PlayerDTO();
		    player3.setId(3);
		    player3.setName("Ravindra Jadeja");
		    player3.setRole("All-Rounder");
		    player3.setJersey(8);
		    player3.setAge(34);
		    player3.setTeam(team1);
		    manager.persist(player3);
		    
		    PlayerDTO player4 = new PlayerDTO();
		    player4.setId(4);
		    player4.setName("SK Yadav");
		    player4.setRole("Batsman");
		    player4.setJersey(36);
		    player4.setAge(33);
		    player4.setTeam(team2);
		    manager.persist(player4);
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
}
