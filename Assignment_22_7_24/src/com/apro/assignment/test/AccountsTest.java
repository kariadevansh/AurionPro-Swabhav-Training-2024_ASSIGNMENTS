package com.apro.assignment.test;

import java.util.ArrayList;
import java.util.List;
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
        List<Account> accounts = new ArrayList<>();
        
        while (true) {
            System.out.println("\n1. Create Account \n2. Use Existing Account \n3. EXIT");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // Create Account
                    if(accounts.size() >= n) {
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
                        accounts.add(new SavingsAccount(username, balance, minBalance));
                    } else if (accountType == 2) {
                        System.out.print("Enter overdraft limit: ");
                        double overdraftLimit = scanner.nextDouble();
                        accounts.add(new CurrentAccount(username, balance, overdraftLimit));
                    } else {
                        System.out.println("Invalid account type selected.");
                        continue;
                    }

                    accounts.get(accounts.size() - 1).setUserPassword(password);
                    System.out.println("Account created successfully with Account No: " + accounts.get(accounts.size() - 1).getAccountNo());
                    break;

                case 2: // Use Existing Account
                    System.out.print("Enter Account Number: ");
                    long accountNo = scanner.nextLong();
                    Account presentAccount = accountFinder(accounts, accountNo);                    
                    if (presentAccount == null) {
                        System.out.println("Account not found.");
                        return;
                    }
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.next();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.next();
                    try {
                        if (!presentAccount.login(loginUsername, loginPassword)) {
                            System.out.println("Login was successful.");
                        }
                    } catch (InvalidLoginException exception) {
                        System.out.println(exception.getMessage());
                    }
                    boolean sessionActive = true;

                    while (sessionActive) {
                        System.out.println("\n1. Check Balance \n2. Credit Money \n3. Debit Money \n4. EXIT");
                        System.out.print("Please choose an option: ");
                        int option = scanner.nextInt();
                        sessionActive = menuDriver2(option, presentAccount, scanner, sessionActive);
                    }
                    break;

                case 3: // Exit
                	displayAccountsInDescendingOrder(accounts);
                    System.out.println("\nThe account with the maximum balance is : "+accounts.get(0));
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static boolean menuDriver2(int option, Account presentAccount, Scanner scanner, boolean sessionActive) {

        switch (option) {
            case 1:
                System.out.println("Current Balance: $" + presentAccount.getBalance());
                break;
            case 2:
                try {
                    System.out.print("Enter amount to credit: ");
                    double creditAmt = scanner.nextDouble();
                    if (presentAccount instanceof CurrentAccount) {
                        ((CurrentAccount) presentAccount).credit(creditAmt);
                    } else if (presentAccount instanceof SavingsAccount) {
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
                        ((CurrentAccount) presentAccount).debit(debitAmt);
                    }
                } catch (InsufficientBalanceException | ValidAmountException exception) {
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

    private static Account accountFinder(List<Account> accounts, long accountNo) {
        for (Account acc : accounts) {
            if (acc.compareAccountNo(accountNo)) {
                return acc;
            }
        }
        return null;
    }
    
    private static void displayAccountsInDescendingOrder(List<Account> accounts) {
    	sortAcrossTheList(accounts);
    	displayList(accounts);
    }
    private static void compareEachListElement(List<Account> accounts, int i) {
        for (int j = i + 1; j < accounts.size(); j++) {
            if (accounts.get(i).getBalance() < accounts.get(j).getBalance()) {
                // Swap accounts at position i and j
                Account temp = accounts.get(i);
                accounts.set(i, accounts.get(j));
                accounts.set(j, temp);
            }
        }
    }
    
    private static void sortAcrossTheList(List<Account> accounts) {
       	for (int i = 0; i < accounts.size() - 1; i++) {
    		compareEachListElement(accounts,i);
    	}
    }
    
    private static void displayList(List<Account> accounts) {
    	for(Account account:accounts)
    		System.out.println(account);
    }
    
    
}
