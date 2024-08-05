package com.apro.assignment.model;

import java.util.Random;

public class Account {
    private String userName;
    private String userPassword;
    private long accountNo;
    private double userBalance;

    public Account() {
        this.userName = "";
        this.userPassword = "";
    }

    public Account(String userName, double userBalance) {
        this.userName = userName;
        this.userBalance = userBalance;
        setAccountNo();
    }

    private void setAccountNo() {
        Random random = new Random();
        this.accountNo = 1000000000L + Math.abs(random.nextLong()) % 9000000000L; 
    }

    public long getAccountNo() {
        return accountNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public double getBalance() {
        return userBalance;
    }

    public void setBalance(double userBalance) {
        this.userBalance = userBalance;
    }

    public boolean compareUserName(String username) {
        return this.userName.equals(username);
    }

    public boolean compareAccountNo(long accountNo) {
        return this.accountNo == accountNo;
    }

    public boolean login(String username, String password) {
        if (this.userName.equals(username) && this.userPassword.equals(password)) {
            return true;
        }
        return false;
    }

    public void credit(double creditAMT) {
        if (creditAMT <= 0) {
            throw new ValidAmountException(creditAMT);
        } 
        userBalance += creditAMT;
        System.out.println("Amount $" + creditAMT + " credited successfully. Updated balance: $" + userBalance);
    }

    public void debit(double debitAMT) {
        if (debitAMT > 0 && debitAMT <= userBalance) {
            userBalance -= debitAMT;
            System.out.println("Amount $" + debitAMT + " debited successfully. Updated balance: $" + userBalance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
