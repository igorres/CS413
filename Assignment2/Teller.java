/*************************************************
File: Teller.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates a Teller business object, an employee of the bank
*************************************************/
package Assignment2;

public class Teller {
    private String username;
    private String email;
    private String phone;
    private int id;

    public Teller() {
        // Default constructor
    }

    public Teller(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Getter and Setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getID() {
        return id;
    }

    public void setID(int idNum) {
        this.id = idNum;
    }    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String ph) {
        this.phone = ph;
    }
}
