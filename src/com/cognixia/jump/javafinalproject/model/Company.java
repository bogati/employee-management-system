package com.cognixia.jump.javafinalproject.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Company {

	private static long COMPANY_ID = 1;
	
	private long companyId;
	private String name;
	private Set<Department> departments;
	
	public Company(String name) {
		
		companyId = COMPANY_ID;
		COMPANY_ID++;
		this.name = name;
		if (departments == null)
			departments = new HashSet<Department>();
	}
	
	public void add(Department e) {
		if (departments.contains(e)) return ;
		departments.add(e);
	}
	
	public void remove(Department e) {
		if (!departments.contains(e)) return ;
		departments.remove(e);
	}
	
	public void update(Department o, Department n) {
		if (departments.contains(o)) return ;
		departments.remove(o);
		departments.add(n);
	}

	public void list() {
		if (departments.size() == 0) return ;
		departments.parallelStream().forEach(System.out::println);
	}
	
	public Department findDepartment(long departmentId) {
		
		Optional<Department> department = departments.parallelStream()
			.filter(dep -> dep.getDepartmentId() == departmentId)
			.findFirst();
		if (department.isEmpty()) return null;
		else return department.get();
	}
	
	public Department findDepartment(String name) {
		
		System.out.println("name: " + name);
		Optional<Department> department = departments.parallelStream()
			.filter(dep -> name.equalsIgnoreCase(dep.getName()))
			.findFirst();
		if (department.isEmpty()) return null;
		else return department.get();
	}
}