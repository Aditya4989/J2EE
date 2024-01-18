package com.jspiders.musicplayerhibernate.dto;

import java.util.Scanner;

import com.jspiders.musicplayerhibernate.dao.SongOpeartionsdao;

public class musicplayerdto {

	public static void main(String[] args) {
		musicPlayer();
	}

	public static void musicPlayer() {

		SongOpeartionsdao song = new SongOpeartionsdao();

		System.out.println("@@@@@@@@Music Player@@@@@@");
		System.out.println("Menu");
		System.out.println("1.Play songs ");
		System.out.println("2.Add/Remove");
		System.out.println("3.Edit");
		System.out.println("4.Exit");

		boolean loop = true;

		while (loop == true) {
			Scanner scanner = new Scanner(System.in);

			int choice = scanner.nextInt();
			switch (choice) {

			case 1: {
				System.out.println("@@@@@@@@Play Songs@@@@@@");

				System.out.println("1.My Playlist");
				System.out.println("2.Play all songs");
				System.out.println("3.Choose song to play ");
				System.out.println("4.Play random song");
				System.out.println("5.Go back");
				int i = scanner.nextInt();

				switch (i) {
				case 1:
					song.myPlaylist();
					System.out.println();
					musicPlayer();
					break;
				case 2:
					song.playallsongs();
					System.out.println();
					musicPlayer();
					break;
				case 3:
					song.choosesong();
					System.out.println();
					musicPlayer();
					break;
				case 4:
					song.randomSongs();
					System.out.println();
					musicPlayer();
					break;
				case 5:
					musicPlayer();
					break;
				default:
					System.out.println("Invalid choice try again");
					musicPlayer();
					break;
				}

			}
				break;

			case 2: {
				System.out.println("@@@@@@@@Add/Remove@@@@@@");
				System.out.println("1.Add song");
				System.out.println("2.Remove song");
				System.out.println("3.Go back");
				int p = scanner.nextInt();

				switch (p) {
				case 1:
					song.addSongs();
					musicPlayer();
					break;
				case 2:
					song.removeSongs();
					musicPlayer();
					break;
				case 3:
					musicPlayer();
					break;

				default:
					System.out.println("Invalid choice try again");
					musicPlayer();
					break;

				}
			}
				break;

			case 3: {
				System.out.println("1.Edit details\n" + "2.Go Back\n");

				int p1 = scanner.nextInt();

				switch (p1) {
				case 1:
					song.editsong();

				case 2:
					musicPlayer();
					break;

				default:
					System.out.println("Invalid choice try again");
					musicPlayer();
					break;
				}
			}
				break;

			case 4:

			{
				System.out.println("@@@@@Thank you@@@@@");
			}
				break;

			default:
				System.out.println("Invalid Choice try again");
				musicPlayer();
				break;
			}
			loop = false;
			scanner.close();

		}

	}

}
