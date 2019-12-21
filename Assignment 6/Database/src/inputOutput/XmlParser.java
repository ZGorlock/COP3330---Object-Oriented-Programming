/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputOutput;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author ZGorlock
 */
public class XmlParser {
    //Member Variables
    private ConnectionData connectionData;
    private Document document;

    /**
     * XmlParser Constructor
     * @param file - the file to parse
     */
    public XmlParser(String file)
    {
        parseXmlFile(file);
    }
    
    /**
     * Parses the XML file
     * @param file - the file to parse
     */
    public void parseXmlFile(String file)
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        
        //create document
        try {
            db = dbf.newDocumentBuilder();
            document = db.parse(ClassLoader.getSystemResourceAsStream(file));
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        
        //get nodes from document
        NodeList nl = document.getDocumentElement().getChildNodes();
        
        connectionData = new ConnectionData();
        //set member variable state
        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            
            if (n.getNodeName().equals("driver")) {
                connectionData.setType(n.getAttributes().getNamedItem("type").getNodeValue());
                
                NodeList children = n.getChildNodes();
                for (int j = 0; j < children.getLength(); j++) {
                    Node child = children.item(j);
                    String name = child.getNodeName();
                    switch (name) {
                        case "url" :
                            connectionData.setUrl(child.getTextContent());
                            break;
                        case "ipaddress" :
                            connectionData.setIpaddress(child.getTextContent());
                            break;
                        case "port" :
                            connectionData.setPort(child.getTextContent());
                            break;
                        case "database" :
                            connectionData.setDatabase(child.getTextContent());
                            break;
                        case "login" :
                            connectionData.setLogin(child.getTextContent());
                            break;
                        case "password" :
                            connectionData.setPassword(child.getTextContent());
                            break;
                    }
                }
                
                break;
            }
        }
    }
    
    //Getters/Setters
    
    /**
     * @return the connectionData
     */
    public ConnectionData getConnectionData() {
        return connectionData;
    }
    
}
