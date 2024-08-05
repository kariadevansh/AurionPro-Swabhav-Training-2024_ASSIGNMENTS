package com.apro.assignment.test;

import java.util.Scanner;

import com.apro.assignment.model.BankAccountApp;


public class BankAccountAppTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankAccountApp customers[] = new BankAccountApp[10];
		boolean flag = true;
		int count =0;
		for (int i = 0; i < 10; i++) {
		    customers[i] = new BankAccountApp(); 
		}
		while(flag) {
			System.out.println("\n1.Create Account \n2.Use existing account \n3.EXIT");
			System.out.println("Please choose an option: ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1: //create account
				System.out.println("Create a user name: ");
				String username = sc.next();
				boolean userFlag = false;
				if(count <10 ) {
					for(int i =0;i<10;i++) {
						if(customers[i].compareUserName(username) == true) {
							System.out.println(" username already exists");
							userFlag = false;
							break;
						}else
							userFlag = true;
					}
					if(userFlag == true) {
						System.out.println("Create a password:");
						String password = sc.next();
						
						System.out.println("Enter the amount you are depositing as you are opening a new account: ");
						double balance = sc.nextDouble();
						
//						if(count ==0)
							customers[count].createNewAccount(username, password, balance);
//						else
//							customer2.createNewAccount(username, password, balance);
						count++;
						break;
					}else {
						break;
					}
				}else {
//					System.out.println("Create a password:");
//					String password = sc.next();
//					
//					System.out.println("Enter the amount you are depositing as you are opening a new account: ");
//					double balance = sc.nextDouble();
//					customers[count].createNewAccount(username, password, balance);
//					count++;
//					break;
					System.out.println("Cant create more accounts");
				}
				
				
			case 2: // using existing account     //TODO use a loop to login in the correct account object
				System.out.println("Enter Account Number:");
				long accountNo = sc.nextLong();
				boolean accFlag = false;
				for(int i=0;i<count;i++) {
					if(customers[i].compareAccountNo(accountNo) == true) {
						System.out.println("Enter your username: \nEnter your password:");
						String username1 = sc.next();
						String password1 = sc.next();

						boolean loginFlag = customers[i].login(username1, password1);
						if(loginFlag == true) {
							System.out.println("WELCOME Customer");
							boolean flag2 = true;
							while(flag2) {
								System.out.println("\n1.Check Balance \n2.Deposit Money \n3.Withdraw Money \n4.EXIT");
								System.out.println("Please choose an option: ");
								int choice2 = sc.nextInt();
								switch(choice2) {
								case 1: // check balance
									customers[i].getBalance();
									break;
								case 2: // deposit money
									System.out.println("Enter the amount to deposit :");
									float depositAMT = sc.nextFloat();
									customers[i].deposit(depositAMT);
									break;
								case 3: // withdraw
									System.out.println("Enter the amount to withdraw :");
									float withdrawAMT = sc.nextFloat();
									customers[i].withdraw(withdrawAMT);
									break;
								case 4: // EXIT
									flag2 = false;
									System.out.println("\nThanks for visiting our Bank.");
									break;
								default:
									System.out.println("Select a Valid option");
									break;
								}
							}
						}
						accFlag = true;
						break;
					}
				}
				if(accFlag == false)
					System.out.println("Invalid account number");
				break;
				
			case 3://Exit
				flag = false;
				System.out.println("\nBye Bye.");
				break;
			default:
				System.out.println("Select a Valid option");
				break;
			}
			
			System.out.println("-----------------------");
	
		}
		sc.close();
	}
}
