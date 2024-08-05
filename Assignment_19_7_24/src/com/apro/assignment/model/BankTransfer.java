package com.apro.assignment.model;

public class BankTransfer implements Payment{

	
	public void processPayment() {
		System.out.println("Proceesing payment via Bank transfer");
		
	}

	
	public void refund() {
		System.out.println("Processing refund for payment via Bank Transfer");
		
	}

}
