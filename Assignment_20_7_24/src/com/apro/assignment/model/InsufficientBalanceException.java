package com.apro.assignment.model;

public class InsufficientBalanceException extends RuntimeException{
	private double balance;

	public InsufficientBalanceException(double balance) {
		this.balance = balance;
	}

	public String getMessage() {
		return "you dont have sufficient balance!!"+balance;
	}
	
}
