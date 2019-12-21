/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import inputOutput.ConnectionData;
import inputOutput.XmlParser;

/**
 *
 * @author ZGorlock
 */
public class Database {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Acquire Properties
        XmlParser parser = new XmlParser("inputOutput/properties.xml");
        ConnectionData cd = parser.getConnectionData();
        
        //Make new database connection
        PostgreSQLConnect pg = new PostgreSQLConnect(cd);
        pg.makeConnection();
    }
    
}
