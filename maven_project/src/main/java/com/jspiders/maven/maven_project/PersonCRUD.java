package com.jspiders.maven.maven_project;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class PersonCRUD {
	
	public Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
	FileInputStream fileInputStream = new FileInputStream("dbconfiguration.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			
			Class.forName(properties.getProperty("className"));
			Connection connection = DriverManager.getConnection(properties.getProperty("url"),
					properties.getProperty("user"),properties.getProperty("password"));
			return connection;
	}
	
	public void savePerson(Person person) throws SQLException, ClassNotFoundException, IOException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PERSON VALUES (?,?,?)");
		preparedStatement.setInt(1,person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3,person.getPhone());

		int count = preparedStatement.executeUpdate();
		if (count==1) {
			System.out.println("Inserted");
		}else {
			System.out.println("Not Inserted");
		}
		connection.close();
		
	}
	public void updatePerson(Person person) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("Update person Set name= ?, phone= ? where id=?");
		
		preparedStatement.setString(1, person.getName());
		preparedStatement.setLong(2,person.getPhone());
		preparedStatement.setInt(3,person.getId());
		int count = preparedStatement.executeUpdate();
		if(count==1)
		{
			System.out.println("updated");
		}
		else
		{
			System.out.println("not updated");
		}
		connection.close();
	}
	public void deletePerson(int id) throws ClassNotFoundException, SQLException, IOException
	 {
		 Connection connection=getConnection();
		 PreparedStatement preparedStatement =connection.prepareStatement("Delete from Person where id=?");
		 preparedStatement.setInt(1, id);
		 int count=preparedStatement.executeUpdate();
		 if(count==1)
		 {
			 System.out.println("Deleted");
		 }
		 else
		 {
			 System.out.println("Not Deleted");
		 }
		 connection.close();
	 }
	 public void getPersonById(int id) throws ClassNotFoundException, SQLException, IOException
	 {
		 Connection connection =getConnection();
		 PreparedStatement preparedStatement = connection.prepareStatement("select * from person where id = ?");
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getLong(3));
			}
			connection.close();
		 
	 }
	 public void getAllPersons() throws ClassNotFoundException, SQLException, IOException
	 {
		 Connection connection =getConnection();
		 PreparedStatement preparedStatement = connection.prepareStatement("Select * from Person");
			
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				System.out.print(resultSet.getInt(1)+"\t");
				System.out.print(resultSet.getString("name")+"\t");
				System.out.print(resultSet.getLong(3)+"\n");
			}
			connection.close(); 
	 }
}
