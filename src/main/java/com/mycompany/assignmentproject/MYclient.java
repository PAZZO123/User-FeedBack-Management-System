/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentproject;

/**
 *
 * @author USER
 */
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MYclient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6666);
             DataOutputStream dout = new DataOutputStream(socket.getOutputStream())) {
            
            dout.writeUTF("Hello Server");
            dout.flush();
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

