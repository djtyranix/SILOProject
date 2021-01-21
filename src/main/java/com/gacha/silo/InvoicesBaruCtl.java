/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;
import javax.swing.JOptionPane;
import java.util.*;
/**
 *
 * @author stugura
 */
public class InvoicesBaruCtl {
    
    DBHandler dbHandler;
    MainPage mainPage;
    
    public InvoicesBaruCtl(MainPage mainPage) {
        this.addMainPage(mainPage);
    }

    public void addDBHandler(DBHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public void addMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }
    
    public int tampilkanConfirmDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah anda "
                + "yakin ingin membuat invoices ini?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        return dialogResult;
    }
    
    public Invoice newInvoices(String[] input)
    {
        Invoice newInvoices = new Invoice(
                input[0],
                input[1],
                input[2],
                input[3],
                input[4]
        );
        
        String insertId = dbHandler.simpanInvoice(newInvoices);
        
        newInvoices.setId(insertId);
        
        return newInvoices;
    }
}
