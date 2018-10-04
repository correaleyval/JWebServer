/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwebserver;

import java.io.IOException;

/**
 *
 * @author luis
 */
public class TestJWebServer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        JWebServer server = new JWebServer();
        
        int port = 8080;
        
        server.listen(port);
    }
    
}
