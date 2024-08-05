package com.apro.assignment.test;

import com.apro.assignment.model.BankTransfer;
import com.apro.assignment.model.CreditCard;
import com.apro.assignment.model.PayPal;
import com.apro.assignment.model.Payment;

public class PaymentTest {
	public static void main(String[] args) {
		Payment payments;
		
		payments =  new CreditCard(10000,5000,1234);
		payments.processPayment();
		
		payments = new BankTransfer();
		payments.processPayment();
		
		payments = new PayPal();
		payments.processPayment();
		
	}
}
