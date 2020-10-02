package com.cognixia.jump.javafinalproject.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class ConsoleManager {

	private Scanner scan;
	private boolean isAdded;
	private List<String> answers;
	
	public ConsoleManager(Scanner scan) {
		
		this.scan = scan;
		isAdded = false;
		answers = new ArrayList<String>();
	}
	
	public List<String> getAnswers() { return answers; }
	public boolean isAdded() { return isAdded; }
	
	public void removeAnswer() { isAdded = false;}
	
	//TODO Check email duplication for Employee and Name duplication for department
	public void add() {
		
		String categlory = selectCateglory();
		if (categlory == null) return ;
		answers.add(Commands.ADD.name());
		answers.add(categlory);
		String[] question = categlory.equals(Questions.CATEGORY[0]) ?
				Questions.ADD_EMPLOYEE : Questions.ADD_DEPARTMENT;
		final int addQuestionsLength = question.length;
		String answer;
		for (int i = 0; i < addQuestionsLength; i++) {
			System.out.println(question[i]);
			answer = scan.next();
			if (answer.equalsIgnoreCase(Commands.BACK.name())) {
				answers.clear();
				return ;
			}
			if (!tempValidationCheck(answer)) i--;
			else answers.add(answer);
		}
		isAdded = true;
	}
	
	public void remove() {
		
		String categlory = selectCateglory();
		if (categlory == null) return ;
		answers.add(Commands.REMOVE.name());
		answers.add(categlory);
		String question = categlory.equals(Questions.CATEGORY[0]) ?
				Questions.REMOVE_EMPLOYEE : Questions.REMOVE_DEPARTMENT;
		while (true) {	
			System.out.println(question);
			String answer = scan.next();
			if (answer.equalsIgnoreCase(Commands.BACK.name())) {
				answers.clear();
				return ;
			}
			if (tempValidationCheck(answer)) {
				isAdded = true;
				break ;
			}
		}
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
		answers.add(Commands.UPDATE.name());
		answers.add(categlory);
		String answer;
		for (int i = 1; i < addQuestionsLength; i++) {
			System.out.println(question[i]);
			answer = scan.next();
			if (answer.equalsIgnoreCase(Commands.BACK.name())) {
				answers.clear();
				return ;
			}
			if (!tempValidationCheck(answer)) i--;
			else answers.add(answer);
		}
		isAdded = true;
	}
	
	public void list() {
		
		
	}
	
	public String selectCateglory() {
		
		System.out.println(Questions.SELECT_CATEGORY);
		Stream.of(Questions.CATEGORY).forEach(q -> System.out.print(q + " "));
		String categlory = scan.next().toUpperCase();
		if (categlory.equalsIgnoreCase(Commands.BACK.name())) return null;
		if (categlory == null || 
				!Stream.of(Questions.CATEGORY).anyMatch(categlory::equals))
			selectCateglory();
		return categlory;
	}
	
	//TODO temp for testing
	public boolean tempValidationCheck(String s) {
		return true;
	}
}
