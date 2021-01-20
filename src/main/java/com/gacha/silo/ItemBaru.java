/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;

/**
 *
 * @author micha
 */
public class ItemBaru extends javax.swing.JPanel {

    /**
     * Creates new form ItemBaru
     */
    public ItemBaru() {
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

        NumberOfStocksLabel = new javax.swing.JLabel();
        ManufacturerLabel = new javax.swing.JLabel();
        SubmitItemButton = new javax.swing.JButton();
        NumberOfStocksText = new javax.swing.JTextField();
        UrlLabel = new javax.swing.JLabel();
        UrlText = new javax.swing.JTextField();
        BarcodeText = new javax.swing.JTextField();
        BarcodeLabel = new javax.swing.JLabel();
        TitleText = new javax.swing.JTextField();
        TitleLabel = new javax.swing.JLabel();
        DescriptionText = new javax.swing.JTextField();
        DescriptionLabel = new javax.swing.JLabel();
        ManufacturerText = new javax.swing.JTextField();

        NumberOfStocksLabel.setText("Number Of Stocks");

        ManufacturerLabel.setText("Manufacturer");

        SubmitItemButton.setText("Submit");
        SubmitItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitItemButtonActionPerformed(evt);
            }
        });

        UrlLabel.setText("Url");

        BarcodeLabel.setText("Barcode");

        TitleLabel.setText("Title");

        DescriptionLabel.setText("Description");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(282, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SubmitItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ManufacturerLabel)
                            .addComponent(DescriptionLabel)
                            .addComponent(NumberOfStocksLabel)
                            .addComponent(TitleLabel)
                            .addComponent(BarcodeLabel)
                            .addComponent(UrlLabel))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UrlText)
                            .addComponent(BarcodeText)
                            .addComponent(TitleText)
                            .addComponent(DescriptionText)
                            .addComponent(ManufacturerText)
                            .addComponent(NumberOfStocksText, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))))
                .addGap(242, 242, 242))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BarcodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BarcodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TitleText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DescriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ManufacturerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ManufacturerText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UrlLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UrlText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumberOfStocksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumberOfStocksText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SubmitItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitItemButtonActionPerformed
        // TODO add your handling code here:
        int dialogResult = mainPage.tampilkanConfirmDialog();
        if(dialogResult != JOptionPane.YES_OPTION) {return;}

        String[] input = {
            BarcodeText.getText(),
            TitleText.getText(),
            DescriptionText.getText(),
            ManufacturerText.getText(),
            UrlText.getText(),
            NumberOfStocksText.getText()
        };

        mainPage.newSuratJalan(input);
    }//GEN-LAST:event_SubmitItemButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BarcodeLabel;
    private javax.swing.JTextField BarcodeText;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JTextField DescriptionText;
    private javax.swing.JLabel ManufacturerLabel;
    private javax.swing.JTextField ManufacturerText;
    private javax.swing.JLabel NumberOfStocksLabel;
    private javax.swing.JTextField NumberOfStocksText;
    private javax.swing.JButton SubmitItemButton;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField TitleText;
    private javax.swing.JLabel UrlLabel;
    private javax.swing.JTextField UrlText;
    // End of variables declaration//GEN-END:variables
}
