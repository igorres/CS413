/*************************************************
File: CustomerDataConnection.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates a connection to the DB for the customer table.
*************************************************/
package Assignment2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class CustomerDataConnection {
    
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/CS413";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "YOUR PWD HERE";

    // JDBC variables for opening and managing connection
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    // SQL queries to be used to persist business objects as needed by the DAO
    private static final String INSERT_SQL = "INSERT INTO Customer (firstname, lastname, address, account) VALUES (?, ?, ?, ?)";
    private static final String SELECT_SQL_BYID = "SELECT * FROM Customer WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE Customer SET firstname = ?, lastname = ?, address = ?, account = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM Customer WHERE id = ?";    
 
    public CustomerDataConnection()  { } 
    
    public static Connection getDBConnection() throws SQLException {
        
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        
        return connection;
    }
    
    public static String getInsert() {
        
        return INSERT_SQL;
    }
    
    public static String getUpdate() {
        
        return UPDATE_SQL;
    }
    
    public static String getSelect() {
        
        return SELECT_SQL_BYID;
    }

    public static String getDelete() {
        
        return DELETE_SQL;
    }
    
    public static String getURL() {
        
        return URL;
    }

    public static String getUsername() {
        
        return USERNAME;
    }

    public static String getPWD() {
        
        return PASSWORD;
    }
    
}
