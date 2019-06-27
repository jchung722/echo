package com.eighthlight;
import java.net.*;
import java.io.*;

public class SocketWrapper implements SocketInterface {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void createAndListen(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String receiveData() {
        try {
            return in.readLine();
        } catch(IOException e) {
            return e.getMessage();
        }
    }

    public void sendData(String data) {
        out.println("Server says:" + data);
    }

    public void stop() {
        try {
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
