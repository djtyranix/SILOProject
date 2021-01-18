/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;
import java.text.ParseException;
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
    
    public DeliveryNote newSuratJalan(String[] input) throws ParseException
    {
        DeliveryNote newSuratJalan = new DeliveryNote(
                input[0],
                input[1],
                input[2],
                input[3],
                input[4],
                input[5]
        );
        
        
        
        
    }
}
