package com.cognixia.jump.javafinalproject.model;

public class Employee implements Comparable<Employee> {
	private static long USER_ID = 1;
	private long userId;
	private long departmentId;
	private String firstName;
	private String lastName;
	private int age;
	private String position;
	private double salary;
	private String email;
	private String phone;
	private String address;
	
	public Employee(long userID, long departmentId, String lastName, 
			String firstName, int age, String position,
			double salary, String email, String phone, String address) {
		
		this(departmentId, lastName, firstName, age, 
				position, salary, email, phone, address);
		this.userId = userID;
		if (userID > USER_ID) USER_ID = userID + 1;
	}
	
	public Employee(long departmentId, String lastName, String firstName, 
			int age, String position, double salary, String email, String phone, 
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
	
	public long getUserId() {
		return userId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void printCurrentAttribute() {
		
		System.out.println("departmentId: " + departmentId);
		System.out.println("lastName: " + lastName);
		System.out.println("firstName: " + firstName);
		System.out.println("age: " + age);
		System.out.println("position: " + position);
		System.out.println("salary: " + salary);
		System.out.println("email: " + email);
		System.out.println("address: " + address + "\n");
	}
	
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int compareTo(Employee e) {
		return (int)(getUserId() - e.getUserId());
	}

	// Implement toString for CSV file
	@Override
	public String toString() {
		return userId + "," + departmentId + "," + firstName
				+ "," + lastName + "," + age + "," + position + "," + salary
				+ "," + email + "," + phone + "," + address;
	}
	
}	
