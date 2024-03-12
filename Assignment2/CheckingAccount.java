/*************************************************
File: CheckingAccount.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates an Checking Account object based on Account class
*************************************************/
package Assignment2;

public class CheckingAccount extends Account {

    public CheckingAccount(String name, String accountNumber) {
        super(name, accountNumber);
    }

    public CheckingAccount(String name, String accountNumber, double balance){
        super(name, accountNumber, balance);
    }
    
}
