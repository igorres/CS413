/*************************************************
File: TransactionDataConnection.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates a connection to the DB for the transactions table.
*************************************************/
package Assignment2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionDataConnection {
    
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/CS413";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "YOUR PWD HERE";

    // JDBC variables for opening and managing connection
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    // SQL queries to be used to persist business objects as needed by the DAO
    private static final String INSERT_DEPOSIT_SQL = "INSERT INTO Transaction (accountIn, cash) VALUES (?, ?)";
    private static final String INSERT_WITHDRAW_SQL = "INSERT INTO Transaction (accountOut, cash) VALUES (?, ?)";
    private static final String INSERT_ACCOUNT_TRANSFER_SQL = "INSERT INTO Transaction (accountOut, accountIn, cash) VALUES (?, ?, ?)";
    private static final String SELECT_SQL_BYID = "SELECT * FROM Transaction WHERE id = ?";
    private static final String UPDATE_DEPOSIT_SQL = "UPDATE Transaction SET accountIn = ?,  cash = ? WHERE id = ?";
    private static final String UPDATE_WITHDRAW_SQL = "UPDATE Transaction SET accountOut = ?,  cash = ? WHERE id = ?";
    private static final String UPDATE_ACCOUNT_TRANSFER_SQL = "UPDATE Transaction SET accountOut = ?, accountIn = ?,  cash = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM Transaction WHERE id = ?";    
 
    public TransactionDataConnection()  { } 
    
    public static Connection getDBConnection() throws SQLException {
        
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        
        return connection;
    }
    
    public static String getInsertDeposit() {
        
        return INSERT_DEPOSIT_SQL;
    }

    public static String getInsertWithdraw() {
        
        return INSERT_WITHDRAW_SQL;
    }

    public static String getInsertAccountTransfer() {
        
        return INSERT_ACCOUNT_TRANSFER_SQL;
    }
    
    public static String getUpdateDeposit() {
        
        return UPDATE_DEPOSIT_SQL;
    }

    public static String getUpdateWithdraw() {
        
        return UPDATE_WITHDRAW_SQL;
    }

    public static String getUpdateAccountTransfer() {
        
        return UPDATE_ACCOUNT_TRANSFER_SQL;
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
