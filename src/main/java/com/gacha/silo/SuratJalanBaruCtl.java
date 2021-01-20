/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author micha
 */
public class SuratJalanBaruCtl {
    
    DBHandler dbHandler;
    MainPage mainPage;
    
    public SuratJalanBaruCtl(MainPage mainPage) {
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
                + "yakin ingin membuat surat jalan ini?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        return dialogResult;
    }
    
    public DeliveryNote newSuratJalan(String[] input)
    {
        DeliveryNote newSuratJalan = new DeliveryNote(
                input[0],
                input[1],
                input[2],
                input[3],
                input[4]
        );
        
        String itemStr = input[5];
        int jumlahItem;
        
        //Process only if there are items
        if (itemStr != null)
        {
            String[] items = itemStr.split(";");
            
            for(String item : items)
            {
                //Processing per item
                String[] temp = item.trim().split(" ", 2);
                jumlahItem = Integer.parseInt(temp[0].trim());
                String curItem = temp[1].trim();
                
                //Check whether item exists
                String[] itemDetail = dbHandler.checkItems(curItem);
                if(itemDetail == null)
                {
                    // If item doesn't exist
                    JOptionPane.showMessageDialog(null, "Item: " + itemStr + " tidak ditemukan!");
                    return null;
                }
                
                //Item found
                
            }
        }
        
        return newSuratJalan;
    }
}
