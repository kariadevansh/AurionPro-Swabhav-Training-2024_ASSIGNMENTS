package com.apro.assignment.model;

public class CurrentAccount extends Account {
    private double overdraftLimit;
    public double tempLimit = overdraftLimit;
    public CurrentAccount(String userName, double balance, double overdraftLimit) {
        super(userName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public void credit(double creditAMT) {
    	double balance = super.getBalance();
    	if(creditAMT<=0) {
    		throw new ValidAmountException(creditAMT);
    	}
    	if(creditAMT<balance) {
    		super.credit(creditAMT);
    		return;
    	}
    	if(balance == 0 && tempLimit<=overdraftLimit) {  
    		tempLimit += creditAMT;
    		System.out.println("The amount "+ creditAMT+" is added to your overdraft.Current overdraft : "+ tempLimit);
    	}
    }
    
    public void debit(double debitAMT) {
    	double balance = super.getBalance();
    	if(debitAMT<=0) {
//    		System.out.println("Enter a valid amount");
//    		return;
    		throw new ValidAmountException(debitAMT);
    	}
    	if(balance<debitAMT) {
    		whenBalanceIsNotSufficient(debitAMT,balance);
    		return;
    	}
    	if(balance==0 && tempLimit>0) {
    		tempLimit -= debitAMT;
             System.out.println("Amount $"+debitAMT+" debited successfully from your overdraft value.Balance overdraft value id: $"+tempLimit);
             System.out.println("The amount credited from the overdraft must be squared off within 15 days at interest of 2%.");
             return;
    	}
    	if(balance<=0 || tempLimit<=0) {
    		System.out.println("You dont have enough balance and have reached your overdraft limit");
    		throw new InsufficientBalanceException(balance);
    	}
    	 balance -= debitAMT;
         System.out.println("Amount $" + debitAMT + " debited successfully. Updated balance: $" + balance);
         super.setBalance(balance);
    	
    }
    
    public void whenBalanceIsNotSufficient(double debitAMT,double balance) {
    	System.out.println("Amount $" + balance + " debited successfully. Updated balance: $" + 0.0);
    	debitAMT -= balance;
    	
    	if(debitAMT > overdraftLimit) {
    		System.out.println("You dont have enough balance and have reached your overdraft limit");
    		throw new InsufficientBalanceException(balance);
    	}
    	tempLimit -= debitAMT;
    	
    	 System.out.println("Amount $"+debitAMT+" debited successfully from your overdraft value.Balance overdraft value id: $"+tempLimit);
         System.out.println("The amount credited from the overdraft must be squared off within 15 days at interest of 2%.");
         super.setBalance(balance = 0);
    }

    @Override
    public String toString() {
        return "CurrentAccount [AccountNo=" + getAccountNo() + ", UserName=" + getUserName() + ", Balance=" + getBalance() + "]";
    }
}
