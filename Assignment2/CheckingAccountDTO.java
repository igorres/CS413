/*************************************************
File: CheckingAccountDTO.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates a Checking Account DTO object
*************************************************/
package Assignment2;

import java.sql.SQLException;

public class CheckingAccountDTO {
    
    private int id;
    private String name;
    private String accountNumber;
    private double balance;
   
    static CheckingAccountDAOConcrete acc = new CheckingAccountDAOConcrete();

    public CheckingAccountDTO() {

    }

    public CheckingAccountDTO(String name, String number, double balance) {
        this.name = name;
        this.accountNumber = number;
        this.balance = balance;
    }

    public CheckingAccountDTO(String name, String number) {
        this.name = name;
        this.accountNumber = number;
    }    
    
    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String number) {
        this.accountNumber = number;
    }    
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double number) {
        this.balance = number;
    }
    /* 
    public int getID() {
        
        return id;
    }

    public void setID(int anID) {
        this.id = anID;
    }  
    */
    public static Account accountByNumber(int anId) {
        
        Account anAcc = null;
        
        try {
            anAcc = acc.get(anId);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        if(anAcc != null) System.out.println(anAcc.toString()); 
            
        System.out.println("\nFetched Account with number: " + anId + " Account Details:\n" + anAcc.getAccountInfo());        
        return anAcc;
        
    }
    
    public static int performUpdate(Account anAccount) {

        int updateResult = -1;
        
        try {
            updateResult = acc.update(anAccount);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nUpdate Successful");
         System.out.println("Account Details:\n" + anAccount.getAccountInfo());
        return updateResult;        
    }

}
