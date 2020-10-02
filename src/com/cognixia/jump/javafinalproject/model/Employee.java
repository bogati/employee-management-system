package com.cognixia.jump.javafinalproject.model;

public class Employee {
	private static long USER_ID = 1;
	private long userId;
	private long departmentId;
	private String lastName;
	private String firstName;
	private int age;
	private String position;
	private int salary;
	private String email;
	private String phone;
	private String address;
	
	public Employee(long userID, long departmentId, String lastName, 
			String firstName, int age, String position,
			int salary, String email, String phone, String address) {
		
		this(departmentId, lastName, firstName, age, 
				position, salary, email, phone, address);
		this.userId = userID;
	}
	
	public Employee(long departmentId, String lastName, String firstName, 
			int age, String position, int salary, String email, String phone, 
			String address) {
		super();
		this.userId = USER_ID;
		this.departmentId = departmentId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.email = email;
		this.phone = phone;
		this.address = address;
		USER_ID++;
	}

	// Implement toString for CSV file
	@Override
	public String toString() {
		return userId + "," + departmentId + "," + lastName
				+ "," + firstName + "," + age + "," + position + "," + salary
				+ "," + email + "," + phone + "," + address;
	}
	
	
	
}	
