package com.apro.assignment.model;

import java.util.Scanner;

public class CreditCard implements Payment{
	private double creditcardLMT;
	private double paymentAMT;
	private int pinCode;
	
	public CreditCard(double creditcardLMT, double paymentAMT, int pinCode) {
		super();
		this.creditcardLMT = creditcardLMT;
		this.paymentAMT = paymentAMT;
		this.pinCode = pinCode;
	}

	Scanner sc = new Scanner(System.in);
	public void processPayment() {
		System.out.println("Processing payment via credit card");	
		if(creditcardLMT==0) {
			System.out.println("limit reached, cant process");
			return;
		}
		if(creditcardLMT< paymentAMT) {
			System.out.println("the amount is exceeding the credit card limit");
			return;
		}
		System.out.println("Enter pin code:");
		int pin = sc.nextInt();
		if(pin!=pinCode) {
			System.out.println("Invalid pin");
			return;
		}
		creditcardLMT -= paymentAMT;
		System.out.println("Payment successful, your remaining credit card limit is :"+ creditcardLMT);
	}

	public void refund() {
		System.out.println("Processing refund for payment made via credit card");
		
	}

}
