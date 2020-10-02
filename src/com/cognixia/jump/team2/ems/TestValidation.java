package com.cognixia.jump.team2.ems;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//import java.util.ArrayList;
//import java.util.List;
import org.junit.jupiter.api.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ems.prod.validation.CompanyValidation;
import com.ems.prod.validation.CompanyValidation.Regexes;

//import jdk.nashorn.internal.parser.JSONParser;

public class TestValidation {
	CompanyValidation comV = new CompanyValidation();
	static final String EMPLOYEE_FILE = "Departments.csv";
	static final String DEPARTMENT_FILE = "Employees.csv";
	static final String JSON_TEST_FILE = "testFile.json";
	
	@Test
	void TestEmailValidation() {
		assertTrue(comV.validateInput("jud.doe@email.com", Regexes.EMAIL));
		assertTrue(comV.validateInput("mae@gmail.com", Regexes.EMAIL));
		assertTrue(!comV.validateInput("jud.doe@gmail.co", Regexes.EMAIL));
		
	}
	
	@Test
	void TestPhoneValidation() {
		assertTrue(comV.validateInput("555-555-5555", Regexes.PHONE));
		assertTrue(!comV.validateInput("55-555-555555", Regexes.PHONE));
		assertTrue(!comV.validateInput("1-546-454-4846", Regexes.PHONE));
	}
	
	@Test
	void TestAddressValidation() {
		assertTrue(comV.validateInput("123 Stillbrew Ln", Regexes.ADDRESS));
		assertTrue(!comV.validateInput("Mill Brooks Ave", Regexes.ADDRESS));
		assertTrue(comV.validateInput("34 Mills tk", Regexes.ADDRESS));
	}
	
	@Test
	void TestFileReader() {
		TestReadJson();
		
	}
	
	@Test
	void TestReadJson() {
		Object obj;
		try {
			obj = new JSONParser().parse(new FileReader(JSON_TEST_FILE));
			JSONObject jo = (JSONObject) obj;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
