/*************************************************
File: Admin.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates an Admin object used to oversee banking application
*************************************************/

package Assignment2;

public class Admin{

    private String username;
    private String email;
    private String phone;
    private int id;

    public Admin() {
        // Default constructor
    }

    public Admin(String username, String email, int id) {
        this.username = username;
        this.email = email;
        this.id = id;
    }
    public Admin(String username, String email, int id, String phone) {
        this.username = username;
        this.email = email;
        this.id = id;
        this.phone = phone;
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

    public String toString() {

        String str = "Admin object: \n";

        str += "Username Name --> " + this.getUsername() + "\nEmail --> " + this.getEmail() + "\n ID --> " +this.getID();

        return str;
    }


}