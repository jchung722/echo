package com.eighthlight;

public class EchoServer {
    private SocketInterface echoServerSocket;

    public EchoServer(SocketWrapper serverSocket){
        echoServerSocket = serverSocket;
    }

    public static void main(String[] args) {



//        try (
//                ServerSocket serverSocket = new ServerSocket(3333);
//                Socket clientSocket = serverSocket.accept();
//                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//                BufferedReader in = new BufferedReader( new InputStreamReader((clientSocket.getInputStream())));
//        ) {
//            out.println("Enter goodbye to exit.");
//            boolean done = false;
//            String inputLine;
//            while (!done && (inputLine = in.readLine()) != null) {
//                out.println("Server says:" + inputLine);
//
//                if(inputLine.toLowerCase().trim().equals("goodbye")){
//                    done = true;
//                }
//            }
//
//        } catch(IOException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
