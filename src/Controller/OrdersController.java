/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UpdateDeleteOrder;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class OrdersController {
    
public static void Orders(String orderID, String customerName, String product, 
        String quantity, String price, String orderDate) {
    new Model.AddOrder().Orders(orderID, customerName, product, 
                    quantity, price, orderDate);
    JOptionPane.showMessageDialog(null, "New Record has been inserted", 
            "Successfull", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean updateOrder(String orderID, String customerName, String product, 
        String quantity, String price, String orderDate) throws 
            SQLException {boolean success = false;
            success = UpdateDeleteOrder.updateOrder(orderID, customerName, product, 
                    quantity, price, orderDate);
            return success;
        }
    
    public static boolean deleteOrder(String orderID) throws SQLException {
        boolean success = false;
        success = UpdateDeleteOrder.deleteOrder(orderID);
        return success;
    }
    
}
