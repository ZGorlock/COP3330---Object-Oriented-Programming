/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import inputOutput.ConnectionData;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ZGorlock
 */
public class PostgreSQLConnect {
    /**
     * ConnectionData object holding the database properties
     */
    ConnectionData cd;
    
    /**
     * Constructor for PostgreSQLConnect.
     * @param cd
     */
    public PostgreSQLConnect(ConnectionData cd)
    {
        this.cd = cd;
    }
            
    /**
     * Initiates a connection with the dvdrental database
     */
    public void makeConnection()
    {
       Connection connect = null;
       
       try {
           Class.forName(cd.getType());
           //Connects to localhost:5432/dvdrental which is running on your computer
           //postgres is the user (owner of dvdrental)
           //cop3330 is the password to the database
           connect = DriverManager.getConnection(cd.toString(), cd.getLogin(), cd.getPassword());
       }
       catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName() + ": " + e.getMessage());
           System.exit(0);
       }
       
       //Confirmation message
       System.out.println("Opened database successfully");
    }
    
}
