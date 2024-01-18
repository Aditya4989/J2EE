package com.jspiders.maven.maven_project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Scanner scanner = new Scanner(System.in);
		Person person = new Person();
		PersonCRUD crud = new PersonCRUD();
		boolean condition = true;
		do {
			System.out.println(
					"Enter the choice\n1.SavePerson \n2.UpdatePerson \n3.DeletePerson \n4.GetPersonById \n5.GetALLPersons \n6.Exit ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				System.out.println("Enter Name");
				String name = scanner.next();
				System.out.println("Enter Phone Number");
				Long phone = scanner.nextLong();
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				crud.savePerson(person);
			}
				break;

			case 2: {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				System.out.println("Enter Name");
				String name = scanner.next();
				System.out.println("Enter Phone Number");
				Long phone = scanner.nextLong();
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				crud.updatePerson(person);
			}
				break;

			case 3: {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				crud.deletePerson(id);
			}
				break;

			case 4: {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				crud.getPersonById(id);
			}
				break;

			case 5: {
				crud.getAllPersons();
				System.out.println();
			}
				break;
			default:
				condition = false;
			}
		} while (condition);

	}
}
