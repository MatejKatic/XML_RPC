/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iis_5_server;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

/**
 *
 * @author GraphX
 */
public class IIS_5_Server {

      public static void main(String[] args) {
        try {
            int PORT = 1090;

            System.out.println("Starting XML-RPC 3.1.1 Server on port : " + PORT + " ... ");

            WebServer webServer = new WebServer(PORT);
            XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

            PropertyHandlerMapping propHandlerMapping = new PropertyHandlerMapping();
            propHandlerMapping.load(Thread.currentThread().getContextClassLoader(), "handler/handler.properties");
            xmlRpcServer.setHandlerMapping(propHandlerMapping);

            XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();

            webServer.start();

            System.out.println("Server started successfully...");
        } catch (Exception exception) {
            System.out.println("Something went wrong while starting the server : ");
            exception.printStackTrace();
        }
    }
}
