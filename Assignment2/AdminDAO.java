/*************************************************
File: AdminDAO.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates an Admin DAO object
*************************************************/

package Assignment2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JOptionPane;

class AdminDAO implements DAOInterface<Admin> {
 
    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;
    
    AdminDAO() {

        try {

            connection = AdminDataConnection.getDBConnection();           

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }        

}
    
    // Method to disconnect from the database
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Method to insert an admin into the database
    public int insert(Admin admin) throws SQLException {
        
        int res = -1;
        pStatement = connection.prepareStatement(AdminDataConnection.getInsert());
        pStatement.setString(1, admin.getUsername());
        pStatement.setString(2, admin.getEmail());
        pStatement.setInt(3, admin.getID());
        res = pStatement.executeUpdate();
        disconnect();
        
        return res;
    }

    // Method to retrieve an admin from the database by ID number.
    public Admin get(int anID) throws SQLException {

        pStatement = connection.prepareStatement(AdminDataConnection.getSelect());
        pStatement.setInt(3,anID);
        result = pStatement.executeQuery();
        
        Admin updatedAdmin = null;
        if (result.next()) {
            updatedAdmin = new Admin(result.getString("username"), result.getString("email"), result.getString("adminID"), result.getInt("pwd"));
        }

        return updatedAdmin;
    }

    // Method to update an admin in the database
    public int update(Admin admin) throws SQLException {
        
        int result = -1;
        
        pStatement = connection.prepareStatement(AdminDataConnection.getUpdate());
        pStatement.setString(1, admin.getUsername());
        pStatement.setString(2, admin.getEmail());
        pStatement.setInt(3, admin.getID());
        result = pStatement.executeUpdate();
        
        return result;
    }

    // Method to delete an admin from the database
    public int delete(Admin admin) throws SQLException {

        int res = -1;
        
        pStatement = connection.prepareStatement(AdminDataConnection.getDelete());
        pStatement.setString(1,admin.getUsername());
        res = pStatement.executeUpdate();
        
        return res;
    }  

    // Method to insert an admin in the database
    public int save(Admin admin) throws SQLException {
        
        int res = -1;

        pStatement = connection.prepareStatement(AdminDataConnection.getInsert());
        pStatement.setString(1, admin.getUsername());
        pStatement.setString(2, admin.getEmail());
        pStatement.setInt(3, admin.getID());
        pStatement.setString(4, admin.getPwd());
        res = pStatement.executeUpdate();

        return res;
    }

    @Override
    public Admin get(Admin e) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public HashMap validateLogin(String username) {
        
        HashMap hm = null;
        
        try {
            
            pStatement = connection.prepareStatement(AdminDataConnection.getSelect());
            pStatement.setString(1, username);
            result = pStatement.executeQuery();
            
            if (result.next()) {
                hm = new HashMap();
                hm.put("username", result.getString("username"));
                hm.put("pwd", result.getString("pwd"));
            }
            
        } catch( Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage() + " Try again..");
        }
        
        return hm;
    }
    
}
