package com.cognixia.jump.javafinalproject.console;

public enum EmployeeAttribute {
	
	DEPARTMENTID("DEPARTMENTID"),
	FIRSTNAME("FIRSTNAME"),
	LASTNAME("LASTNAME"),
	AGE("AGE"),
	POSITION("POSITION"),
	SALARY("SALARY"),
	EMAIL("EMAIL"),
	PHONE("PHONE"),
	ADDRESS("ADDRESS");
	
	private String attribute;
	
	private EmployeeAttribute(String attribute) {
		this.attribute = attribute;
	}
}
