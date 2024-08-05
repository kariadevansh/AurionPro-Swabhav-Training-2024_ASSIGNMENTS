package com.apro.assignment.model;

import java.util.Random;

public class BankAccountApp {
	private String userName;
	private String userPassword;
	private long accountNo;
	private double userBalance;
	public BankAccountApp() {
		userName = " ";
		userPassword = " ";
	}
	public boolean compareUserName(String username) {
		 return this.userName.equals(username);
	}
	
	public void setUserName(String username) {
		 this.userName = username;
	}
	public void setPassword(String password) {
		this.userPassword = password;
	}
	
	public void setBalance(double balance) {
		this.userBalance = balance;
	}
	
	public void setAccountNumber() {
		Random random = new Random();
		this.accountNo = 1000000000L + Math.abs(random.nextLong()) % 9000000000L;	 
	}
	
	public void getUserName() {
		System.out.println("User Name: "+userName);
	}
	public void getBalance() {
		System.out.println("Balance : Rs."+userBalance);
	}public void getAccountNo() {
		System.out.println("Account Number : "+ accountNo);
	}
	
	public void createNewAccount(String username,String password, Double balance ) {
		setUserName(username);
		setPassword(password);
		setBalance(balance);
		setAccountNumber();
		
		System.out.println("Account created successfully \nYour account number is ");
		getAccountNo();
		System.out.println("And your current balance is :");
		getBalance();
	}
	
	public boolean compareAccountNo(long accountNo) {
		if(this.accountNo == accountNo)
			return true;
		else
			return false;
	}
	
	public boolean login(String username, String password) {
		boolean loginFlag = true;
		if(userName.equals(username) && userPassword.equals(password) ) {
			System.out.println("Login successful");
			loginFlag =true;
		}else {
			if(userName.equals(username) == false)
				System.out.println("Invalid username");
			else
				System.out.println("Invalid password"); 
			loginFlag = false;
		}
		return loginFlag;
	}
	
	public void deposit(double depositAMT) {
		userBalance += depositAMT;
		System.out.println("\nAmount $"+depositAMT+" deposited successfully. \n Your update balance is :$"+userBalance);
	}
	
	public void withdraw(double withdrawAMT) {
		if(withdrawAMT<= userBalance) {
			userBalance -= withdrawAMT;
			System.out.println("\nAmount $"+withdrawAMT+" withdrawn successfully. \n Your update balance is :$"+userBalance);
		}else {
			System.out.println("\nyour Balance is not sufficient");
		}
	}
}
