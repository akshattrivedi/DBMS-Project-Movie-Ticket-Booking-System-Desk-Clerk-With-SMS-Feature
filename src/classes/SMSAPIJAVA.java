/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URL; 
/**
 *
 * @author Akshat
 */
public class SMSAPIJAVA {
    
    
    public static void main(String args[])
    {
      try {
            
            String phone = "7000079368";
            mainclass.custName = "Akshat";
            mainclass.ticketID = "13738463";
            mainclass.totAmount = (float) 223.4;
            String message = "Sorry%20no%20seats%20left%20for%20your%20selection.";
            URL url = new URL("https://smsapi.engineeringtgr.com/send/?Mobile=7000079368&Password=goodluck&Message="+message+"&To="+phone+"&Key=aksha4XHC7a3Ytwsql2mevLO");
            URLConnection urlcon = url.openConnection();
            InputStream stream = urlcon.getInputStream();
            int i;
            String response="";
            while ((i = stream.read()) != -1) {
                response+=(char)i;
            }
            if(response.contains("success")){
                System.out.println("Successfully send SMS");
                //your code when message send success
            }else{
                System.out.println(response);
                //your code when message not send
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }   
    }   
    
}
