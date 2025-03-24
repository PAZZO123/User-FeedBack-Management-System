/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * @author USER
 */
public class Client {
    public static void main(String[] args){
      try{  
        Socket socket =new Socket("localhost",6669);
        Scanner fromConsole=new Scanner(System.in);
       Scanner  fromServer=new Scanner(socket.getInputStream());
       PrintWriter fromClient=new PrintWriter(socket.getOutputStream(),true);
     
       String input,output;
       while(true){
           System.out.print("You:");
           input=fromConsole.nextLine();
           if(input.equals("*Exit*")){
               break;
           }
          output=input.toUpperCase();
             fromClient.println(output);
             
             output=fromServer.nextLine();
             System.out.println("Server:");
             
             System.out.println(output);
             if(output.equals("*Exit*")){
               break;
           }
           
       }
       socket.close();
    }
      catch(IOException ex){
          
      }
    }
   
}
