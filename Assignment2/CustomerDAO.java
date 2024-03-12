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
import java.util.List;

class CustomerDAO implements DAOInterface<Customer> {
 
    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;
    static String url = CustomerDataConnection.getURL();
    static String username = CustomerDataConnection.getURL();
    static String pwd = CustomerDataConnection.getURL();
    static int iD;
    
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
        pStatement.setInt(3, cust.getID());
        res = pStatement.executeUpdate();
        disconnect();
        
        return res;
    }

    // Method to retrieve a customer from the database by account number.
    @Override
    public Customer get(int anID) throws SQLException {

        pStatement = connection.prepareStatement(CustomerDataConnection.getSelect());
        pStatement.setInt(3,anID);
        result = pStatement.executeQuery();
        
        Customer updatedCust = null;
        if (result.next()) {
            Customer c = new Customer(username, pwd, iD);
            updatedCust = new Customer( result.getString("name"), result.getString("account number"), anID);
        }

        return updatedCust;
    }

    // Method to update a customer in the database
    public int update(Customer cust) throws SQLException {
        
        int result = -1;
        
        pStatement = connection.prepareStatement(CustomerDataConnection.getUpdate());
        pStatement.setString(1, cust.getName());
        pStatement.setInt(3, cust.getID());
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
        pStatement.setString(1, cust.getName());
        pStatement.setInt(2, cust.getID());
        res = pStatement.executeUpdate();

        return res;
    }
    
}
