import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ReservationServer {
    private static final int PORT = 7777;

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
//                ClientHandler clientHandler = new ClientHandler();
//                Thread thread = new Thread(clientHandler);
//                thread.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }

    public static void main(String[] args) {

    }
}
