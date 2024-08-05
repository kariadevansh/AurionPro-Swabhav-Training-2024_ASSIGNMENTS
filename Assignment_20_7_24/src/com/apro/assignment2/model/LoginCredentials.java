package com.apro.assignment2.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginCredentials {
	private String mailId;
	private String password;
	
	public LoginCredentials() {
		this.mailId = "";
		this.password = "";
	}
	public LoginCredentials(String mailId) {
		this.mailId = mailId;
		this.password = "";
	}
	
	public LoginCredentials(String mailId, String password) {
		this.mailId = mailId;
		this.password = password;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void vaildateMailId(String mailId) {
			 // Regular expression for a valid email address
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

	        Pattern pattern = Pattern.compile(emailRegex);
	        Matcher matcher = pattern.matcher(mailId);
	        
	        if (!matcher.matches())
	        	throw new MailIdValidityException(mailId);
	        
	        System.out.println(mailId + " is a valid emailID.");
	}
	
	public void validatePassword(String password) {
		 String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

	        Pattern pattern = Pattern.compile(passwordRegex);
	        Matcher matcher = pattern.matcher(password);
	        
	        if (!matcher.matches())
	        	throw new PasswordValidityException(password);
	        
	        System.out.println(" It is a valid password.");      
	}
	@Override
	public String toString() {
		return "LoginCredentials  [mailId=" + mailId + ", password=" + password + "]";
	}
}
