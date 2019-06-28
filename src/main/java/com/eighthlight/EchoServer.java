package com.eighthlight;

import java.io.IOException;

public class EchoServer {
    private SocketInterface echoServerSocket;

    public EchoServer(SocketInterface serverSocket){
        echoServerSocket = serverSocket;
    }

    public static void main(String[] args) {

    }

    public void start(int port) {
        try {
            echoServerSocket.createAndListen(port);
            String received = echoServerSocket.receiveData();
            if (received != null) {
                echoServerSocket.sendData(received);
                if (received.toLowerCase().trim().equals("goodbye")) {
                    echoServerSocket.stop();
                }
            }

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
