/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwebserver;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author luis
 */
public class JWebHandler implements Runnable {
    
    private Request request;
    private Response response;
    
    JWebHandler(Socket s) throws IOException {        
        request = new Request(s);
        response = new Response(s);
    }

    @Override
    public void run() {
        System.out.println(request.url);
    }    
}
