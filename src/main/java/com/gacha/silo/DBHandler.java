/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gacha.silo;

import java.sql.*;
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
                String barcode = Integer.toString(rs.getInt("barcode"));
                String numberOfStocks = Integer.toString(rs.getInt("numberOfStocks"));
                
                res = new String[]{
                    id,
                    barcode,
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
}
