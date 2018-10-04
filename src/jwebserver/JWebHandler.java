/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwebserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class JWebHandler implements Runnable {
    
    private final Request request;
    private final Response response;
    private final Socket socket;
    
    static final File WEB_ROOT = new File(".");
    static final String DEFAULT_FILE =  "index.html";
    
    JWebHandler(Socket s) throws IOException {        
        request = new Request(s);
        response = new Response(s);
        socket = s;       
    }

    @Override
    public void run() {
        try {
            server_file(request.url);
        } 
        catch (IOException ex) {
            Logger.getLogger(JWebHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            closeConnection();
        } catch (IOException ex) {
            Logger.getLogger(JWebHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void server_file(String fileReq) throws IOException {
        if(fileReq.endsWith("/")) {
            fileReq += DEFAULT_FILE;
        }
        
        try {
            File file = new File(WEB_ROOT, fileReq);
            String content = getContentType(fileReq);
        
            response.writeHead(200, content);
            response.end(file);
        }
        catch(FileNotFoundException e) {
            response.writeHead(404, "text/html");
            response.end("404 Not Found");
        }
    }
    
    private void closeConnection() throws IOException {
        request.close();
        response.close();
        socket.close();
    }
    
    private String getContentType(String fileRequested) {
        if (fileRequested.endsWith(".htm")  ||  fileRequested.endsWith(".html"))
            return "text/html";
	
        if (fileRequested.endsWith(".css"))
            return "text/css";
        
        if (fileRequested.endsWith(".js"))
            return "application/javascript";
        
        if (fileRequested.endsWith(".json"))
            return "application/json";
        
        if (fileRequested.endsWith(".jpg") ||  fileRequested.endsWith(".jpeg"))
            return "image/jpeg";
        
        if (fileRequested.endsWith(".png"))
            return "image/png";
        
        if (fileRequested.endsWith(".woff"))
            return "font/woff";
        
        if (fileRequested.endsWith(".map"))
            return "application/json";
        
        if (fileRequested.endsWith(".mp4"))
            return "video/mp4";
        
        return "text/plain";
    }
}
