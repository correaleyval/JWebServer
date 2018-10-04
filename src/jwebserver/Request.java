/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwebserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 *
 * @author luis
 */
public class Request {
    private final BufferedReader in;
    
    public final String method;
    public final String url;
    
    Request(Socket s) throws IOException {

        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            
        String input = in.readLine();
            
        StringTokenizer parse = new StringTokenizer(input);
            
        method = parse.nextToken().toUpperCase();
           
        url = parse.nextToken().toLowerCase();
    }
}
