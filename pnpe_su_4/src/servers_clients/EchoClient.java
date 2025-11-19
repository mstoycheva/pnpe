package servers_clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6000;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Server on " + host + " - " + port);

            boolean running = true;

            while (running) {
                System.out.print("Enter message: ");
                String message = scanner.nextLine();
                out.println(message);

                String response = in.readLine();
                if (response == null) {
                    System.out.println("Server closed");
                    break;
                }

                System.out.println("Server echoed: " + response);

                if (message.equalsIgnoreCase("quit")) {
                    running = false;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

