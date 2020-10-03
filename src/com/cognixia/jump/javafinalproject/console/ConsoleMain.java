package com.cognixia.jump.javafinalproject.console;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

import com.cognixia.jump.javafinalproject.file.*;
import com.cognixia.jump.javafinalproject.model.*;

public class ConsoleMain {
	
	public static final String WELCOME_MESSAGE = "Hello, welcome to Team 2 \n";
	public static final String MENU_CATEGORY = 
			"Please chose one of the commands\n" + 
			"ADD, UPDATE, REMOVE, LIST, or EXIT to close the program";

	public static void main(String[] args) {
		
		Company company = new Company("Team 2");
		FileIO file = new FileIO();
		initializeCompany(company, file);
		Scanner scan = new Scanner(System.in).useDelimiter("\\n");
		ConsoleManager consoleManager = new ConsoleManager(scan, company);
		
		System.out.println(WELCOME_MESSAGE);
		String line;
		while (true) {
			System.out.println(MENU_CATEGORY);
			line = scan.next();
			if (line.equalsIgnoreCase("exit"))
				break ;
			startConsole(line, consoleManager);
		}
		scan.close();
		storedCompany(company, file);
	}
	
	
	private static void startConsole(String line, ConsoleManager consoleManger) {
		
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
	
	private static void initializeCompany(Company company, FileIO file) {
		
		
		//READING THE CSV FILE AND STORING TO THE SET 
		
		try {
			file.readDepartmentCSV(company);
			file.saveToSet(company);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void storedCompany(Company company, FileIO file) {
		
		//WRITE THE CONTENTS TO THE CSV FILE 
		try {
			//how to insert the column values 
			//file.writeToFile(e1);
			Set<Department> deparments = company.getDepartments();
			file.writeToDepartmentsCSV(deparments);
			file.replaceFileTest(deparments);
//			for (Department d: deparments) {
//				file.replaceFileTest(d.getEmployees());
//			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
