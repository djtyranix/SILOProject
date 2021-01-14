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
}
