package com.cognixia.jump.javafinalproject.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CompanyValidation {

	public enum Regexes {
		EMAIL("[a-zA-Z]*.[a-zA-Z]*@[a-zA-Z]*.(org|com)"), 
		PHONE("\\d{3}-\\d{3}-\\d{4}"),
		ADDRESS("\\d{1,3} [a-zA-Z]* [a-zA-Z]*"),
		ADDRESS_1("\\d{1,3} [a-zA-Z]* [a-zA-Z]* [a-zA-Z]*, [a-zA-Z]*{2}"),
		ADDRESS_2("\\d{1,3} [a-zA-Z]* [a-zA-Z]* [a-zA-Z]* [a-zA-Z]*, [a-zA-Z]*{2}"),
		NUMBER("^[0-9]+$"),
		WORD("^[a-zA-Z]+$"),
		DEFAULT("");;

		private final String regex;

		Regexes(String str) {
			this.regex = str;
		}

		public String getRegex() {
			return regex;
		}

	}

	public boolean validateInput(String str, Regexes reg) {
		
		if(reg == null) {
			reg = Regexes.DEFAULT;
		}
		
		if (str.isBlank() || str.contains(",")) {
			return false;
		} 
		
		if(reg == Regexes.ADDRESS) {
			Pattern addr1 = Pattern.compile(reg.getRegex());
			Pattern addr2 = Pattern.compile(Regexes.ADDRESS_1.getRegex());
			Pattern addr3 = Pattern.compile(Regexes.ADDRESS_2.getRegex());
			
			return ( addr1.matcher(str).matches() ||
				     addr2.matcher(str).matches() ||
				     addr3.matcher(str).matches());
		}
		
		Pattern pattern = Pattern.compile(reg.getRegex());
		Matcher mat = pattern.matcher(str);

		return mat.matches();
	}

}
