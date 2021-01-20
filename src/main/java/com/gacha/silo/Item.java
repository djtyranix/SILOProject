/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;

import java.util.*;
import java.text.ParseException;

/**
 *
 * @author stugura
 */
public class Item {

    private String Id;
    private String Barcode;
    private String Title;
    private String Description;
    private String Manufacturer;
    private String URL;
    private String NumberOfStocks;

    public Item(String Id, String Barcode, String Title, String Description, String Manufacturer, String URL,
            String NumberOfStocks) throws ParseException {
        setId(Id);
        setBarcode(Barcode);
        setTitle(Title);
        setDescription(Description);
        setManufacturer(Manufacturer);
        setURL(URL);
        setNumberOfStocks(NumberOfStocks);
    }

    public String getId() {
        return this.Id;
    }

    public String getBarcode() {
        return this.Barcode;
    }

    public String getTitle() {
        return this.Title;
    }

    public String getDescription() {
        return this.Description;
    }

    public String getManufacturer() {
        return this.Manufacturer;
    }

    public String getURL() {
        return this.URL;
    }

    public String getNumberOfStocks() {
        return this.NumberOfStocks;
    }

    public final void setId(String Id) {
        this.Id = Id;
    }

    public final void setBarcode(String Barcode) {
        this.Barcode = Barcode;
    }

    public final void setTitle(String Title) {
        this.Title = Title;
    }

    public final void setDescription(String Description) {
        this.Description = Description;
    }

    public final void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public final void setURL(String URL) {
        this.URL = URL;
    }

    public final void setNumberOfStocks(String NumberOfStocks) {
        this.NumberOfStocks = NumberOfStocks;
    }
}
