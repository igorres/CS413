/*************************************************
File: Customer.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates a Customer business object, which 
            allows the user to create a profile and an account.
*************************************************/
package Assignment2;

import java.util.*;

public class Customer {

    String firstName;
    String lastName;
    private CustomerAddress address;
    private Account accountNumber;
    private int iD;
    protected long createdOn;

    Customer(String first, String last, int iD, Account account) {
        this.firstName = first;
        this.lastName = last;
        this.accountNumber = account;
        this.iD = iD;
        this.createdOn = System.currentTimeMillis();
    }

    Customer(String first, String last, int iD) {
        this.firstName = first;
        this.lastName = last;
        this.iD = iD;
        this.createdOn = System.currentTimeMillis();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public CustomerAddress getCustomerAddress() {
        return this.address;
    }

    public Account getAccountNumber() {
        return this.accountNumber;
    }

    public long getDateCreated() {
        return createdOn;
    }

    public int getID(){
        return iD;
    }

    public void setID(int x){
        this.iD = x;
    }

    public String toString() {

        String str = "Customer object: \n";

        str += "First Name --> " + this.getFirstName() + "\nLast Name --> " + this.getLastName()
                + this.getCustomerAddress().toString();

        return str;
    }

}
