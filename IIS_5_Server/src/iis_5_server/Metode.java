/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iis_5_server;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author GraphX
 */
public class Metode {
    
     public String getTemp(String grad) {

        try {
            String url = "https://vrijeme.hr/hrvatska_n.xml";
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            f.setNamespaceAware(false);
            f.setValidating(false);
            DocumentBuilder b = f.newDocumentBuilder();
            URLConnection urlConnection = new URL(url).openConnection();
            urlConnection.addRequestProperty("Accept", "application/xml");
            Document doc = b.parse(urlConnection.getInputStream());
            doc.getDocumentElement().normalize();
            String expression = String.format("/Hrvatska/Grad[contains(GradIme,'%s')]/Podatci/Temp", grad);
            XPath xPath = XPathFactory.newInstance().newXPath();
            Node temp = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);

            return ((Element) temp).getFirstChild().getTextContent();

        } catch (ParserConfigurationException | IOException | SAXException | XPathExpressionException ex) {
            Logger.getLogger(Metode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "no data for that city";
    }
    
}
