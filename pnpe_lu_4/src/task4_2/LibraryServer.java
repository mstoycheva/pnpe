package task4_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class LibraryServer {
    private final int port;
    private final Library library;

    public LibraryServer(int port, Library library) {
        this.port = port;
        this.library = library;
    }

    public void start()  {
        System.out.println("Server is listening on port " + port + "...");
        ServerSocket serverSocket = null;
        // TODO(10):
        try  {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket, library);
                Thread thread = new Thread(clientHandler);
                thread.start();
                System.out.println("new client: " + clientSocket.getInetAddress());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        int port = 5000;
        LibraryServer server = new LibraryServer(port, new Library());
        server.start();
    }

}
