package com.eighthlight;

import java.io.IOException;
import java.io.*;

public class SocketWrapperSpy implements SocketInterface {
    private boolean createdAndListened = false;
    private boolean stopped = false;
    private BufferedReader in;
//    private PrintWriter out;
    private String receivedData;
    private String sentData;


    public SocketWrapperSpy(BufferedReader in){
        this.in = in;
//        this.out = new PrintWriter(new StringWriter(), true);
    }

    public SocketWrapperSpy(){
        this(new BufferedReader(new StringReader("")));
    }

    public void createAndListen(int port) throws IOException {
        createdAndListened = true;
    }

    public String receiveData() throws IOException {
        receivedData = in.readLine();
        return receivedData;
    }

    public void sendData(String data) {
        sentData = data;
    }

    public void stop() {
        stopped = true;
    }

    public boolean wasCreatedAndListened() {
        return createdAndListened;
    }

    public boolean isStopped() {
        return stopped;
    }

    public String getReceivedData() {
        return receivedData;
    }

    public String getSentData() {
        return sentData;
    }
}
