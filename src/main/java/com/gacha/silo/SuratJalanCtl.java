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
public class SuratJalanCtl {
    
    DBHandler dbHandler;
    MainPage mainPage;
    
    public SuratJalanCtl(MainPage mainPage)
    {
        this.addMainPage(mainPage);
    }
    
    public void addDBHandler(DBHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public final void addMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }
    
    public ArrayList<DeliveryNote> getDeliveryNote()
    {
        ArrayList<DeliveryNote> deliveryNotes = new ArrayList<DeliveryNote>();
        
        deliveryNotes = dbHandler.getAllDeliveryNotes();
        
        return deliveryNotes;
    }
}
