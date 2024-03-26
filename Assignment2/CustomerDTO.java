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
import java.util.HashMap;

public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String birthday;
    private String pwd;

    static CustomerDAO cust = new CustomerDAO();
    @SuppressWarnings("rawtypes")
    LinkedPriorityQueue list = new LinkedPriorityQueue<>();

    public CustomerDTO() {

    }


    public CustomerDTO(String firstname, String lastname, String email, String phone, String birthday, String pwd) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.pwd = pwd;
    }

    public CustomerDTO(String firstname, String lastname, String email, String pwd) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.pwd = pwd;
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

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String bday){
        this.birthday = bday;
    }

    private void addToList(Comparable cust){
        list.add(cust);
    }

    public static Customer customerByEmail(String anEmail) {

        Customer aCust = null;

        try {
            aCust = cust.get(anEmail);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        if (aCust != null)
            System.out.println(aCust.toString());

        System.out.println("\nFetched Customer with number: " + anEmail + " Customer Details:\n" + aCust.toString());
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

    public static int performCreate(Customer aCustomer) {
        int updateResult = -1;
        
        try {
            updateResult = cust.save(aCustomer);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nCustomer created successfully");
         System.out.println("Customer details:\n" + aCustomer.toString());
        return updateResult;        
    }
    
    public static HashMap validateUser(String email) {
        
        return cust.validateLogin(email);
        
    }

}
