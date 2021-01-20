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
                      
        DeliveryNote newSuratJalan;
        String itemStr = input[5];
        int jumlahItem;
        ArrayList<Item> itemList = new ArrayList<Item>();
        ArrayList<Integer> itemCount = new ArrayList<Integer>();
        String finalItemString = "";
        
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
                Item Item = new Item(itemDetail[0], itemDetail[1], itemDetail[2], itemDetail[3], itemDetail[4], itemDetail[5], itemDetail[6]);
                
                itemList.add(Item);
                itemCount.add(jumlahItem);
            }
            
            for(int i = 0; i < itemList.size(); i++)
            {
                if(i == itemList.size() - 1)
                {
                    finalItemString = finalItemString + itemList.get(i).getId() + "-" + itemCount.get(i);
                }
                else
                {
                    finalItemString = finalItemString + itemList.get(i).getId() + "-" + itemCount.get(i) + ",";
                }
            }
        }
        
        newSuratJalan = new DeliveryNote(
                input[0],
                input[1],
                input[2],
                input[3],
                input[4],
                finalItemString
        );
        
//        System.out.print(" " + newSuratJalan.getInvoiceNumber());
//        System.out.print(" " + newSuratJalan.getCustomerName());
//        System.out.print(" " + newSuratJalan.getCustomerEmail());
//        System.out.print(" " + newSuratJalan.getOrderDate());
//        System.out.print(" " + newSuratJalan.getDeliveryDate());
//        System.out.print(" " + newSuratJalan.getItemStr());
//        System.out.print(" " + newSuratJalan.getStatus());
        
        dbHandler.simpanSuratJalan(newSuratJalan);
        
        return newSuratJalan;
    }
}
