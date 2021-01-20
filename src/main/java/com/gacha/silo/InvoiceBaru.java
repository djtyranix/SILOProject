/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author micha
 */
public class InvoiceBaru extends javax.swing.JPanel {

    private MainPage mainPage;
    /**
     * Creates new form InvoiceBaru
     */
    public InvoiceBaru(MainPage mainPage) {
        initComponents();
        addMainPage(mainPage);
    }
    
    public void addMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SubmitInvoiceButton = new javax.swing.JButton();
        PoNumberText = new javax.swing.JTextField();
        PoNumberLabel = new javax.swing.JLabel();
        SupplierNameText = new javax.swing.JTextField();
        SupplierNameLabel = new javax.swing.JLabel();
        OrderDateText = new javax.swing.JTextField();
        OrderDateLabel = new javax.swing.JLabel();
        DeliveryDateText = new javax.swing.JTextField();
        DeliveryDateLabel = new javax.swing.JLabel();

        SubmitInvoiceButton.setText("Submit");
        SubmitInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitInvoiceButtonActionPerformed(evt);
            }
        });

        PoNumberLabel.setText("PO Number");

        SupplierNameLabel.setText("Supplier Name");

        OrderDateLabel.setText("Order Date");

        DeliveryDateLabel.setText("Delivery Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(272, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DeliveryDateLabel)
                            .addComponent(OrderDateLabel)
                            .addComponent(SupplierNameLabel)
                            .addComponent(PoNumberLabel))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PoNumberText, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addComponent(SupplierNameText)
                            .addComponent(OrderDateText)
                            .addComponent(DeliveryDateText))
                        .addGap(242, 242, 242))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(SubmitInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PoNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PoNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SupplierNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SupplierNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OrderDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrderDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeliveryDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeliveryDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SubmitInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitInvoiceButtonActionPerformed
        // TODO add your handling code here:
        int dialogResult = mainPage.tampilkanConfirmDialog();
        if(dialogResult != JOptionPane.YES_OPTION) {return;}

        String[] input = {
            PoNumberText.getText(),
            SupplierNameText.getText(),
            OrderDateText.getText(),
            DeliveryDateText.getText()
        };

        mainPage.newSuratJalan(input);
    }//GEN-LAST:event_SubmitInvoiceButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DeliveryDateLabel;
    private javax.swing.JTextField DeliveryDateText;
    private javax.swing.JLabel OrderDateLabel;
    private javax.swing.JTextField OrderDateText;
    private javax.swing.JLabel PoNumberLabel;
    private javax.swing.JTextField PoNumberText;
    private javax.swing.JButton SubmitInvoiceButton;
    private javax.swing.JLabel SupplierNameLabel;
    private javax.swing.JTextField SupplierNameText;
    // End of variables declaration//GEN-END:variables
}
