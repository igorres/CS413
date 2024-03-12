/*************************************************
File: SavingsAccount.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Savings account that extends Account, adds interest 
*************************************************/
package Assignment2;

public class SavingsAccount extends Account {
    private static double interestRate = 0.08;

    public SavingsAccount(String name, String accountNumber) {
        super(name, accountNumber);
    }

    public SavingsAccount(String name, String accountNumber, double balance){
        super(name, accountNumber, balance);
    }
    
    public double getBalanceWithInterest(){
        return balance * interestRate;
    }
}
