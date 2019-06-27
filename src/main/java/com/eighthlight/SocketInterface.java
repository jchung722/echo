package com.eighthlight;

import java.io.IOException;

public interface SocketInterface {
    void createAndListen(int port) throws IOException;
    String receiveData() throws IOException;
    void sendData(String data);
    void stop();
}
