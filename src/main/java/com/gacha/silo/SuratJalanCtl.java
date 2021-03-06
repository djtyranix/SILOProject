/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;

import java.util.*;
import javax.swing.JOptionPane;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
/**
 *
 * @author micha
 */
public class SuratJalanCtl {

    DBHandler dbHandler;
    MainPage mainPage;

    public SuratJalanCtl(MainPage mainPage) {
        this.addMainPage(mainPage);
    }

    public void addDBHandler(DBHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public final void addMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    public ArrayList<DeliveryNote> getDeliveryNote() {
        ArrayList<DeliveryNote> deliveryNotes = dbHandler.getAllDeliveryNotes();

        return deliveryNotes;
    }

    public ArrayList<DeliveryNote> searchDeliveryNote(String keyword) {
        ArrayList<DeliveryNote> deliveryNotes = dbHandler.searchDeliveryNote(keyword);

        return deliveryNotes;
    }

    public void emailSend(String emailTo, String subject, String body) {
        JOptionPane.showMessageDialog(null, "Email sudah terkirim.");
        mainPage.displayItemList();
    }
    
    public void printDeliveryNote(DeliveryNote deliveryNote)
    {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(new TextPrinter(deliveryNote.details()));
        boolean doPrint = printJob.printDialog();
        if (doPrint) {
            try {
                printJob.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }
}
