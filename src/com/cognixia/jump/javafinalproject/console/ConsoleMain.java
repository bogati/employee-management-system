package com.cognixia.jump.javafinalproject.console;

import java.util.Scanner;
import com.cognixia.jump.javafinalproject.model.*;

public class ConsoleMain {
	
	public static final String WELCOME_MESSAGE = "Hello, welcome to Team 2 \n";
	public static final String MENU_CATEGLORY = 
			"Please chose one of the commands\n" + 
			"ADD, UPDATE, REMOVE, LIST, or EXIT to close the program";

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Company company = new Company("Team 2");
		initializeCompany(company);
		ConsoleManager consoleManger = new ConsoleManager(scan, company);
		
		System.out.println(WELCOME_MESSAGE);
		String line;
		while (true) {
			System.out.println(MENU_CATEGLORY);
			line = scan.next();
			if (line.equalsIgnoreCase("exit"))
				break ;
			startConsole(line, consoleManger);
		}
		scan.close();
	}
	
	
	public static void startConsole(String line, ConsoleManager consoleManger) {
		
		try  {
			Commands command = Commands.valueOf(line.toUpperCase());
			switch (command) {
			case ADD:
				consoleManger.add();
				break;
			case UPDATE:
				consoleManger.update();
				break;
			case REMOVE:
				consoleManger.remove();
				break;
			case LIST:
				consoleManger.list();
				break;
			default:
				break;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Wrong command categlory");
		}
	}
	
	public static void initializeCompany(Company company) {
		
		Department department = new Department("Software", "389-234-2523", "USA", 1000000);
		company.add(department);
		department.add(new Employee(department.getDepartmentId(), "Bob", "Tom", 
				100, "student", 100, "cj@gmaile.com", "234985", "USA"));
		department.add(new Employee(department.getDepartmentId(), "Ted", "Jerry", 
				100, "student", 100, "tj@gmaile.com", "234985", "USA"));
		department.add(new Employee(department.getDepartmentId(), "Pop", "lis", 
				100, "student", 100, "pl@gmaile.com", "234985", "USA"));
	}
}
