package com.apro.assignment.model;

public class SavingsAccount extends Account {
    private double minBalance;

    public SavingsAccount(String userName, double balance, double minBalance) {
        super(userName, balance);
        this.minBalance = minBalance;
    }

    public void debit(double debitAMT) {
    	if(debitAMT<=0) {
    		throw new ValidAmountException(debitAMT);
    	}
        double balanceLeft = getBalance() - debitAMT;
        if (balanceLeft < minBalance) {
            System.out.println("Cannot debit as it falls below the minimum balance.");
            throw new InsufficientBalanceException(getBalance());
        } else {
            super.debit(debitAMT);
        }
    }
    
    


	@Override
    public String toString() {
        return "SavingsAccount [AccountNo=" + getAccountNo() + ", UserName=" + getUserName() + ", Balance=" + getBalance() + "]";
    }
}
