/*************************************************
File: Account.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates an Account business object, allowing a customer to store
             their money and any transactions that come with an account.
*************************************************/

package Assignment2;

public class Account implements AccountInterface {
    private String accountName;
    private String accountNumber;
    protected double balance = 0;
    protected long createdOn;

    public Account(String name, String accountNumber, double balance) {
        this.accountName = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.createdOn = System.currentTimeMillis();
    }

    public Account(String name, String accountNumber) {
        this.accountName = name;
        this.accountNumber = accountNumber;
        this.createdOn = System.currentTimeMillis();
    }

    public Account(String name, double balance){
        this.accountName = name;
        this.balance = balance;
        this.createdOn = System.currentTimeMillis();
    }

    public Account(double balance){
        this.balance = balance;
        this.createdOn = System.currentTimeMillis();
    }

    public String getName() {
        return accountName;
    }

    public void setName(String name) {
        this.accountName = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getCreationDate(){
        return createdOn;
    }

    private boolean clear(){
        this.accountName = null;
        this.accountNumber = null;
        this.balance = 0;

        if(accountName == null && accountNumber == null && balance == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean closeAccount(){
        return clear();
    }

    /* 
    public boolean deposit(double amount) {
        if(amount > 0){
            balance += amount;
            return true;
        }
        else{
            System.out.println("Deposit failed, deposit amount cannot be $0");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if(amount < balance){
            balance -= amount;
            return true;
        }
        else{
            System.out.println("Withdraw failed, balance too low");
            return false;
        }
    }

    public boolean transferAccounts(double amount, Account acc){
        if(this.balance < amount){
            System.out.println("Transfer failed, starting balance too low");
            return false;
        }
        else{
            this.balance -= amount;
            acc.balance += amount;
            return true;
        }
    }
    */

    public String getAccountInfo() {
        return "Name: " + accountName + ", Account Number: " + accountNumber + ", Balance: " + balance;
    }

}
