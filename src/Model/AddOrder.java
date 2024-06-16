/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Statement;

public class AddOrder {
    Statement stmt;
    
    public void Orders(String orderID, String customerName, String product, 
        String quantity, String price, String orderDate)
    {
        try{
            stmt = DBConnection.getStatementConnection();
            stmt.executeUpdate
            ("INSERT INTO orders (orderID, customerName, product,"
                    + "quantity, price, orderDate) VALUES('"+ orderID +"', '"+ 
                    customerName +"', '"+ product +"', '"+ quantity +"', '"+ 
                    price +"', '"+ orderDate +"')");
            System.out.println("Order Record added Successfull");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
