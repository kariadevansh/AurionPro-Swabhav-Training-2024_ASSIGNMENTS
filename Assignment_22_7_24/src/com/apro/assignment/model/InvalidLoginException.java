package com.apro.assignment.model;

public class InvalidLoginException extends RuntimeException{
	public String getMessage() {
		return "Invalid Login Credentials";
	}
	
}
