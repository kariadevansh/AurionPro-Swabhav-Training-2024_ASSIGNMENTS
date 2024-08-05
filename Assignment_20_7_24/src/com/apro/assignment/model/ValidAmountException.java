package com.apro.assignment.model;

public class ValidAmountException extends RuntimeException{
	private double amount;

	public ValidAmountException(double amount) {
		this.amount = amount;
	}
	
	public String getMessage() {
		return "Invalid amount :"+amount+". Enter a valid amount";
	}
}
