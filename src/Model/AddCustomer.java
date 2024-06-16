/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Statement;

public class AddCustomer {
    Statement stmt;

    public void AddCustomer(String customerID, String fullName, String contactNumber, 
        String email, String address) {
        try {
            stmt = DBConnection.getStatementConnection();
            stmt.executeUpdate(
                "INSERT INTO customers (customerID, fullName, contactNumber, email, "
                        + "address) VALUES('"+ customerID + "', '"
                        + fullName + "', '"+ contactNumber + "', '"+ email + "', '"
                + address + "')"
            );
        System.out.println("customers Record added Successfull");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
