/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;



public class TemperatureServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String grad = request.getParameter("grad");
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL(
                    "http://localhost:1090"));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);
            Object[] parametri = new Object[]{grad};
            String result = (String) client.execute("Metode.getTemp", parametri);
            getServletContext().setAttribute("temperatura", result);

        } catch (MalformedURLException | XmlRpcException e) {
        }
        response.sendRedirect("iis05.jsp");
    }

}
