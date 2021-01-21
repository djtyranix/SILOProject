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
 * @author micha
 */
public class DeliveryNotesDescriptionCtl {
    
    DBHandler dbHandler;
    MainPage mainPage;
    
    public DeliveryNotesDescriptionCtl(MainPage mainPage)
    {
        this.addMainPage(mainPage);
    }
    
    public void addDBHandler(DBHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public void addMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }
    
    public ArrayList<Item> showCorrespondItems(DeliveryNote deliveryNote)
    {
        ArrayList<Item> items = new ArrayList<Item>();
        
        String itemStr = deliveryNote.getItemStr();
        String[] parts = itemStr.trim().split(",");
        
        for(String part : parts)
        {
            String[] temp = part.trim().split("-", 2);
            int idItem = Integer.parseInt(temp[0]);
            String jmlItem = temp[1];
            
            Item curItem = dbHandler.getItem(idItem);
            curItem.setNumberOfStocks(jmlItem);
            
            items.add(curItem);
        }
        
        return items;
    }
    
    public DeliveryNote changeDNStatus(int status, String id, DeliveryNote deliveryNote)
    {
        return dbHandler.changeDNStatus(status, id, deliveryNote);
    }
}
