package com.cognixia.jump.javafinalproject.console;

public enum DepartmentAttribute {

	NAME("NAME"),
	PHONE("PHONE"),
	ADDRESS("ADDRESS"),
	BUDGET("BUDGET");
	
	private String attribute;
	
	private DepartmentAttribute(String attribute) {
		this.attribute = attribute;
	}
}
