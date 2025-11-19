package servers_clients;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("FileServer");
            return;
        }
        String fileName = args[0];
        int port = 7000;

        File file = new File(fileName);
        if (!file.exists() || !file.isFile()) {
            System.out.println("File does not exist");
            return;
        }

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server on " + port);
            try (Socket clientSocket = serverSocket.accept();
                 DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                 BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream(file))
            ) {
                System.out.println("Client connected");
                out.writeLong(file.length());

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fileIn.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                System.out.println("Success");

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

