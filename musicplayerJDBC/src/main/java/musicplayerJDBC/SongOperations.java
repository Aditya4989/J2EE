package musicplayerJDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;


public class SongOperations {
	
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static ResultSet resultSet;
	private static int result=0;
	private static Scanner scanner = new Scanner(System.in);

	public Connection getConnection() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("dbConfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		connection = DriverManager.getConnection(properties.getProperty("url"), 
				properties.getProperty("user"), properties.getProperty("password"));
		
		return connection;
	}
	
	public void playAllSong() throws Exception {
		connection = getConnection();
		query = "select * from song";
		statement = connection.createStatement();
		resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.println(resultSet.getString("title") + " song is now playing.... ");
		}
		connection.close();
		statement.close();
		resultSet.close();	
	}
	
	public void playRandomSong() throws Exception {
		connection = getConnection();
		query = "select * from song order by rand() limit 1";
		statement = connection.createStatement();
		resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.println(resultSet.getString("title") + " song is now playing.... ");
		}
		connection.close();
		statement.close();
		resultSet.close();	
	}
	
	
	
	public void chooseSong() throws Exception {
		connection = getConnection();
		System.out.println("Select song to play.");
		viewAllSongs();
		query = "select * from song where id = ?";
//		statement = connection.createStatement();
		preparedStatement = connection.prepareStatement(query);
		int a= scanner.nextInt();
		preparedStatement.setInt(1, a);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getString("title") + "song is now playing.....");
		}
		connection.close();
		statement.close();
		resultSet.close();	
	}
	
	public void viewAllSongs() throws Exception {
		connection = getConnection();
		query = "select * from song";
		statement = connection.createStatement();
		resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id") + " | " 
						+ resultSet.getString("title") + " | " 
						+ resultSet.getString("singer") + " | " 
						+ resultSet.getDouble("duration") + " | " 
						+ resultSet.getString("album"));
		}
//		connection.close();
//		statement.close();
//		resultSet.close();	
	}
	
	public void addSong() throws Exception {
		connection = getConnection();
		System.out.println("How many song you want to be add");
		int a = scanner.nextInt();
		for (int i = 0; i < a; i++) {
			preparedStatement = connection
					.prepareStatement("Insert into song values(?,?,?,?,?)");
			System.out.println("Enter song id = ");
			preparedStatement.setInt(1,scanner.nextInt());
			System.out.println("Enter song title = ");
			preparedStatement.setString(2,scanner.next());
			System.out.println("Enter song singer = ");
			preparedStatement.setString(3,scanner.next());
			System.out.println("Enter song duration = ");
			preparedStatement.setDouble(4,scanner.nextDouble());
			System.out.println("Enter song album = ");
			preparedStatement.setString(5,scanner.next());
			
			result = result + preparedStatement.executeUpdate();		
		}
			System.out.println(result + " Song added Successfully...!!!");
		result=0;
		connection.close();
		preparedStatement.close();
		resultSet.close();	
	}
	
	
	public void removeSong() throws Exception {
		connection = getConnection();
		System.out.println("Please choose a song for remove : ");
		viewAllSongs();
		query = "delete from song where id = ?";
		preparedStatement = connection.prepareStatement(query);
		System.out.println("Enter the song to remove : ");
		preparedStatement.setInt(1, scanner.nextInt());
		result = preparedStatement.executeUpdate();
		System.out.println(result + " record remove successfully..!!");
		System.out.println("After Remove song:");
		viewAllSongs();
		result = 0;
		connection.close();
		preparedStatement.close();
		resultSet.close();	
	}
	
	public void editSong() throws Exception {
		connection = getConnection();
		System.out.println("Select song to edit");
		viewAllSongs();
		query = "update song set title = ?,singer = ?,duration = ?, album =? where id = ?";
		preparedStatement = connection.prepareStatement(query);
		System.out.println("Enter new title");
		preparedStatement.setString(1, scanner.next());
		System.out.println("Enter new singer");
		preparedStatement.setString(2, scanner.next());
		System.out.println("Enter new duration");
		preparedStatement.setDouble(3, scanner.nextDouble());
		System.out.println("Enter new album");
		preparedStatement.setString(4, scanner.next());
		System.out.println("Enter the song to edit : ");
		preparedStatement.setInt(5, scanner.nextInt());

		result = preparedStatement.executeUpdate();
		System.out.println(result + " record updated successfully..!!");
		viewAllSongs();
		result = 0;
		
		
		connection.close();
		preparedStatement.close();
		resultSet.close();	
	}

}
