package com.cognixia.jump.javafinalproject.console;

public final class Questions {

	public static final String SELECT_CATEGORY = 
			"Please chose one categlory, or type 'BACK' go back to main select";
	
	public static final String[] CATEGORY = {
			"Employee",
			"Department"
	};
	
	public static final String[] ADD_EMPLOYEE = {

			"Enter Last Name:", 
			"Enter First Name:", 
			"Enter Age",
			"Enter Position:",
			"Enter Salary",
			"Enter Email:", 
			"Enter Phone:",
			"Enter Address",
	};
	
	public static final String[] ADD_DEPARTMENT = {

			"Enter Name:", 
			"Enter Phone:",
			"Enter Address",
			"Enter Budget",
	};
	
	public static final String REMOVE_EMPLOYEE = 
			"Enter the Employee UserID/email to be REMOVED";
	
	public static final String REMOVE_DEPARTMENT = 
			"Enter the Department name to be REMOVED";

	public static final String UPDATE_EMPLOYEE = 
			"Enter: [Category] [newValue]: \n" + "Type BACK to exit Update";
	
	public static final String UPDATE_DEPARTMENT = 
			"Enter: [Category] [newValue]: \n" + "Type BACK to exit Update";
	
	
	public static final String LIST_EMPLOYEE =
			"Enter the Department name to show the employees list";
}
