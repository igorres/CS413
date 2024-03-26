/*************************************************
File: DAOInterface.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Interface that lists function for DAO objects to use.
*************************************************/
package Assignment2;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<T> {
    
    T get(T e) throws SQLException;
    //List<T> getAll() throws SQLException;
    int save(T e) throws SQLException;
    int insert(T e) throws SQLException;
    int update(T e) throws SQLException;
    int delete(T e) throws SQLException;
    
}