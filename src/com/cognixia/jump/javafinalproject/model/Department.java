package com.cognixia.jump.javafinalproject.model;

import java.util.HashSet;
import java.util.Set;

public class Department {

	private static long DEPARTMENT_ID = 1;
	private long departmentId;
	private String name;
	private String phone;
	private String address;
	private long budget;
	private Set<Employee> employees;
	
	public Department(long departmentId, String name, String phone, String address, long budget) {
		this(name, phone, address, budget);
		this.departmentId = departmentId;
	}

	public Department(String name, String phone, String address, long budget) {
		super();
		this.departmentId = DEPARTMENT_ID;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.budget = budget;
		DEPARTMENT_ID++;
		if (employees == null) employees = new HashSet<Employee>();
	}
	
	public void add(Employee e) {
		if (employees.contains(e)) return ;
		employees.add(e);
	}
	
	public void remove(Employee e) {
		if (!employees.contains(e)) return ;
		employees.remove(e);
	}
	
	public void update(Employee o, Employee n) {
		if (employees.contains(o)) return ;
		employees.remove(o);
		employees.add(n);
	}

	public void list() {
		if (employees.size() == 0) return ;
		employees.forEach(System.out::println);
	}
	
	// Getter and Setter methods
	public long getDepartmentId() {
		return departmentId;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return departmentId + "," + name + "," + phone + ","
				+ address + "," + budget;
	}
}
