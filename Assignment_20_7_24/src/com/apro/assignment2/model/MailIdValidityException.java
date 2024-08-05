package com.apro.assignment2.model;

public class MailIdValidityException extends RuntimeException{
	private String mailId;

	public MailIdValidityException(String mailId) {
		this.mailId = mailId;
	}
	
	public String getMessage() {
		return "the mailId :"+mailId+" is not valid.\n please enter a correct mailId";
	}
	
}
