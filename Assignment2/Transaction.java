/*************************************************
File: Transaction.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates a Transaction business object, 
            allows the users to transfer, withdraw and deposit cash.
*************************************************/
package Assignment2;

public class Transaction {
    private double cash;
    private Account accountIn, accountOut;
    private Customer customerIn, customerOut;

    public Transaction(Account account, double cash){
        this.accountIn = account;
        this.cash = cash;
    }
    public Transaction(Account out, Account in, double cash){
        this.accountIn = in;
        this.accountOut = out;
        this.cash = cash;
    }

    public Transaction(Customer customerIn, Account in, Customer customerOut, Account out, double cash){
        this.customerIn = customerIn;
        this.customerOut = customerOut;
        this.accountIn = in;
        this.accountOut = out;
        this.cash = cash;
    }

    public double getCash(){
        return cash;
    }

    public Account getAccountIn(){
        return accountIn;
    }

    public Account geAccountOut(){
        return accountOut;
    }

    public Customer getCustomerIn(){
        return customerIn;
    }

    public Customer getCustomerOut(){
        return customerOut;
    }

    public void setCash(double amount){
        this.cash = amount;
    }

    public void setAccountIn(Account acc){
        this.accountIn = acc;
    }

    public void setAccountOut(Account acc){
        this.accountOut = acc;
    }

    public void setCustomerIn(Customer cust){
        this.customerIn = cust;
    }

    public void setCustomerOut(Customer cust){
        this.customerOut = cust;
    }

    public boolean deposit(){
        if(cash > 0){
            accountIn.setBalance(accountIn.getBalance() + cash);
            System.out.println("Succesful deposit.");
            return true;
        }
        else{
            System.out.println("Unsuccesful, deposit must be more than $0.");
            return false;
        }
    }

    public boolean withdraw(){
        if(accountIn.getBalance() >= cash){
            accountIn.setBalance(accountIn.getBalance() - cash);
            System.out.println("Succesul withdraw");
            return true;
        }
        else{
            System.out.println("Unsuccesful, insufficient funds.");
            return false;
        }
    }

    public boolean transferBetweenUserAccounts(){
        if(accountOut.getBalance() >= cash){
            accountOut.setBalance(accountOut.getBalance() - cash);
            accountIn.setBalance(accountIn.getBalance() + cash);
            System.out.println("Succesful transfer.");
            return true;
        }
        else{
            System.out.println("Unsuccesful, insufficient funds.");
            return false;
        }
    }

    public boolean transferBetweenTwoUsers(){
        if(customerOut.getAccountNumber().getBalance() >= cash){
            accountOut.setBalance(accountOut.getBalance() - cash);
            accountIn.setBalance(accountIn.getBalance() + cash);
            System.out.println("Succesful transfer between two users.");
            return true;
        }
        else{
            System.out.println("Unsuccesful, insufficient funds");
            return false;
        }
    }

}
