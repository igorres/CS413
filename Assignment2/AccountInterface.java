/*************************************************
File: AccountInterface.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Interface of basic functions a bank account uses.
*************************************************/
package Assignment2;

public interface AccountInterface {

    public String getName();

    public void setName(String name);

    public String getAccountNumber();

    public void setAccountNumber(String accountNumber);

    public double getBalance();

    public void setBalance(double balance);
    
}
