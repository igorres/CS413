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
    private Account accountNumber;
    private String email;
    protected long createdOn;
    private String bday;
    private String phone;
    private String pwd;

    public Customer(){
        //Default Constructor
    }

    public Customer(String first, String last, Account account) {
        this.firstName = first;
        this.lastName = last;
        this.accountNumber = account;
        this.createdOn = System.currentTimeMillis();
    }

    public Customer(String first, String last, String email, String phone, String birthdate, String pwd){
        this.firstName = first;
        this.lastName = last;
        this.email = email;
        this.phone = phone;
        this.bday = birthdate;
        this.pwd = pwd;
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

    public Account getAccountNumber() {
        return this.accountNumber;
    }

    public long getDateCreated() {
        return createdOn;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String number){
        this.phone = number;
    }

    public String getBirthday(){
        return bday;
    }

    public String getPwd(){
        return pwd;
    }

    public void setBirthday(String birthdate){
        this.bday = birthdate;
    }

    public String toString() {

        String str = "Customer object: \n";

        str += "First Name --> " + this.getFirstName() + "\nLast Name --> " + this.getLastName()
                + "\nEmail --> " + this.email + "\nPhone --> " + this.phone;

        return str;
    }

}
