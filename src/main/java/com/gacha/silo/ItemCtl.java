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
public class ItemCtl {
    DBHandler dbHandler;
    MainPage mainPage;
    
    public ItemCtl(MainPage mainPage)
    {
        this.addMainPage(mainPage);
    }
    
    public void addDBHandler(DBHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public final void addMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }
    
    public ArrayList<Item> getItem()
    {
        ArrayList<Item> Items = dbHandler.getAllItems();
        
        return Items;
    }
    
    public ArrayList<Item> searchItem(String keyword)
    {
        ArrayList<Item> Items = dbHandler.searchItem(keyword);
        
        return Items;
    }
}
