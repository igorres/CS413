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

class AdminDAO implements DAOInterface<Admin> {
 
    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;
    static String url = AdminDataConnection.getURL();
    static String username = AdminDataConnection.getUsername();
    static String pwd = AdminDataConnection.getPWD();
    
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
            updatedAdmin = new Admin( result.getString("username"), result.getString("email"), result.getInt("id"));
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
        res = pStatement.executeUpdate();

        return res;
    }
    
}
