package com.michaelliu.demo.java.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Michael on 8/15/16.
 */
public class EchoClient2 {

    private Socket socket;

    public EchoClient2(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    /**
     * This socket sends messages using byte stream
     */
    public void connect() throws IOException {
        try {
            OutputStream output = socket.getOutputStream();
            FileInputStream fis = new FileInputStream("input.txt");
            byte[] buffer = new byte[1024];
            int read;
            while ((read = fis.read(buffer)) != -1) {
                System.out.println("Client sends: " + new String(buffer, "UTF-8"));
                output.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new EchoClient("127.0.0.1", 8000).connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
