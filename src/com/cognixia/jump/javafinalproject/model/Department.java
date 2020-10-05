package com.cognixia.jump.javafinalproject.model;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.cognixia.jump.javafinalproject.console.EmployeeAttribute;
import com.cognixia.jump.javafinalproject.validation.ValidationAttribute;

public class Department implements Comparable<Department> {

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
		DEPARTMENT_ID = departmentId + 1;
	}

	public Department(String name, String phone, String address, long budget) {
		super();
		this.departmentId = DEPARTMENT_ID;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.budget = budget;
		DEPARTMENT_ID++;
		if (employees == null) employees = new TreeSet<Employee>();
	}
	
	public void add(Employee e) {
		if (employees.contains(e)) return ;
		employees.add(e);
	}
	
	public void remove(Employee e, boolean isUpdate) {
		if (!employees.contains(e)) return ;
		employees.remove(e);
		if (isUpdate) System.out.println("Update department of: " + e);
		else System.out.println("Remove: " + e);
	}
	
	public void update(String attribute, String updateValue, 
			Employee employee) {
		try {
			EmployeeAttribute epAttribute = 
					EmployeeAttribute.valueOf(attribute);
			switch (epAttribute) {
			case LASTNAME:
				if (!ValidationAttribute.validWord(updateValue))
					break;
				employee.setLastName(updateValue);
				break;
			case FIRSTNAME:
				if (!ValidationAttribute.validWord(updateValue))
					break;
				employee.setFirstName(updateValue);
				break;
			case AGE:
				if (!ValidationAttribute.validNumber(updateValue)
						|| !ValidationAttribute.validAge(updateValue))
					break;
				int age = Integer.parseInt(updateValue);
				employee.setAge(age);
				break;
			case POSITION:
				if (!ValidationAttribute.validWord(updateValue))
					break;
				employee.setPosition(updateValue);
				break;
			case SALARY:
				if (!ValidationAttribute.validNumber(updateValue))
					break ;
				double salary = Double.parseDouble(updateValue);
				employee.setSalary(salary);
				break;
			case EMAIL:
				if (!ValidationAttribute.validEmail(updateValue))
					break;
				employee.setEmail(updateValue);
				break;
			case PHONE:
				if (!ValidationAttribute.validPhone(updateValue))
					break;
				employee.setPhone(updateValue);
				break;
			case ADDRESS:
				if (!ValidationAttribute.validAddress(updateValue))
					break;
				employee.setAddress(updateValue);
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
		if (employees.size() == 0) return ;
		employees.forEach(System.out::println);
	}
	
	public int numOfEmployee() {
		return employees.size();
	}
	
	// Getter and Setter methods
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	public long getDepartmentId() {
		return departmentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBudget(long budget) {
		this.budget = budget;
	}

	public void printCurrentAttribute() {
		
		System.out.println("Name: " + name);
		System.out.println("phone: " + phone);
		System.out.println("address: " + address);
		System.out.println("budget: " + budget + "\n");
	}
	
	
	
	public Employee findEmployee(long userId) {
		
		Optional<Employee> employee = employees.parallelStream()
			.filter(emp -> emp.getUserId() == userId)
			.findFirst();
		if (employee.isEmpty()) return null;
		else return employee.get();
	}
	
	public Employee findEmployee(String email) {
		
		Optional<Employee> employee = employees.parallelStream()
			.filter(emp -> emp.getEmail().equalsIgnoreCase(email))
			.findFirst();
		if (employee.isEmpty()) return null;
		else return employee.get();
	}
	
    @Override
    public int compareTo(Department d) {
    	return (int)(getDepartmentId() - d.getDepartmentId());
    }

	@Override
	public String toString() {
		return departmentId + "," + name + "," + phone + ","
				+ address + "," + budget;
	}
}
