package com.apro.assignments;

import java.util.Scanner;

public class AMTSimulator {
	private static String pass="7123";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ATM pin:");
		String pin = sc.next();
		if( pin.equals(pass)){
			float balance = (float)(Math.random() *1000000) + 1000;
			System.out.println("WELCOME Customer");
			boolean flag = true;
			while(flag) {
				System.out.println("\n1.Check Balance \n2.Deposit Money \n3.Withdraw Money \n4.EXIT");
				System.out.println("Please choose an option: ");
				int choice = sc.nextInt();
				switch(choice) {
				case 1: // check balance
					System.out.println(" Your current Balance is : $"+ balance);
					break;
				case 2: // deposit money
					System.out.println("Enter the amount to deposit :");
					float depositAMT = sc.nextFloat();
					balance += depositAMT;
					System.out.println("\nAmount $"+depositAMT+" deposited successfully. \n Your update balance is :$"+balance);
					break;
				case 3: // withdraw
					System.out.println("Enter the amount to withdraw :");
					float withdrawAMT = sc.nextFloat();
					if(withdrawAMT<= balance) {
						balance -= withdrawAMT;
						System.out.println("\nAmount $"+withdrawAMT+" withdrawn successfully. \n Your update balance is :$"+balance);
						break;
					}else {
						System.out.println("\nyour Balance is not suficient");
					}
				case 4: // EXIT
					flag = false;
					System.out.println("\nThanks for visiting our ATM.");
					break;
				default:
					System.out.println("Select a Valid option");
					break;
				}
			}
		}else
			System.out.println("Invalid Pin!");
		
		sc.close();
	}
}
