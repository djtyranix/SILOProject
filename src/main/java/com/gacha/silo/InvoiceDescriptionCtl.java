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
 * @author Kevin
 */
public class InvoiceDescriptionCtl {
    DBHandler dbHandler;
    MainPage mainPage;
    
    public InvoiceDescriptionCtl(MainPage mainPage)
    {
        this.addMainPage(mainPage);
    }
    
    public void addDBHandler(DBHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public void addMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }
}
