package com.apro.assignment.model;

public class PayPal implements Payment{

	
	public void processPayment() {
		System.out.println("Processing payment via PayPal");
		
	}

	public void refund() {
		System.out.println("Processing refund for payment made via Paypal");
		
	}

}
