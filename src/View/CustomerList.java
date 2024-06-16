/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DBConnection;
import Model.DBSearch;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class CustomerList extends javax.swing.JFrame {

    public CustomerList() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        closeBtn = new javax.swing.JLabel();
        Topic = new javax.swing.JLabel();
        getcustomerListBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customersListTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        closeBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        closeBtn.setText("X");
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
        });

        Topic.setFont(new java.awt.Font("Dubai", 1, 22)); // NOI18N
        Topic.setForeground(new java.awt.Color(153, 51, 0));
        Topic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Topic.setText("  Order Management System - Customer List ");

        getcustomerListBtn.setText("Get Customer List");
        getcustomerListBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getcustomerListBtnMouseClicked(evt);
            }
        });
        getcustomerListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getcustomerListBtnActionPerformed(evt);
            }
        });

        customersListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "Full Name", "Contact Number", "Email Address", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customersListTable.setToolTipText("");
        jScrollPane1.setViewportView(customersListTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(closeBtn))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(getcustomerListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 320, Short.MAX_VALUE))
                    .addComponent(Topic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Topic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(getcustomerListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
        dispose();
    }//GEN-LAST:event_closeBtnMouseClicked

    private void getcustomerListBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getcustomerListBtnMouseClicked
        // TODO add your handling code here:
        
        ResultSet r = new DBSearch().searchCustomer();
        DefaultTableModel dtm = (DefaultTableModel)
        customersListTable.getModel();
            dtm.setRowCount(0); //sets the number of rows in the model
            
            try {
                Vector v;
                while (r.next()){
                v = new Vector();
                v.add(r.getString("customerID"));
                v.add(r.getString("fullName"));
                v.add(r.getString("contactNumber"));
                v.add(r.getString("email"));
                v.add(r.getString("address"));

                dtm.addRow(v); //adds row to the end of the model
                }
                DBConnection.closeCon();
                
            }catch (Exception e) {
                e.printStackTrace();
                    }
    }//GEN-LAST:event_getcustomerListBtnMouseClicked

    private void getcustomerListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getcustomerListBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getcustomerListBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Topic;
    private javax.swing.JLabel closeBtn;
    private javax.swing.JTable customersListTable;
    private javax.swing.JButton getcustomerListBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}