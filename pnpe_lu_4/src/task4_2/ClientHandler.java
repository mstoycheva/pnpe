package task4_2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final Library library;

    public ClientHandler(Socket socket, Library library) {
        this.socket = socket;
        this.library = library;
    }

    @Override
    public void run() {
        System.out.println("New client: " + socket.getInetAddress() + ":" + socket.getPort());

        Scanner scanner;
        PrintStream printStream;
        Scanner input;
        String result = "";

        try {
            int choice;
            do {
                System.out.println("1. Add a new book");
                System.out.println("2. Rent a book");
                System.out.println("3. Return a book");
                System.out.println("4. Exit");

                System.out.println("Enter choice: ");

                scanner = new Scanner(System.in);
                printStream = new PrintStream(socket.getOutputStream());
                input = new Scanner(socket.getInputStream());

                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        library.handleAdd();
                        break;
                    case 2:
                        library.handleRent();
                        break;
                    case 3:
                        library.handleReturn();
                        break;
                    default:
                        result = "invalid choice";
                }
            } while (choice != 4);

            printStream.println(result);
//            printStream.flush(); ???

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Client disconnected: " + socket.getInetAddress() + ":" + socket.getPort());
        }
    }
}
