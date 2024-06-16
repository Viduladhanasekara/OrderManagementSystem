/*
 * To change this
license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateDeleteOrder {
         
    // Method to update a Product from the database
    public static boolean updateOrder(String orderID, String customerName, String product, 
        String quantity, String price, String orderDate)
            throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = DBConnection.getConnection();
            
            String query = "UPDATE orders SET customerName=?, product=?, quantity=?, price=?, orderDate=? WHERE orderID=?";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, customerName);
            pstmt.setString(2, product);
            pstmt.setString(3, quantity);
            pstmt.setString(4, price);
            pstmt.setString(5, orderDate);
            pstmt.setString(6, orderID);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                success = true;
            }
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
        
        return success;
    }
    
        // Method to delete a Product from the database
    public static boolean deleteOrder(String orderID) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = DBConnection.getConnection();
            String query = "DELETE FROM orders WHERE orderID=?";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, orderID);
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
        return success;
    }
    
}
