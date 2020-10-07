package com.cognixia.jump.javafinalproject.console;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import com.cognixia.jump.javafinalproject.model.*;
import com.cognixia.jump.javafinalproject.validation.ValidationAttribute;


public class ConsoleManager {

	private Scanner scan;
	private Company company;
	private boolean reWrite;
	private List<String> answers;
	
	public ConsoleManager(Scanner scan, Company company) {
		
		this.scan = scan;
		this.company = company;
		this.reWrite = false;
		answers = new ArrayList<String>();
	}
	
    //================================================================================
    // add
    //================================================================================	
	
	public void add() {
		
		String categlory = selectCateglory();
		if (categlory == null) return ;
		
		Department department = null;
		String answer;
		String[] question;

		if (categlory.equalsIgnoreCase(Questions.CATEGORY[0])) {
			department = askToFindDepartment();
			question = Questions.ADD_EMPLOYEE;
			if (department == null) return ;
		} else question = Questions.ADD_DEPARTMENT;
		
		final int addQuestionsLength = question.length;
		for (int i = 0; i < addQuestionsLength; i++) {
			System.out.println(question[i]);
			answer = scan.next().strip();
			if (answer.equalsIgnoreCase(Commands.BACK.name())) {
				return ;
			}
			if (!validationCheck(answer, categlory, i)) i--;
			else answers.add(answer);
		}
		if (categlory.equalsIgnoreCase(Questions.CATEGORY[0]))				
			addEmployee(department);
		else addDepartment();
	}
	
	private void addEmployee(Department department) {
		
		if (answers.size() != Questions.ADD_EMPLOYEE.length) 
			return ;
		try {
			String firstName = ValidationAttribute
					.changeFirstLetterUpper(answers.get(0));
			String lastName = ValidationAttribute
					.changeFirstLetterUpper(answers.get(1));
			int age = Integer.parseInt(answers.get(2));
			String position = answers.get(3);
			double salary = Double.parseDouble(answers.get(4));
			String email = answers.get(5);
			String phone = answers.get(6);
			String address = answers.get(7);
			department.add(new Employee(department.getDepartmentId(), 
					lastName, firstName, age, position, 
					salary, email, phone, address));
		} catch (NumberFormatException e) {
			answers.clear();
			System.out.println("Cannot cast to number in addDepartment()");
		}
		answers.clear();
	}
	
	private void addDepartment() {
		
		if (answers.size() != Questions.ADD_DEPARTMENT.length) 
			return ;
		try {
			String name = ValidationAttribute
					.changeFirstLetterUpper(answers.get(0));
			String phone = answers.get(1);
			String address = answers.get(2);
			long budget = Long.parseLong(answers.get(3));
			company.add(new Department(name, phone, address, budget));
			
		} catch (NumberFormatException e) {
			answers.clear();
			System.out.println("Cannot cast to number in addDepartment()");
		}
		answers.clear();
	}
	
	 //================================================================================
    // remove
    //================================================================================	
	
	public void remove() {
		
		String categlory = selectCateglory();
		if (categlory == null) return ;

		Department department = askToFindDepartment();
		if (department == null) return ;
		if (categlory.equalsIgnoreCase(Questions.CATEGORY[0])) {
			System.out.println(Questions.REMOVE_EMPLOYEE);
			Employee employee = askToFindEmployee(department);
			if (employee == null) return ;
			department.remove(employee);
		} else {
			company.remove(department);
		}
		reWrite = true;
	}
	
	 //================================================================================
    // update
    //================================================================================	
	
	
	public void update() {
		String categlory = selectCateglory();
		if (categlory == null) return ;

		Department department = askToFindDepartment();
		if (department == null) return ;
		if (categlory.equalsIgnoreCase(Questions.CATEGORY[0])) {
			Employee employee = askToFindEmployee(department);
			if (employee == null) return ;
			updateEmployee(employee, department);
		} else {
			updateDepartment(department);
		}
		reWrite = true;
	}
	
	private void updateEmployee(Employee employee, Department department) {
		
		while(true) {
			employee.printCurrentAttribute();
			System.out.println(Questions.UPDATE_EMPLOYEE);
			String line = scan.next().strip();
			if (line.equalsIgnoreCase(Commands.BACK.name())) return ;
			answers = Arrays.asList(line.split(" "));
			System.out.println("line: " + line);
			System.out.println("answers" + answers);
			if (answers.size() == 2) {
				final String attribute = answers.get(0).toUpperCase();
				final String updateValue = 
						(attribute.equalsIgnoreCase("address")) 
						? addressFromAnswer() : answers.get(1);
				if (attribute.equalsIgnoreCase("departmentId")) {
					long departmentId = Long.parseLong(updateValue);
					Department newDepartment = company.findDepartment(departmentId);
					if (newDepartment == null) return ;
					newDepartment.add(employee);
					department.remove(employee);
					employee.setDepartmentId(departmentId);
				} else department.update(attribute, 
						updateValue, employee);
			}
		}
	}
	
