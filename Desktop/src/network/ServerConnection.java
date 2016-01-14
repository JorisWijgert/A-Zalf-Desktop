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
    private int number;

    private DataOutputStream dataOutputStream;

    private boolean isOpen = true;

    public ServerConnection() throws IOException {
        serverSocket = new ServerSocket(8888);
        System.out.println("Listening on port:" + PORT);
    }

    public void sendText(String text) {
        this.text = text;
        isOpen = true;
        this.send("Text");
    }

    public void sendPatientNumber(int number) {
        this.number = number;
        isOpen = true;
        this.send("Number");
    }

    public void sendObject(Object obj) {
        this.obj = obj;
        this.send("Object");
    }

    private void send(String type) {
        while (isOpen) {
            try {
                socket = serverSocket.accept();
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                System.out.println("ip: " + socket.getInetAddress());

                if (type.equals("Number")) {
                    dataOutputStream.writeInt(number);
                } else if (type.equals("Text")) {
                    dataOutputStream.writeUTF(text);
                }
                System.out.println("send");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                        isOpen = false;
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
