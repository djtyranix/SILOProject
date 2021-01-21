/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author micha
 */
public class MainPage extends javax.swing.JFrame {
    
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel;
    private HomePage homePage;
    private DaftarItem daftarItem;
    private DaftarSuratJalan daftarSuratJalan;
    private BuatSuratJalanForm buatSuratJalan;
    private DeliveryNotesDescription lastDeliveryNotesDescription;
    private InvoiceDescription lastInvoiceDescription;
    private ItemBaru itemBaru;
    private InvoiceBaru invoiceBaru;
    private Invoices invoice;
    private DBHandler dbHandler;
    private SuratJalanBaruCtl suratJalanBaruCtl;
    private InvoicesBaruCtl invoicesBaruCtl;
    private ItemBaruCtl itemBaruCtl;
    private DeliveryNotesDescriptionCtl deliveryNotesDescCtl;
    private SuratJalanCtl suratJalanCtl;
    
    public void initObjects()
    {
        dbHandler = new DBHandler();
        suratJalanCtl = new SuratJalanCtl(this);
        suratJalanCtl.addDBHandler(dbHandler);
        daftarItem = new DaftarItem();
        homePage = new HomePage();
        invoice = new Invoices();
        itemBaru = new ItemBaru(this);
        invoiceBaru = new InvoiceBaru(this);
        suratJalanBaruCtl = new SuratJalanBaruCtl(this);
        suratJalanBaruCtl.addDBHandler(dbHandler);
        invoicesBaruCtl = new InvoicesBaruCtl(this);
        invoicesBaruCtl.addDBHandler(dbHandler);
        itemBaruCtl = new ItemBaruCtl(this);
        itemBaruCtl.addDBHandler(dbHandler);
        deliveryNotesDescCtl = new DeliveryNotesDescriptionCtl(this);
        deliveryNotesDescCtl.addDBHandler(dbHandler);        
        
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        cardPanel.add(homePage, "Empty Panel");
        cardPanel.add(daftarItem, "Daftar Item");
        cardPanel.add(itemBaru, "Tambah Item");
        cardPanel.add(invoiceBaru, "Buat Invoice");
        cardPanel.add(invoice, "Invoice");
        setContentPane(cardPanel);
    }
    
    public void displayMainPage()
    {
        cardLayout.show(cardPanel, "Empty Panel");
    }
    
    public void displayItemList()
    {
        cardLayout.show(cardPanel, "Daftar Item");
    }
    
    public void displayDeliveryNotes()
    {
        if(daftarSuratJalan != null)
        {
            cardPanel.remove(daftarSuratJalan);
        }
        
        daftarSuratJalan = new DaftarSuratJalan(this);
        cardPanel.add(daftarSuratJalan, "Daftar Surat Jalan");
        cardLayout.show(cardPanel, "Daftar Surat Jalan");
    }
    
    public void displayAddDeliveryNotes()
    {
        if(buatSuratJalan != null)
        {
            cardPanel.remove(buatSuratJalan);
        }
        
        buatSuratJalan = new BuatSuratJalanForm(this);
        cardPanel.add(buatSuratJalan, "Buat Surat Jalan");
        cardLayout.show(cardPanel, "Buat Surat Jalan");
    }
    
    public void displayAddItems()
    {
        cardLayout.show(cardPanel, "Tambah Item");
    }
    
    public void displayAddInvoices()
    {
        cardLayout.show(cardPanel, "Buat Invoice");
    }
    
    public void displayInvoice()
    {
        cardLayout.show(cardPanel, "Invoice");
    }
    
    public int tampilkanConfirmDialog()
    {
        return suratJalanBaruCtl.tampilkanConfirmDialog();
    }
    
    public int tampilkanConfirmDialogItem()
    {
        return itemBaruCtl.tampilkanConfirmDialog();
    }
    
    public int tampilkanConfirmDialogInvoice()
    {
        return invoicesBaruCtl.tampilkanConfirmDialog();
    }
    
    public void newSuratJalan(String[] input)
    {
        DeliveryNote currentDeliveryNote = suratJalanBaruCtl.newSuratJalan(input);
        ArrayList<Item> itemList = deliveryNotesDescCtl.showCorrespondItems(currentDeliveryNote);
        
        if(currentDeliveryNote == null)
        {
            return;
        }
        
        if (lastDeliveryNotesDescription != null) {
            cardPanel.remove(lastDeliveryNotesDescription);
        }
        lastDeliveryNotesDescription = new DeliveryNotesDescription(this, currentDeliveryNote, itemList);
        cardPanel.add(lastDeliveryNotesDescription, "Detail Surat Jalan");
        cardLayout.show(cardPanel, "Detail Surat Jalan");
    }
    
    public void newItem(String[] input)
    {
        Item currentItem = itemBaruCtl.newItem(input);
        
        if(currentItem == null)
        {
            return;
        }
        
    }
    
