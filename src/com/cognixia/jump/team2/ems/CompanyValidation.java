package com.cognixia.jump.team2.ems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompanyValidation {
	
	public enum Regexes {
		EMAIL("[a-zA-Z]*.[a-zA-Z]*@[a-zA-Z]*.(org|com)"),
		PHONE("\\d{3}-\\d{3}-\\d{4}"),
		ADDRESS("\\d{1,3} [a-zA-Z]* [a-zA-Z]*"),
		DEFAULT("");
		
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
		
		if(str.isBlank()) {
			return false;
		}
		
		Pattern pattern = Pattern.compile(reg.getRegex());
		Matcher mat = pattern.matcher(str);
		
		return mat.matches();
	}
	
}
