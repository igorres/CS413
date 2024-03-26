/*************************************************
File: AdminDTO.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates an Admin DTO object
*************************************************/
package Assignment2;

import java.sql.SQLException;
import java.util.HashMap;

public class AdminDTO {

    private int id;
    private String username;
    private String email;
    private String pwd;

    static AdminDAO admin = new AdminDAO();

    public AdminDTO() {

    }

    public AdminDTO(String username, String email, int id, String pwd) {
        this.username = username;
        this.email = email;
        this.id = id;
        this.pwd = pwd;
    }

    // Getter and Setter methods
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() {
        return id;
    }

    public void setID(int x) {
        this.id = x;
    }

    public static Admin adminByID(int anId) {

        Admin anAdmin = null;

        try {
            anAdmin = admin.get(anId);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        if (anAdmin != null)
            System.out.println(anAdmin.toString());

        System.out.println("\nFetched Admin with ID number: " + anId + " Admin Details:\n" + anAdmin.toString());
        return anAdmin;

    }

    public static int performUpdate(Admin anAdmin) {

        int updateResult = -1;

        try {
            updateResult = admin.update(anAdmin);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        if (updateResult != -1)
            System.out.println("\nUpdate Successful");
        System.out.println("Admin Details:\n" + anAdmin.toString());
        return updateResult;
    }

    public static int performCreate(Admin anAdmin) {
        int updateResult = -1;
        
        try {
            updateResult = admin.save(anAdmin);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nAdmin created successfully");
         System.out.println("Admin details:\n" + anAdmin.toString());
        return updateResult;        
    }

    public static HashMap validateUser(String username) {
        return admin.validateLogin(username);
        
    }

}