	private void updateDepartment(Department department) {
		
		while(true) {
			department.printCurrentAttribute();
			System.out.println(Questions.UPDATE_DEPARTMENT);
			String line = scan.next().strip();
			if (line.equalsIgnoreCase(Commands.BACK.name())) return ;
			answers = Arrays.asList(line.split(" "));
			if (answers.size() >= 2) {
				final String attribute = answers.get(0).toUpperCase();
				final String updateValue = 
						(attribute.equalsIgnoreCase("address")) 
						? addressFromAnswer() : answers.get(1);
				company.update(attribute, updateValue, department);
			}
		}
	}
	
	 //================================================================================
    // list
    //================================================================================	
	
	
	public void list() {
		
		String category = selectCateglory();	
		if (category == null) return ;
		if (category.equalsIgnoreCase(Questions.CATEGORY[0])) { //if you entered employee
			Department department = askToFindDepartment();
			if (department == null) return;
			department.list();
		} else {
			company.list();
			System.out.println();
		}
	}
	
	 //================================================================================
    // Helper methods
    //================================================================================	
	
	private String selectCateglory() {
		
		while (true) {
			System.out.println("\n" + Questions.SELECT_CATEGORY);
			Stream.of(Questions.CATEGORY).forEach(q -> System.out.print(q + " "));
			String category = scan.next().strip();
			if (category.equalsIgnoreCase(Commands.BACK.name())) return null;
			if (Stream.of(Questions.CATEGORY)
			.anyMatch(category::equalsIgnoreCase)) {
				return category;
			}
		}
	}
	
	private Department askToFindDepartment() {
		
		System.out.println("Enter the deparment name/id");
		String line = scan.next().strip();
		if (line.equalsIgnoreCase(Commands.BACK.name())) return null;
		Department department;
	    try {
			long departmentId = Long.parseLong(line);
			department = company.findDepartment(departmentId);
	    } catch (NumberFormatException e) {
	        department = company.findDepartment(line);
	    }
	    if (department == null) {
	    	System.out.println("Cannot find that department, please try again \n"
	    			+ "Enter back to got back to the main selection");
	    	askToFindDepartment();
	    }
	    return department;
	}
	
	private Employee askToFindEmployee(Department department) {
		
		System.out.println("Enter the Employee UserId/Email");
		String line = scan.next();
		if (line.equalsIgnoreCase(Commands.BACK.name())) return null;
		Employee employee;
	    try {
			long userId = Long.parseLong(line);
			employee = department.findEmployee(userId);
	    } catch (NumberFormatException e) {
	        employee = department.findEmployee(line);
	    }
	    if (employee == null) {
	    	System.out.println("Cannot find that employee, please try again \n"
	    			+ "Enter back to got back to the main selection");
	    	askToFindEmployee(department);
	    }
	    return employee;
	}
	
	private String addressFromAnswer() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < answers.size(); i++) {
			sb.append(answers.get(i));
			sb.append(" ");
		}
		return sb.toString();
	}
	

	private boolean validationCheck(String updateValue, String categlory, int index) {
		
		if (categlory.equalsIgnoreCase(Questions.CATEGORY[0]))				
			return validateEmployee(updateValue, index + 1);
		return validateDepartment(updateValue, index);
	}
	
	private boolean validateEmployee(String updateValue, int index) {
		EmployeeAttribute[] epAttribute = 
				EmployeeAttribute.values();
		switch (epAttribute[index]) {
		case FIRSTNAME:
			if (ValidationAttribute.validWord(updateValue))
				return true;
			break;
		case LASTNAME:
			if (ValidationAttribute.validWord(updateValue))
				return true;
			break;
		case AGE:
			if (ValidationAttribute.validNumber(updateValue)
					&& ValidationAttribute.validAge(updateValue))
				return true;
			break;
		case POSITION:
			if (ValidationAttribute.validWord(updateValue))
				return true;
			break;
		case SALARY:
			if (ValidationAttribute.validNumber(updateValue))
				return true ;
			break;
		case EMAIL:
			if (ValidationAttribute.validEmail(updateValue))
				return true;
			break;
		case PHONE:
			if (ValidationAttribute.validPhone(updateValue))
				return true;
			break;
		case ADDRESS:
			if (ValidationAttribute.validAddress(updateValue))
				return true;
			break;
		default:
			break;
		}
		return false;
	}
	
	private boolean validateDepartment(String updateValue, int index) {
		
		DepartmentAttribute dpAttribute[] = 
				DepartmentAttribute.values();

		switch (dpAttribute[index]) {
		case NAME:
			if (ValidationAttribute.validWord(updateValue))
				return true;
			break;
		case PHONE:
			if (ValidationAttribute.validPhone(updateValue))
				return true ;
			break;
		case ADDRESS:
			if (ValidationAttribute.validAddress(updateValue))
				return true ;
			break;
		case BUDGET:
			if (ValidationAttribute.validNumber(updateValue))
				return true;
			break;
		default:
			break;
		}
		return false;
	}
	


	public boolean isReWrite() {
		return reWrite;
	}
}
