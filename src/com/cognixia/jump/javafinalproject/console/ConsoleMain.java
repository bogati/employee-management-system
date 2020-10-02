package com.cognixia.jump.javafinalproject.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMain {
	
	public static final String WELCOME_MESSAGE = "Hello, welcome to Team 2 \n";
	public static final String MENU_CATEGLORY = 
			"Please chose one of the commands\n" + 
			"ADD, UPDATE, REMOVE, LIST, or EXIT to close the program";

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ConsoleManager consoleManger = new ConsoleManager(scan);
		
		System.out.println(WELCOME_MESSAGE);
		String line;
		while (true) {
			System.out.println(MENU_CATEGLORY);
			line = scan.next();
			if (line.equalsIgnoreCase("exit"))
				break ;
			startConsole(line, consoleManger);
			if (consoleManger.isAdded()) {
				consoleManger
					.getAnswers()
					.stream()
					.forEach(System.out::println);
			}
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
}
