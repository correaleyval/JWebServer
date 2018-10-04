/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwebserver;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author luis
 */
public class JWebServer {
    public void listen(int port) throws IOException {
        ServerSocket serverConnect = new ServerSocket(port);
        
        while (true) {
            JWebHandler handler = new JWebHandler(serverConnect.accept());
            
            Thread thread = new Thread(handler);
            thread.start();
        }
    }
}
