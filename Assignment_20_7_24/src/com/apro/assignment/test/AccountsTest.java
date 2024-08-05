package com.apro.assignment.test;

import java.util.Scanner;

import com.apro.assignment.model.Account;
import com.apro.assignment.model.CurrentAccount;
import com.apro.assignment.model.InsufficientBalanceException;
import com.apro.assignment.model.InvalidLoginException;
import com.apro.assignment.model.SavingsAccount;
import com.apro.assignment.model.ValidAmountException;

public class AccountsTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of total accounts: ");
        int n = scanner.nextInt();
        Account[] accounts = new Account[n];
        int count = 0;

        while (true) {
            System.out.println("\n1. Create Account \n2. Use Existing Account \n3. EXIT");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // Create Account
                	
                	if(count > n) {
                		System.out.println("Maximum number of accounts reached.");
                		return;
                	}
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    System.out.println("Select account type: \n1. Savings\n2. Current");
                    int accountType = scanner.nextInt();

                    if (accountType == 1) {
                        System.out.print("Enter minimum balance: ");
                        double minBalance = scanner.nextDouble();
                        accounts[count] = new SavingsAccount(username, balance, minBalance);
                    } else if (accountType == 2) {
                        System.out.print("Enter overdraft limit: ");
                        double overdraftLimit = scanner.nextDouble();
                        accounts[count] = new CurrentAccount(username, balance, overdraftLimit);
                    } else {
                        System.out.println("Invalid account type selected.");
                        continue;
                    }

                    accounts[count].setUserPassword(password);
                    System.out.println("Account created successfully with Account No: " + accounts[count].getAccountNo());
                    count++;
                    break;

                case 2: // Use Existing Account
                    System.out.print("Enter Account Number: ");
                    long accountNo = scanner.nextLong();
                    Account presentAccount = null;
                    
                    presentAccount = accountFinder(count,accounts,presentAccount,accountNo);                    
                    if(presentAccount == null) {
                    	System.out.println("Account not found.");
                    	return;
                    }
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.next();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.next();
                    try {
                    if(!presentAccount.login(loginUsername, loginPassword))
                    	 System.out.println("Login was successful.");
                    	 
                    }catch(InvalidLoginException exception) {
                    	System.out.println(exception.getMessage());
                    }
                    boolean sessionActive = true;

                    while (sessionActive) {
                        System.out.println("\n1. Check Balance \n2. Credit Money \n3. Debit Money \n4. EXIT");
                        System.out.print("Please choose an option: ");
                        int option = scanner.nextInt();
                        sessionActive = menuDriver2(option,presentAccount,scanner,sessionActive);
                    }
                    break;

                case 3: // Exit
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private static boolean menuDriver2(int option, Account presentAccount,Scanner scanner, boolean sessionActive) {

        switch (option) {
            case 1:
                System.out.println("Current Balance: $" + presentAccount.getBalance());
                break;
            case 2:
            	try {
            	      System.out.print("Enter amount to credit: ");
                      double creditAmt = scanner.nextDouble();
                      if(presentAccount instanceof CurrentAccount) {
                      	((CurrentAccount)presentAccount).credit(creditAmt); 
                      }else if(presentAccount instanceof SavingsAccount) {
                      	presentAccount.credit(creditAmt);
                      }
				} catch (ValidAmountException exception) {
					System.out.println(exception.getMessage());
				}
                break;
            case 3:
            	try {
                    System.out.print("Enter amount to debit: ");
                    double debitAmt = scanner.nextDouble();
                    if (presentAccount instanceof SavingsAccount) {
                        ((SavingsAccount) presentAccount).debit(debitAmt);
                    } else if (presentAccount instanceof CurrentAccount) {
                       ( (CurrentAccount)presentAccount).debit(debitAmt);
                    }
				} catch (InsufficientBalanceException exception) {
					System.out.println(exception.getMessage());
				}catch(ValidAmountException exception) {
					System.out.println(exception.getMessage());
				}
                break;
            case 4:
                sessionActive = false;
                System.out.println("Logged out. Thanks for visiting.");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
		return sessionActive;
    }
    
    private static Account accountFinder(int count,Account accounts[],Account presentAccount,long accountNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].compareAccountNo(accountNo)) {
                presentAccount = accounts[i];
                break;
            }
        }
        return presentAccount;
    }
}
