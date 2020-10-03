package com.cognixia.jump.javafinalproject.validation;

import com.cognixia.jump.javafinalproject.validation.CompanyValidation.Regexes;

public class ValidationAttribute {

	private static CompanyValidation companyValidation = 
			new CompanyValidation();
	
	public static boolean validWord(String name) {
		if (companyValidation
				.validateInput(name, Regexes.WORD)) {
			return true;
		}
		System.out.println("Invalid word, only alphabet is allow");
		return false;
	}
	
	public static boolean validPhone(String phone) {
		return companyValidation
				.validateInput(phone, Regexes.PHONE);
	}
	
	public static boolean validAddress(String address) {
		if (companyValidation
				.validateInput(address, Regexes.ADDRESS)) {
			return true;
		}
		System.out.println("Invalid address, please try again");
		return false;
	}
	
	public static boolean validNumber(String number) {
		
		if (companyValidation
				.validateInput(number, Regexes.NUMBER)) {
			return true;
		}
		System.out.println("Invalid number, please try again");
		return false;
	}
	
	public static boolean validEmail(String email) {
		
		if (companyValidation
				.validateInput(email, Regexes.EMAIL)) {
			return true;
		}
		System.out.println("Invalid email, please try again");
		return false;
	}
	
	public static String changeFirstLetterUpper(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
}
