package task4_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class LibraryServer {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("server on port " + PORT + "...");

        // TODO(10):
        try  {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("new client: " + clientSocket.getInetAddress());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Бизнес логиката в отделен клас

}
