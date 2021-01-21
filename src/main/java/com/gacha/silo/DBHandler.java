/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;

import java.sql.*;
import java.util.*;
/**
 *
 * @author micha
 */
public class DBHandler {
    
    private Connection myConnection;
    
    protected static Connection initDB()
            throws SQLException, ClassNotFoundException {
        String dbURL = "jdbc:mysql://localhost:3306/silo";
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbURL, "silo", "silo");
        return con;
    }
    
    //Checking whether items is in the database
    public String[] checkItems(String itemStr)
    {
        String[] res = null;
        
        try
        {
            Connection con = initDB();
            PreparedStatement st = con.prepareStatement("SELECT * FROM item WHERE barcode = ? OR title = ?");
            
            st.setString(1, itemStr);
            st.setString(2, itemStr);
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
                String id = Integer.toString(rs.getInt("id"));
                String numberOfStocks = Integer.toString(rs.getInt("numberOfStocks"));
                
                res = new String[]{
                    id,
                    rs.getString("barcode"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("manufacturer"),
                    rs.getString("url"),
                    numberOfStocks
                };
            }
            
            rs.close();
            st.close();
            con.close();
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
        return res;
    }
    
    //Saving the delivery notes into the database
    public String simpanSuratJalan(DeliveryNote deliveryNote)
    {
        String insertId = null;
        
        try
        {
            Connection con = initDB();
            Connection con2 = initDB();
            PreparedStatement st = con.prepareStatement("INSERT INTO deliverynote(invoice_id, custName, custEmail, orderDate, deliveryDate, items, status) VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            
            st.setString(1, deliveryNote.getInvoiceNumber());
            st.setString(2, deliveryNote.getCustomerName());
            st.setString(3, deliveryNote.getCustomerEmail());
            st.setString(4, deliveryNote.getOrderDate());
            st.setString(5, deliveryNote.getDeliveryDate());
            st.setString(6, deliveryNote.getItemStr());
            st.setInt(7, deliveryNote.getStatus());
            
            //System.out.print(st);
            st.executeUpdate();
            
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    insertId = generatedKeys.getString(1);
                }
                else {
                    throw new SQLException("Creating delivery note failed, no ID obtained.");
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            
            st.close();
            
            String parts[] = deliveryNote.getItemStr().split(",");
            
            for(String part : parts)
            {
                String[] temp = part.trim().split("-", 2);
                int idItem  = Integer.parseInt(temp[0]);
                int jmlItem = Integer.parseInt(temp[1]);
                int finalJumlah = 0;
                
                st = con.prepareStatement("SELECT * FROM item WHERE id = ?");
                
                st.setInt(1, idItem);
                ResultSet rs = st.executeQuery();
                
                if(rs.next())
                {
                    finalJumlah = rs.getInt("numberOfStocks") - jmlItem;
                    PreparedStatement st2 = con2.prepareStatement("UPDATE item SET numberOfStocks = ? WHERE id = ?");
                    
                    st2.setInt(1, finalJumlah);
                    st2.setInt(2, idItem);
                    st2.executeUpdate();
                    st2.close();
                }
                
                rs.close();
                st.close();
            }
            
            con2.close();
            con.close();
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
        return insertId;
    }
    
    //Getting item from id
    public Item getItem(int idItem)
    {
        Item item = null;
        
        try
        {
            Connection con = initDB();
            PreparedStatement st = con.prepareStatement("SELECT * FROM  item WHERE id = ?");
            
            st.setInt(1, idItem);
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
                String id = Integer.toString(rs.getInt("id"));
                String barcode = Integer.toString(rs.getInt("barcode"));
                String stocks = Integer.toString(rs.getInt("numberOfStocks"));
                
                item = new Item(id, barcode, rs.getString("title"), rs.getString("description"), rs.getString("manufacturer"), rs.getString("url"), stocks);
            }
            
            rs.close();
            st.close();
            con.close();
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
        return item;
    }
    
    public String simpanItem(Item item)
    {
        String insertId = null;
        
        try
        {
            Connection con = initDB();
            PreparedStatement st = con.prepareStatement("INSERT INTO item(barcode, title, description, manufacturer, url, numberOfStocks) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            
            st.setString(1, item.getBarcode());
            st.setString(2, item.getTitle());
            st.setString(3, item.getDescription());
            st.setString(4, item.getManufacturer());
            st.setString(5, item.getURL());
            st.setString(6, item.getNumberOfStocks());
            
            //System.out.print(st);
            st.executeUpdate();
            
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    insertId = generatedKeys.getString(1);
                }
                else {
                    throw new SQLException("Creating item failed, no ID obtained.");
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            
            st.close();
            
            con.close();
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
        return insertId;
    }
    
    public String simpanInvoice(Invoice invoice)
    {
        String insertId = null;
        
        try
        {
            Connection con = initDB();
            PreparedStatement st = con.prepareStatement("INSERT INTO invoice(poNumber, supplierName, orderDate, deliveryDate, status) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            
            st.setString(1, invoice.getPoNumber());
            st.setString(2, invoice.getSupplierName());
            st.setString(3, invoice.getOrderDate());
            st.setString(4, invoice.getDeliveryDate());
            st.setInt(5, invoice.getStatus());
            
//            System.out.print(st);
            st.executeUpdate();
            
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    insertId = generatedKeys.getString(1);
                }
                else {
                    throw new SQLException("Creating invoice failed, no ID obtained.");
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            
            st.close();
            
            con.close();
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
        return insertId;
    }
    
    public ArrayList<DeliveryNote> getAllDeliveryNotes()
    {
        ArrayList<DeliveryNote> deliveryNotes = new ArrayList<DeliveryNote>();
        DeliveryNote curDeliveryNote;
        
        try
        {
            Connection con = initDB();
            PreparedStatement st = con.prepareStatement("SELECT * FROM deliverynote");
            ResultSet rs = st.executeQuery();

            while(rs.next())
            {
                String id = Integer.toString(rs.getInt("id"));
                curDeliveryNote = new DeliveryNote(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                
                deliveryNotes.add(curDeliveryNote);
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
        return deliveryNotes;
    }
    
    public ArrayList<Item> getAllItems()
    {
        ArrayList<Item> items = new ArrayList<Item>();
        Item curItem;
        
        try
        {
            Connection con = initDB();
            PreparedStatement st = con.prepareStatement("SELECT * FROM item");
            ResultSet rs = st.executeQuery();

            while(rs.next())
            {
                String id = Integer.toString(rs.getInt("id"));
                curItem = new Item(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                
                items.add(curItem);
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
        return items;
    }
    
    public ArrayList<DeliveryNote> searchDeliveryNote(String keyword)
    {
        ArrayList<DeliveryNote> deliveryNotes = new ArrayList<DeliveryNote>();
        DeliveryNote curDeliveryNote;
        
        try
        {
            Connection con = initDB();
            PreparedStatement st = con.prepareStatement("SELECT * FROM deliverynote WHERE invoice_id = ? OR id = ?");
            
            st.setString(1, keyword);
            st.setString(2, keyword);
            
            //System.out.print(st);
            
            ResultSet rs = st.executeQuery();

            while(rs.next())
            {
                String id = Integer.toString(rs.getInt("id"));
                curDeliveryNote = new DeliveryNote(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                
                deliveryNotes.add(curDeliveryNote);
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
        return deliveryNotes;
    }
    
    public DeliveryNote changeDNStatus(int status, String id, DeliveryNote deliveryNote)
    {
        try
        {
            Connection con = initDB();
            PreparedStatement st = con.prepareStatement("UPDATE deliverynote SET status = ? WHERE id = ?");
            
            st.setInt(1, status);
            st.setString(2, id);
            st.executeUpdate();
            
            st.close();
            con.close();
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        deliveryNote.setStatus(status);
        
        return deliveryNote;
    }    
        
    public ArrayList<Item> searchItem(String keyword)
    {
        ArrayList<Item> items = new ArrayList<Item>();
        Item curItem;
        
        try
        {
            Connection con = initDB();
            PreparedStatement st = con.prepareStatement("SELECT * FROM item WHERE title = ? OR barcode = ?");
            
            st.setString(1, keyword);
            st.setString(2, keyword);
            
            //System.out.print(st);
            
            ResultSet rs = st.executeQuery();

            while(rs.next())
            {
                String id = Integer.toString(rs.getInt("id"));
                curItem = new Item(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                
                items.add(curItem);
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
        return items;
    }
}
