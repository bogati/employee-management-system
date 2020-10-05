package com.cognixia.jump.javafinalproject.console;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

import com.cognixia.jump.javafinalproject.file.*;
import com.cognixia.jump.javafinalproject.model.*;

public class ConsoleMain {
	
	
	public static String HEADER_FILEPATH = "resources/header.txt";
	public static String SIMPLE_INSTRUCTION = 
			"Type ADD, UPDATE, REMOVE, LIST to continue \n" +
			"HELP for more infromation\n\n";

	public static void main(String[] args) {
		
		String instructions = displayHeader();
		Company company = new Company("Team 2");
		FileIO file = new FileIO();
		initializeCompany(company, file);
		Scanner scan = new Scanner(System.in).useDelimiter("\\n");
		ConsoleManager consoleManager = new ConsoleManager(scan, company);
		
		System.out.println(instructions);
		String line;
		while (true) {
			System.out.println(SIMPLE_INSTRUCTION);
			line = scan.next();
			if (line.equalsIgnoreCase("exit"))
				break ;
			startConsole(line, consoleManager, instructions);
		}
		scan.close();
		storedCompany(company, file);
	}
	
	private static String displayHeader() {
		try {
			File file = new File(HEADER_FILEPATH);
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);

			String str = new String(data, "UTF-8");
			fis.close();
			return str;
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open the header file");
		} catch (IOException e) {
			System.out.println("Cannot read the header file");
		}
		return "Opps. Header not working";

	}
	
	private static void startConsole(String line, 
			ConsoleManager consoleManger, String instructions) {
		
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
			case HELP:
				System.out.println(instructions);
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
