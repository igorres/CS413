/*************************************************
File: SavingAccountDAOConcrete.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates a Checking Account DAO object
*************************************************/
package Assignment2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class SavingAccountDAO {
 
    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;
    
    SavingAccountDAO() {

        try {

            connection = SavingAccountDataConnection.getDBConnection();           

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

    // Method to insert a checking account into the database
    public int insert(Account acc) throws SQLException {
        
        int res = -1;
        pStatement = connection.prepareStatement(SavingAccountDataConnection.getInsert());
        pStatement.setString(1, acc.getName());
        pStatement.setString(2, acc.getAccountNumber());
        pStatement.setDouble(3, acc.getBalance());
        res = pStatement.executeUpdate();
        disconnect();
        
        return res;
    }

    // Method to retrieve a checking account from the database by account number.
    public Account get(int anID) throws SQLException {

        pStatement = connection.prepareStatement(SavingAccountDataConnection.getSelect());
        pStatement.setInt(2,anID);
        result = pStatement.executeQuery();
        
        Account updatedAcc = null;
        if (result.next()) {
            updatedAcc = new CheckingAccount( result.getString("name"), result.getString("account number"));
        }

        return updatedAcc;
    }

    // Method to update a checking account in the database
    public int update(Account acc) throws SQLException {
        
        int result = -1;
        
        pStatement = connection.prepareStatement(SavingAccountDataConnection.getUpdate());
        pStatement.setString(1, acc.getName());
        pStatement.setString(2, acc.getAccountNumber());
        pStatement.setDouble(3, acc.getBalance());
        result = pStatement.executeUpdate();
        
        return result;
    }

    // Method to delete a checking account from the database
    
    public int delete(Account acc) throws SQLException {

        int res = -1;
        
        pStatement = connection.prepareStatement(SavingAccountDataConnection.getDelete());
        pStatement.setString(1,acc.getAccountNumber());
        res = pStatement.executeUpdate();
        
        return res;
    }  

    // Method to update a checking account in the database
    public int save(Account acc) throws SQLException {
        
        int res = -1;

        pStatement = connection.prepareStatement(SavingAccountDataConnection.getInsert());
        pStatement.setString(1, acc.getName());
        pStatement.setString(2, acc.getAccountNumber());
        res = pStatement.executeUpdate();

        return res;
    }
    
}
