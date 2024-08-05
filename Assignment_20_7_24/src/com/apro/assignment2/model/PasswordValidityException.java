package com.apro.assignment2.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidityException extends RuntimeException {
	private String password;
	
	public PasswordValidityException(String password) {
		this.password = password;
	}

	public String getMessage() {
		StringBuilder message = new StringBuilder("Invalid password.\n");

		if (!isAtLeast8CharactersLong(password)) {
			message.append("Your password must be at least 8 characters long.\n");
		}
		if (!containsLowerCaseCharacter(password)) {
			message.append("Your password should contain at least one lowercase letter.\n");
		}
		if (!containsUpperCaseCharacter(password)) {
			message.append("Your password should contain at least one uppercase letter.\n");
		}
		if (!containsSpecialCharacter(password)) {
			message.append("Your password should contain at least one special character.\n");
		}
		if (!containsDigit(password)) {
			message.append("Your password should contain at least one digit.\n");
		}

		return message.toString();
	}

	private boolean isAtLeast8CharactersLong(String password) {
		return password.length() >= 8;
	}

	private boolean containsUpperCaseCharacter(String password) {
		return !password.equals(password.toLowerCase());
	}

	private boolean containsLowerCaseCharacter(String password) {
		return !password.equals(password.toUpperCase());
	}

	private boolean containsSpecialCharacter(String password) {
		Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = specialCharPattern.matcher(password);
		return matcher.find();
	}

	private boolean containsDigit(String password) {
		Pattern digitPattern = Pattern.compile("[0-9]");
		Matcher matcher = digitPattern.matcher(password);
		return matcher.find();
	}

}
