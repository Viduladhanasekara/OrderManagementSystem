/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UpdateDeleteCustomers;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CustomerController {
    
    public static void AddCustomer(String customerID, String fullName, String contactNumber, 
        String email, String address) {
    new Model.AddCustomer().AddCustomer(customerID, fullName, contactNumber, email, address);
    JOptionPane.showMessageDialog(null, "New Record has been inserted", 
            "Successfull", JOptionPane.INFORMATION_MESSAGE);
    }    
    
    public static boolean updateCustomer(String customerID, String fullName, String contactNumber, String email, String address) {
        boolean success = false;
        try {
            success = UpdateDeleteCustomers.updateCustomer(customerID, fullName, contactNumber, email, address);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return success;
    }
    
    public static boolean deleteCustomer(String customerID) throws SQLException {
        boolean success = false;
        success = UpdateDeleteCustomers.deleteSuppier(customerID);
        return success;
    }
    
}  
