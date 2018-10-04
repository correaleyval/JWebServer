/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwebserver;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class Response {
    private PrintWriter out;
    private BufferedOutputStream dataOut;
    
    Response(Socket s) {
        try {
            out = new PrintWriter(s.getOutputStream());
            dataOut = new BufferedOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Response.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
