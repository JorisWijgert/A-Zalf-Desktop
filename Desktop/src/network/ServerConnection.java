/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author brunodelsing
 */
public class ServerConnection {
    
    private final int PORT = 8888;
    private ServerSocket serverSocket;
    private Socket socket;
    
    private String text;
    private Object obj;
    
    private DataOutputStream dataOutputStream;
    
    public ServerConnection() throws IOException {
        serverSocket = new ServerSocket(8888);
    }
    
    public void sendText(String text) {
        this.text = text;
        this.send();
    }
    
    public void sendObject(Object obj) {
        this.obj = obj;
        this.send();
    }
    
    private void send() {
        while (true) {
            try {
                System.out.println("Listening on port:" + PORT);
                socket = serverSocket.accept();
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                System.out.println("ip: " + socket.getInetAddress());
                dataOutputStream.writeUTF(text);
                System.out.println("send");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    
}
