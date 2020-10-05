package com.cognixia.jump.javafinalproject.validation;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cognixia.jump.javafinalproject.validation.CompanyValidation.Regexes;


class TestValidation {

	CompanyValidation comV = new CompanyValidation();

	@Test
	void TestEmailValidation() {
		/*List<String> emails = new ArrayList<String>();
		emails.add("jud.doe@email.com");
		emails.add("mae@gmail.com");
		emails.add("jud.doe@gmail.co");

		emails.forEach( s ->
			System.out.println("Validating: " + s +" - it is " + comV.validateInput(s, Regexes.EMAIL) + "\n")
		);*/
		assertTrue(comV.validateInput("jud.doe@email.com", Regexes.EMAIL));
		assertTrue(comV.validateInput("mae@gmail.com", Regexes.EMAIL));
		assertTrue(!comV.validateInput("jud.doe@gmail.co", Regexes.EMAIL));

	}

	@Test
	void TestPhoneValidation() {
		/*List<String> phoneNumbers = new ArrayList<String>();
		phoneNumbers.add("555-555-5555");
		phoneNumbers.add("55-555-555555");
		phoneNumbers.add("1-546-454-4846");

		phoneNumbers.forEach( s ->
				System.out.println("Validating: " + s +" - it is " + comV.validateInput(s, Regexes.PHONE) + "\n")
		);
		*/
		assertTrue(comV.validateInput("555-555-5555", Regexes.PHONE));
		assertTrue(!comV.validateInput("55-555-555555", Regexes.PHONE));
		assertTrue(!comV.validateInput("1-546-454-4846", Regexes.PHONE));
	}

	@Test
	void TestAddressValidation() {
		/*List<String> addresses = new ArrayList<String>();
		addresses.add("123 Stillbrew Ln");
		addresses.add("Mill Brooks Ave");
		addresses.add("34 Mills tk");

		addresses.forEach( s ->
			System.out.println("Validating: " + s +" - it is " + comV.validateInput(s, Regexes.ADDRESS) + "\n")
		);
		*/
		assertTrue(comV.validateInput("123 Stillbrew Ln", Regexes.ADDRESS));
		assertTrue(!comV.validateInput("Mill Brooks Ave", Regexes.ADDRESS));
		assertTrue(comV.validateInput("34 Mills tk", Regexes.ADDRESS));
	}

}
