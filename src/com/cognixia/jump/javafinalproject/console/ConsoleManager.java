package com.cognixia.jump.javafinalproject.console;


import java.util.Scanner;
import java.util.stream.Stream;

import com.cognixia.jump.javafinalproject.model.*;


public class ConsoleManager {

	private Scanner scan;
	private Company company;
	private boolean reWrite;
	
	public ConsoleManager(Scanner scan, Company company) {
		
		this.scan = scan;
		this.company = company;
		this.reWrite = false;
	}
	
	//TODO Check email duplication for Employee and Name duplication for department
	public void add() {
		
		String categlory = selectCateglory();
		if (categlory == null) return ;

		
		String[] question = categlory.equals(Questions.CATEGORY[0]) ?
				Questions.ADD_EMPLOYEE : Questions.ADD_DEPARTMENT;
		final int addQuestionsLength = question.length;
		String answer;
		for (int i = 0; i < addQuestionsLength; i++) {
			System.out.println(question[i]);
			answer = scan.next();
			if (answer.equalsIgnoreCase(Commands.BACK.name())) {
				return ;
			}
			if (!tempValidationCheck(answer)) i--;
//			else answers.add(answer);
		}
	}
	
	public void remove() {
		
		String categlory = selectCateglory();
		if (categlory == null) return ;

		String question = categlory.equals(Questions.CATEGORY[0]) ?
				Questions.REMOVE_EMPLOYEE : Questions.REMOVE_DEPARTMENT;
		while (true) {	
			System.out.println(question);
			String answer = scan.next();
			if (answer.equalsIgnoreCase(Commands.BACK.name())) {
				return ;
			}
			if (tempValidationCheck(answer)) {
				break ;
			}
		}
		reWrite = true;
	}
	
	
	//TODO implement the update, check if it exist
	public void update() {
		String categlory = selectCateglory();
		if (categlory == null) return ;
		String[] question = categlory.equals(Questions.CATEGORY[0]) ?
				Questions.UPDATE_EMPLOYEE : Questions.UPDATE_DEPARTMENT;
		//TODO Wait until find the item(Employee/Department)
//		while(item == null) {
//			System.out.println(question[0]);
//			item = T.find()
//		}
		final int addQuestionsLength = question.length;
		String answer;
		for (int i = 1; i < addQuestionsLength; i++) {
			System.out.println(question[i]);
			answer = scan.next();
			if (answer.equalsIgnoreCase(Commands.BACK.name())) {
				return ;
			}
			if (!tempValidationCheck(answer)) i--;
		}
		reWrite = true;
	}
	
	public void list() {
		
		String categlory = selectCateglory();
		if (categlory == null) return ;
		if (categlory.equalsIgnoreCase(Questions.CATEGORY[0])) {
			System.out.println("Enter the deparment name/id");
			String line = scan.next();
			Department department;
		    try {
				long departmentId = Long.parseLong(line);
				department = company.findDepartment(departmentId);
		    } catch (NumberFormatException nfe) {
		        department = company.findDepartment(line);
		    }
			if (department == null) return;
			department.list();
		} else {
			company.list();
		}
	}
	
	public String selectCateglory() {
		
		System.out.println(Questions.SELECT_CATEGORY);
		Stream.of(Questions.CATEGORY).forEach(q -> System.out.print(q + " "));
		String categlory = scan.next().toUpperCase();
		System.out.println("categlory: " + categlory);
		if (categlory.equalsIgnoreCase(Commands.BACK.name())) return null;
		if (categlory == null || 
				!Stream.of(Questions.CATEGORY).anyMatch(categlory::equalsIgnoreCase))
			selectCateglory();
		return categlory;
	}
	
	//TODO temp for testing
	public boolean tempValidationCheck(String s) {
		return true;
	}


	public boolean isReWrite() {
		return reWrite;
	}
}
