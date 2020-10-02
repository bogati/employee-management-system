package com.cognixia.jump.team2.project1.ems.javaproject;

public class Employee implements CRUDable<Employee>{
	private long employeeId;
	private long departmentId;
	private String firstName;
	private String lastName;
	private int age;
	private String position;
	private int salary;
	private String email;
	private String phone;
	private String address;

	//@Override
	public void add(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void remove(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void update(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}

	public Employee(long employeeId, long departmentId, String firstName,String lastName, int age, String position,
			int salary, String email, String phone, String address) {
		super();
		this.employeeId = employeeId;
		this.departmentId = departmentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
