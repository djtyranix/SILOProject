/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;
import java.util.*;

/**
 *
 * @author micha
 */
public class InvoiceCtl {
    DBHandler dbHandler;
    MainPage mainPage;
    
    public InvoiceCtl(MainPage mainPage)
    {
        this.addMainPage(mainPage);
    }
    
    public void addDBHandler(DBHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public final void addMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }
    
    public ArrayList<Invoice> getInvoice()
    {
        ArrayList<Invoice> Invoices = dbHandler.getAllInvoices();
        
        return Invoices;
    }
    
    public ArrayList<Invoice> searchInvoice(String keyword)
    {
        ArrayList<Invoice> Invoices = dbHandler.searchInvoice(keyword);
        
        return Invoices;
    }
}
