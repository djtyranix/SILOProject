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
 * @author stugura
 */
public class ItemBaruCtl {
    
    DBHandler dbHandler;
    MainPage mainPage;
    
    public ItemBaruCtl(MainPage mainPage) {
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
                + "yakin ingin menambah item?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        return dialogResult;
    }
    
    public Item newItem(String[] input)
    {
        Item newItem = new Item(
                input[0],
                input[1],
                input[2],
                input[3],
                input[4],
                input[5],
                input[6]
        );
        
        return newItem;
    }
}
