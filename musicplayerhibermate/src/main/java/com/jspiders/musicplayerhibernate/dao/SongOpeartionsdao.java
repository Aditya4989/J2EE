package com.jspiders.musicplayerhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.musicplayerhibernate.dto.Songdto;

import java.util.Scanner;

public class SongOpeartionsdao {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String jpql;
	private static Query query;

	public static void openConnection() {
		factory = Persistence.createEntityManagerFactory("musicplayer");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	public static void closeConnection() {
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

	public void myPlaylist() {
		try {
			openConnection();

			transaction.begin();
			jpql = "from Songdto ";
			query = manager.createQuery(jpql);

			List<Songdto> songdto = query.getResultList();
			for (Songdto song : songdto) {
				System.out.println(song);
			}
			
			transaction.commit();
		} catch (Exception e) {
			System.out.println("PlayList Is Empty");
		}
	}

	public void playallsongs() {
		try {
			openConnection();

			transaction.begin();
			jpql = "from Songdto ";
			query = manager.createQuery(jpql);

			List<Songdto> songdto = query.getResultList();
			for (Songdto song : songdto) {
				System.out.println("Playing all the songs \n " + song);
			}
			
			transaction.commit();
		} catch (Exception e) {
			System.out.println("PlayList Is Empty");
		}

	}

	public void choosesong() {

		try {
			openConnection();

			transaction.begin();
			jpql = "from Songdto ";
			query = manager.createQuery(jpql);

			List<Songdto> songdto = query.getResultList();
			for (Songdto song : songdto) {
				System.out.println("Playing all the songs \n " + song);
			}

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the song that you want to play");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				jpql = "from Songdto " + "where Number=1";
				query = manager.createQuery(jpql);
				List<Songdto> songdto1 = query.getResultList();
				for (Songdto song : songdto1) {
					System.out.println("Playing your selected songs \n " + song);
				}
				break;

			case 2:
				jpql = "from Songdto " + "where Number=2";
				query = manager.createQuery(jpql);
				List<Songdto> songdto2 = query.getResultList();
				for (Songdto song : songdto2) {
					System.out.println("Playing your selected songs \n " + song);
				}
				break;

			case 3:
				jpql = "from Songdto " + "where Number=3";
				query = manager.createQuery(jpql);
				List<Songdto> songdto3 = query.getResultList();
				for (Songdto song : songdto3) {
					System.out.println("Playing your selected songs \n " + song);
				}
				break;

			case 4:
				jpql = "from Songdto " + "where Number=4";
				query = manager.createQuery(jpql);
				List<Songdto> songdto4 = query.getResultList();
				for (Songdto song : songdto4) {
					System.out.println("Playing your selected songs \n " + song);
				}
				break;

			case 5:
				jpql = "from Songdto " + "where Number=5";
				query = manager.createQuery(jpql);
				List<Songdto> songdto5 = query.getResultList();
				for (Songdto song : songdto5) {
					System.out.println("Playing your selected songs \n " + song);
				}
				break;
			default:
				break;
			}
			transaction.commit();
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	public void randomSongs() {
		try {
			openConnection();
			transaction.begin();
			jpql = "from Songdto " + "where Number=3";
			query = manager.createQuery(jpql);
			List<Songdto> songdto3 = query.getResultList();
			for (Songdto song : songdto3) {
				System.out.println("Playing random song \n " + song);
			}
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void addSongs() {
		try {

			openConnection();
			transaction.begin();

			Scanner scanner = new Scanner(System.in);

			System.out.println(" 1]Kesariya" + "\n 2]Deva Deva" + "\n 3]Agar tum sath ho" + "\n 4]Mile ho tum humko"
					+ "\n 5]Allah waariyan" + "\n \nEnter the number of song that you want to add in playlist ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				Songdto songdto1 = new Songdto();
				songdto1.setNumber(1);
				songdto1.setName("Kesariya");
				songdto1.setSinger("Arijit singh");
				songdto1.setDuration(5.4);
				System.out.println("Song Added Into PlayList");

				manager.persist(songdto1);

				break;
			case 2:
				Songdto songdto2 = new Songdto();
				songdto2.setNumber(2);
				songdto2.setName("Deva Deva");
				songdto2.setSinger("Arijit singh");
				songdto2.setDuration(5.6);
				System.out.println("Song Added Into PlayList");

				manager.persist(songdto2);
				break;
			case 3:
				Songdto songdto3 = new Songdto();
				songdto3.setNumber(3);
				songdto3.setName("Agar tum sath ho");
				songdto3.setSinger("Atif aslam");
				songdto3.setDuration(5.7);
				System.out.println("Song Added Into PlayList");

				manager.persist(songdto3);
				break;
			case 4:

				Songdto songdto4 = new Songdto();
				songdto4.setNumber(4);
				songdto4.setName("Mile ho tum humko");
				songdto4.setSinger("Neha kakar");
				songdto4.setDuration(4.6);
				System.out.println("Song Added Into PlayList");

				manager.persist(songdto4);
				break;
			case 5:

				Songdto songdto5 = new Songdto();
				songdto5.setNumber(5);
				songdto5.setName("Allah waariyan");
				songdto5.setSinger("Atif aslam");
				songdto5.setDuration(4.8);
				System.out.println("Song Added Into PlayList");

				manager.persist(songdto5);
				break;
			default:
				System.out.println("Invalid choice try again");
				break;
			}

			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void removeSongs() {
		try {
			openConnection();
			transaction.begin();

			Scanner scanner = new Scanner(System.in);

			System.out.println(" 1]Kesariya" + "\n 2]Deva Deva" + "\n 3]Agar tum sath ho" + "\n 4]Mile ho tum humko"
					+ "\n 5]Allah waariyan" + "\n \nEnter the number of song that you want to remove from playlist ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				Songdto songdto1 = manager.find(Songdto.class, 1);
				manager.remove(songdto1);
				System.out.println("Song Deleted");
				break;

			case 2:
				Songdto songdto2 = manager.find(Songdto.class, 2);
				System.out.println("Song Deleted");
				manager.remove(songdto2);
				break;

			case 3:
				Songdto songdto3 = manager.find(Songdto.class, 3);
				System.out.println("Song Deleted");
				manager.remove(songdto3);
				break;

			case 4:
				Songdto songdto4 = manager.find(Songdto.class, 4);
				System.out.println("Song Deleted");
				manager.remove(songdto4);
				break;

			case 5:
				Songdto songdto5 = manager.find(Songdto.class, 5);
				System.out.println("Song Deleted");
				manager.remove(songdto5);
				break;
			case 6:
			default:
				System.out.println("Invalid choice try again");
				break;

			}
			scanner.close();
			transaction.commit();
		} catch (Throwable e) {
			System.out.println("No song to remove"); 
			System.out.println();
		}
	}

	public void editsong() {
		try {

			openConnection();
			transaction.begin();

			Songdto songdto = manager.find(Songdto.class, 2);
			songdto.setName("rasiya");

			manager.persist(songdto);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("PlayList is empty");
		}

	}
}
