package com.cognixia.jump.javafinalproject.model;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.cognixia.jump.javafinalproject.console.DepartmentAttribute;
import com.cognixia.jump.javafinalproject.validation.ValidationAttribute;

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
			departments = new TreeSet<Department>();
	}
	
	public void add(Department e) {
		if (departments.contains(e)) return ;
		departments.add(e);
	}
	
	public void remove(Department e) {
		if (e.numOfEmployee() != 0) {
			System.out.println("There still have employee in the department");
			return ;
		}
		if (!departments.contains(e)) return ;
		departments.remove(e);
		System.out.println("Remove: " + e);
	}
	
	public void update(String attribute, 
			String updateValue, Department department) {
		try  {
			DepartmentAttribute dpAttribute = 
					DepartmentAttribute.valueOf(attribute);
			switch (dpAttribute) {
			case NAME:
				if (!ValidationAttribute.validWord(updateValue))
					break ;
				department.setName(updateValue);
				break;
			case PHONE:
				if (!ValidationAttribute.validPhone(updateValue))
					break ;
				department.setPhone(updateValue);
				break;
			case ADDRESS:
				if (!ValidationAttribute.validAddress(updateValue))
					break ;
				department.setAddress(updateValue);
				break;
			case BUDGET:
				if (!ValidationAttribute.validNumber(updateValue))
					break ;
				long budget = Long.parseLong(updateValue);
				department.setBudget(budget);
				break;
			default:
				System.out.println("Default attribute categlory");
				break;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Wrong department attribute categlory");
		}
	}

	public void list() {
		if (departments.size() == 0) return ;
		departments.forEach(System.out::println);
	}
	
	public Set<Department> getDepartments() {
		return departments;
	}
	
	public Department findDepartment(long departmentId) {
		
		Optional<Department> department = departments.parallelStream()
			.filter(dep -> dep.getDepartmentId() == departmentId)
			.findFirst();
		if (department.isEmpty()) return null;
		else return department.get();
	}
	
	public Department findDepartment(String name) {
		
		Optional<Department> department = departments.parallelStream()
			.filter(dep -> name.equalsIgnoreCase(dep.getName()))
			.findFirst();
		if (department.isEmpty()) return null;
		else return department.get();
	}
}