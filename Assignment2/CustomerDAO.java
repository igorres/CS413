/*************************************************
File: CustomerDAO.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates an customer DAO object
*************************************************/
package Assignment2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

class CustomerDAO implements DAOInterface<Customer> {
 
    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;
    
    CustomerDAO() {

        try {

            connection = CustomerDataConnection.getDBConnection();           

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

    // Method to insert a customer into the database
    public int insert(Customer cust) throws SQLException {
        
        int res = -1;
        pStatement = connection.prepareStatement(CustomerDataConnection.getInsert());
        pStatement.setString(1, cust.getFirstName());
        pStatement.setString(2, cust.getLastName());
        pStatement.setString(3, cust.getEmail());
        pStatement.setString(4, cust.getPhone());
        pStatement.setString(5, cust.getBirthday());
        pStatement.setString(6, cust.getPwd());
        res = pStatement.executeUpdate();
        disconnect();
        
        return res;
    }

    // Method to retrieve a customer from the database by email
    public Customer get(String email) throws SQLException {

        pStatement = connection.prepareStatement(CustomerDataConnection.getSelect());
        pStatement.setString(3,email);
        result = pStatement.executeQuery();
        
        Customer updatedCust = null;
        if (result.next()) {
            //Customer c = new Customer();
            updatedCust = new Customer(result.getString("first_name"), result.getString("last_name"), result.getString("email"), result.getString("phone"), result.getString("birthday"), result.getString("pwd"));
        }
        return updatedCust;
    }

    // Method to update a customer in the database
    public int update(Customer cust) throws SQLException {
        
        int result = -1;
        
        pStatement = connection.prepareStatement(CustomerDataConnection.getUpdate());
        pStatement.setString(1, cust.getName());
        pStatement.setString(3, cust.getEmail());
        result = pStatement.executeUpdate();
        
        return result;
    }

    // Method to delete a customer from the database
    
    public int delete(Customer cust) throws SQLException {

        int res = -1;
        
        pStatement = connection.prepareStatement(CustomerDataConnection.getDelete());
        pStatement.setString(1,cust.getName());
        res = pStatement.executeUpdate();
        
        return res;
    }  

    // Method to save a customer in the database
    public int save(Customer cust) throws SQLException {
        
        int res = -1;
        pStatement = connection.prepareStatement(CustomerDataConnection.getInsert());
        pStatement.setString(1, cust.getFirstName());
        pStatement.setString(2, cust.getLastName());
        pStatement.setString(3, cust.getEmail());
        pStatement.setString(4, cust.getPhone());
        pStatement.setString(5, cust.getBirthday());
        pStatement.setString(6, cust.getPwd());
        res = pStatement.executeUpdate();

        return res;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public HashMap validateLogin(String email) {
        
        HashMap hm = null;
        
        try {
            
            pStatement = connection.prepareStatement(CustomerDataConnection.getSelect());
            pStatement.setString(1, email);
            result = pStatement.executeQuery();
            
            if (result.next()) {
                hm = new HashMap();
                hm.put("EMAIL", result.getString("email"));
                hm.put("PWD", result.getString("pwd"));
            }
            
        } catch( Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage() + " Try again..");
        }
        
        return hm;
    }
    @Override
    public Customer get(Customer e) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
    
}