    public void newInvoice(String[] input)
    {
        Invoice currentInvoice = invoicesBaruCtl.newInvoices(input);
        
        if(currentInvoice == null)
        {
            return;
        }
        
    }
    
    public ArrayList<DeliveryNote> getDeliveryNote()
    {
        ArrayList<DeliveryNote> deliveryNotes = suratJalanCtl.getDeliveryNote();
        
        return deliveryNotes;
    }
    
    public ArrayList<DeliveryNote> searchDeliveryNote(String keyword)
    {
        ArrayList<DeliveryNote> deliveryNotes = suratJalanCtl.searchDeliveryNote(keyword);
        
        return deliveryNotes;
    }
    
    /**
     * Creates new form MainPage
     */
    public MainPage() {
        setLayout(new BorderLayout());
        initComponents();
        initObjects();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        HomePageMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        ItemsMenu = new javax.swing.JMenuItem();
        CreateItemMenu = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        DeliveryNotesMenu = new javax.swing.JMenuItem();
        CreateDeliveryNotesMenu = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        InvoicesMenu = new javax.swing.JMenuItem();
        CreateInvoiceMenu = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Informasi Logistik - SILO");

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        jMenu5.setText("File");

        HomePageMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        HomePageMenu.setText("Home Page");
        HomePageMenu.setName("HomePageMenu"); // NOI18N
        HomePageMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomePageMenuActionPerformed(evt);
            }
        });
        jMenu5.add(HomePageMenu);
        jMenu5.add(jSeparator2);

        ItemsMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ItemsMenu.setText("Items");
        ItemsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemsMenuActionPerformed(evt);
            }
        });
        jMenu5.add(ItemsMenu);

        CreateItemMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        CreateItemMenu.setText("Create Item");
        CreateItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateItemMenuActionPerformed(evt);
            }
        });
        jMenu5.add(CreateItemMenu);
        jMenu5.add(jSeparator3);

        DeliveryNotesMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        DeliveryNotesMenu.setText("Delivery Notes");
        DeliveryNotesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeliveryNotesMenuActionPerformed(evt);
            }
        });
        jMenu5.add(DeliveryNotesMenu);

        CreateDeliveryNotesMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        CreateDeliveryNotesMenu.setText("Create Delivery Notes");
        CreateDeliveryNotesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateDeliveryNotesMenuActionPerformed(evt);
            }
        });
        jMenu5.add(CreateDeliveryNotesMenu);
        jMenu5.add(jSeparator4);

        InvoicesMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        InvoicesMenu.setText("Invoices");
        InvoicesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InvoicesMenuActionPerformed(evt);
            }
        });
        jMenu5.add(InvoicesMenu);

        CreateInvoiceMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        CreateInvoiceMenu.setText("Create Invoice");
        CreateInvoiceMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateInvoiceMenuActionPerformed(evt);
            }
        });
        jMenu5.add(CreateInvoiceMenu);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Edit");
        jMenu6.add(jSeparator1);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Quit Application");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ItemsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemsMenuActionPerformed
        // TODO add your handling code here:
        displayItemList();
        
    }//GEN-LAST:event_ItemsMenuActionPerformed

    private void DeliveryNotesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeliveryNotesMenuActionPerformed
        // TODO add your handling code here:
        displayDeliveryNotes();
    }//GEN-LAST:event_DeliveryNotesMenuActionPerformed

    private void CreateDeliveryNotesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateDeliveryNotesMenuActionPerformed
        // TODO add your handling code here:
        displayAddDeliveryNotes();
    }//GEN-LAST:event_CreateDeliveryNotesMenuActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void HomePageMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomePageMenuActionPerformed
        // TODO add your handling code here:
        displayMainPage();
    }//GEN-LAST:event_HomePageMenuActionPerformed

    private void InvoicesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InvoicesMenuActionPerformed
        // TODO add your handling code here:
        displayInvoice();
    }//GEN-LAST:event_InvoicesMenuActionPerformed

    private void CreateItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateItemMenuActionPerformed
        // TODO add your handling code here:
        displayAddItems();
    }//GEN-LAST:event_CreateItemMenuActionPerformed

    private void CreateInvoiceMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateInvoiceMenuActionPerformed
        // TODO add your handling code here:
        displayAddInvoices();
    }//GEN-LAST:event_CreateInvoiceMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
                new DaftarItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CreateDeliveryNotesMenu;
    private javax.swing.JMenuItem CreateInvoiceMenu;
    private javax.swing.JMenuItem CreateItemMenu;
    private javax.swing.JMenuItem DeliveryNotesMenu;
    private javax.swing.JMenuItem HomePageMenu;
    private javax.swing.JMenuItem InvoicesMenu;
    private javax.swing.JMenuItem ItemsMenu;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
