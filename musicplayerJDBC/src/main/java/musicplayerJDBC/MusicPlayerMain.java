package musicplayerJDBC;

import java.util.Scanner;

public class MusicPlayerMain {

	private static Scanner scanner =new Scanner(System.in);
	private static int choice;
	static boolean loop = true;
	static SongOperations operations = new SongOperations();
	
	public static void main(String[] args) throws Exception {
		while (loop) {
			musicPlayerMenu();
		}
	}
	
	public static void musicPlayerMenu() throws Exception {
		System.out.println("=======Menu=======");
		System.out.println("1. Play Songs \n"+ "2. Add/Remove songs \n" + "3. Edit Song \n" + "4. Exit \n");
		choice=scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("1. Play All Songs \n"+ "2. Play Random songs \n" + "3. Choose to play \n" + "4. Go Back \n");
			choice=scanner.nextInt();
			switch (choice) {
			case 1:
				operations.playAllSong();
				break;
			case 2:
				operations.playRandomSong();
				break;
			case 3:
				operations.chooseSong();
				break;
			case 4:
				musicPlayerMenu();
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			break;
		case 2:
			System.out.println("1. Add Song \n"+ "2. Remove Song \n" + "3. Go Back \n");
			choice=scanner.nextInt();
			switch (choice) {
			case 1:
				operations.addSong();
				break;
			case 2:
				operations.removeSong();
				break;
			case 3:
				musicPlayerMenu();
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			break;
		case 3:
			System.out.println("1. Select Song to edit \n" + "2. Go Back \n");
			choice=scanner.nextInt();
			switch (choice) {
			case 1:
				operations.editSong();
				break;
			case 2:
				musicPlayerMenu();
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			break;
		case 4:
			System.out.println("Thank You...!!");
			loop = false;
			break;
		default:
			System.out.println("invalid input");
			break;
		}
		
	}
	
}
