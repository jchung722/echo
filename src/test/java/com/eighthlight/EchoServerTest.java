package com.eighthlight;

import org.junit.Test;
import org.junit.Assert;
import java.io.*;

public class EchoServerTest {
    @Test
    public void createsSocketAndListensForClient() {
        SocketWrapperSpy testSocketWrapper = new SocketWrapperSpy();
        EchoServer testEchoServer = new EchoServer(testSocketWrapper);

        testEchoServer.start(333);

        Assert.assertTrue(testSocketWrapper.wasCreatedAndListened());
    }

    @Test
    public void receivesDataFromClient() {
        BufferedReader in = new BufferedReader(new StringReader("hello"));
        SocketWrapperSpy testSocketWrapper = new SocketWrapperSpy(in);
        EchoServer testEchoServer = new EchoServer(testSocketWrapper);

        testEchoServer.start(333);

        Assert.assertEquals("hello", testSocketWrapper.getReceivedData());
    }

    @Test
    public void sendsReceivedDataBackToClient() {
        BufferedReader in = new BufferedReader(new StringReader("hello"));
        SocketWrapperSpy testSocketWrapper = new SocketWrapperSpy(in);
        EchoServer testEchoServer = new EchoServer(testSocketWrapper);

        testEchoServer.start(333);

        Assert.assertEquals("hello", testSocketWrapper.getSentData());
    }

    @Test
    public void stopsIfInputIsGoodbye(){
        BufferedReader in = new BufferedReader(new StringReader("goodbye"));
        SocketWrapperSpy testSocketWrapper = new SocketWrapperSpy(in);
        EchoServer testEchoServer = new EchoServer(testSocketWrapper);

        testEchoServer.start(333);

        Assert.assertTrue(testSocketWrapper.isStopped());
    }

    @Test
    public void stopsIfInputIsGoodbyeCaseInsensitive(){
        BufferedReader in = new BufferedReader(new StringReader("GoOdByE"));
        SocketWrapperSpy testSocketWrapper = new SocketWrapperSpy(in);
        EchoServer testEchoServer = new EchoServer(testSocketWrapper);

        testEchoServer.start(333);

        Assert.assertTrue(testSocketWrapper.isStopped());
    }
}
