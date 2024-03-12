/*************************************************
File: CustomerDTO.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates a customer DTO object.
*************************************************/
package Assignment2;

import java.sql.SQLException;

public class CustomerDTO {

    private int id;
    private String firstName;
    private String lastName;
    private Account accountNumber;

    static CustomerDAO cust = new CustomerDAO();
    @SuppressWarnings("rawtypes")
    LinkedPriorityQueue list = new LinkedPriorityQueue<>();

    public CustomerDTO() {

    }


    public CustomerDTO(String firstname, String lastname, int id, Account number) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.id = id;
        this.accountNumber = number;
    }

    public CustomerDTO(String firstname, String lastname, int id) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.id = id;
    }

    // Getter and Setter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public Account getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Account number) {
        this.accountNumber = number;
    }

    public int getID() {
        return id;
    }

    public void setID(int x) {
        this.id = x;
    }

    private void addToList(Comparable cust){
        list.add(cust);
    }

    public static Customer customerByID(int anId) {

        Customer aCust = null;

        try {
            aCust = cust.get(anId);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        if (aCust != null)
            System.out.println(aCust.toString());

        System.out.println("\nFetched Customer with number: " + anId + " Customer Details:\n" + aCust.toString());
        return aCust;

    }

    public static int performUpdate(Customer aCustomer) {

        int updateResult = -1;

        try {
            updateResult = cust.update(aCustomer);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        if (updateResult != -1)
            System.out.println("\nUpdate Successful");
        System.out.println("Customer Details:\n" + aCustomer.toString());
        return updateResult;
    }

}
