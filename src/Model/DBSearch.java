/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSearch {
    
    Statement stmt;
    ResultSet rs;
    
    public ResultSet searchLogin(String usName) {

            try {
      stmt = DBConnection.getStatementConnection();
      String name = usName;
    //Execute the Query
    rs = stmt.executeQuery("SELECT * FROM login where username='" + name + "'");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rs;
        }

    public ResultSet searchOrders() {
        try{
            stmt = DBConnection.getStatementConnection();
            rs = stmt.executeQuery("SELECT * FROM orders");
        } catch(Exception e) {

            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet searchOrdersDetailsByID(String orderID) throws SQLException {
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE orderID = ?");
            statement.setString(1, orderID);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            throw new SQLException("Error occurred while searching for Orders.", e);
        }
        return resultSet;
    }

    public ResultSet searchCustomer() {
        try{
            stmt = DBConnection.getStatementConnection();
            rs = stmt.executeQuery("SELECT * FROM customers");
        } catch(Exception e) {

            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet searchCustomerDetailsByID(String customerID) throws SQLException {
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE customerID = ?");
            statement.setString(1, customerID);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            throw new SQLException("Error occurred while searching for Customers.", e);
        }
        return resultSet;
    }
    
}
