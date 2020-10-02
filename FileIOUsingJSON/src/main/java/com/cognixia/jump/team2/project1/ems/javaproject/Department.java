package com.cognixia.jump.team2.project1.ems.javaproject;

import java.util.Set;

public class Department implements CRUDable<Department>{
	private long departmentId;
	private String name;
	private String phone;
	private String address;
	private long budget;
	private Set<Employee> listOfEmployees; 

	//@Override
	public void add(Department dep) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void remove(Department dep) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void update(Department dep) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}

	public Department(long departmentId, String name, String phone, String address, long budget,
			Set<Employee> listOfEmployees) {
		super();
		this.departmentId = departmentId;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.budget = budget;
		this.listOfEmployees = listOfEmployees;
	}

}
