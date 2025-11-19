package servers_clients;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        int port = 6000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on: " + port);
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Client connected");

                try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                     PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        out.println(msg);
                        if (msg.equals("quit")) break;
                    }
                }
                System.out.println("Client disconnected");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

