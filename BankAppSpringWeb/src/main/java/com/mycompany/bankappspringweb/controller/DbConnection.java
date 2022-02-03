package com.mycompany.bankappspringweb.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Niraj Shrestha
 */
@Controller
public class DbConnection 
{
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    private String classname = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localHost:3306/dbbank"; //dbbank(database name)
    private String dbUser = "root";
    private String dbPass = "admin";
    
    
    //constructor
    public DbConnection()
    {
        try
        {
            Class.forName(classname);
            conn = DriverManager.getConnection(url, dbUser, dbPass);
            System.out.println("Connected");
        } 
        catch (ClassNotFoundException ex) 
        {
            System.out.println("Please include driver file");
        } 
        catch (SQLException ex) 
        {
            System.out.println("Cannot connect to MYSQL");
            //ex.printStackTrace();
        }
    }
    
    //saves data after database returns rows
    public ResultSet select(String sql)
    {
        try 
        {
            st = conn.createStatement();
            return st.executeQuery(sql);         
        } 
        catch (SQLException ex) 
        {
            //ex.printStackTrace();
            return null;
        }
    }
    
    //in short insert, update and delete 
    public boolean iud(String sql)
    {
        try 
        {
            st = conn.createStatement();
            int r = st.executeUpdate(sql);
            return r>0;
        } 
        catch (SQLException ex) 
        {
            //ex.printStackTrace();
            return false;
        }
    }
    
    public Connection getConnection()
    {
        return conn;
    }
}