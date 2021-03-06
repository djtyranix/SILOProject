/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
/**
 *
 * @author micha
 */
public class DaftarSuratJalan extends javax.swing.JPanel {
    
    private MainPage mainPage;
    private ArrayList<DeliveryNote> deliveryNotes;
    /**
     * Creates new form DaftarSuratJalan
     */
    public DaftarSuratJalan(MainPage mainPage) {
        initComponents();
        addMainPage(mainPage);
        refresh();
    }
    
    public final void addMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }
    
    public final void refresh()
    {
        deliveryNotes = mainPage.getDeliveryNote();
        
        Action detail = new AbstractAction(){
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                DeliveryNote curDeliveryNote = deliveryNotes.get(modelRow);
                mainPage.onShowDNDescription(curDeliveryNote);
            }
        };
        
        ButtonColumn buttonColumn = new ButtonColumn(DaftarSuratJalanTable, detail, 6);
        
        fillTable(deliveryNotes);
        this.SearchField.setText("");
    }
    
    public final void fillTable(ArrayList<DeliveryNote> itemList)
    {
        DefaultTableModel model = (DefaultTableModel) this.DaftarSuratJalanTable.getModel();
        model.setRowCount(0);
        DeliveryNote curItem;
        String status = null;
        
        for(int i = 0; i < itemList.size(); i++)
        {
            curItem = itemList.get(i);
                    
            switch(curItem.getStatus())
            {
                case 1:
                    status = "New";
                    break;
                case 2:
                    status = "Preparing";
                    break;
                case 3:
                    status = "Completed";
                    break;
                case 4:
                    status = "Pending";
                    break;
            }
            
            model.addRow(new Object[]{curItem.getInvoiceNumber(), curItem.getDeliveryNotesNumber(), curItem.getCustomerName(), curItem.getOrderDate(), curItem.getDeliveryDate(), status, "View"});
        }
    }
    
    public void searchDeliveryNote(String keyword)
    {
        deliveryNotes = mainPage.searchDeliveryNote(keyword);
        //deliveryNotes = mainPage.getDeliveryNote();
        
        fillTable(deliveryNotes);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        AddSuratJalanButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        DaftarSuratJalanTable = new javax.swing.JTable();

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        AddSuratJalanButton.setText("Add");
        AddSuratJalanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSuratJalanButtonActionPerformed(evt);
            }
        });

        DaftarSuratJalanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Inv Number", "DN Number", "Cust Name", "Order Date", "Delivery Date", "Status", "Action"
            }
        ));
        DaftarSuratJalanTable.setRowHeight(35);
        jScrollPane2.setViewportView(DaftarSuratJalanTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 568, Short.MAX_VALUE)
                .addComponent(AddSuratJalanButton)
                .addGap(26, 26, 26))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddSuratJalanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
        String keyword = SearchField.getText();
        searchDeliveryNote(keyword);
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void AddSuratJalanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSuratJalanButtonActionPerformed
        // TODO add your handling code here:
        mainPage.displayAddDeliveryNotes();
    }//GEN-LAST:event_AddSuratJalanButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSuratJalanButton;
    private javax.swing.JTable DaftarSuratJalanTable;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
