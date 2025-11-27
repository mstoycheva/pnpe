import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class LibraryServer {
    private static final int PORT = 5000;
    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("server on port " + PORT + "...");

        // TODO(10):
        try  {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("new client: " + clientSocket.getInetAddress());
                handleClient(clientSocket);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Бизнес логиката в отделен клас

    private static void handleClient(Socket clientSocket) {
        // TODO(11)
        DataInputStream in = null;
        DataOutputStream out = null;
        String result = "";

        try {
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            int choice = in.readInt();

            switch (choice) {
                case 1 -> result = handleAdd(in);
                case 2 -> result = handleRent(in);
                case 3 -> result = handleReturn(in);
                default -> result = "invalid choice";
            }

            out.writeUTF(result);
            out.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException ignored) {}
        }
    }

    // TODO(12)
    private static String handleAdd(DataInputStream in) throws IOException {
        String title = in.readUTF();
        String author = in.readUTF();

        if (title.isBlank()) {
            return "title error";
        }
        if (author.isBlank()) {
            return "author error";
        }

        Book newBook = new Book(title, author);
        books.add(newBook);

        return "book was added:  " + newBook;
    }

    // TODO(13)
    private static String handleRent(DataInputStream in) throws IOException {
        int id = in.readInt();
        String user = in.readUTF();

        Book book = findBook(id);
        if (book == null) {
            return "no book with id " + id;
        }
        if (book.isRented()) {
            return "already rented";
        }
        if (user.isBlank()) {
            return "user error";
        }

        book.rent(user);
        return "book was rented: " + book;
    }

    // TODO(14)
    private static String handleReturn(DataInputStream in) throws IOException {
        int id = in.readInt();

        Book book = findBook(id);
        if (book == null) {
            return "no book with " + id;
        }
        if (!book.isRented()) {
            return "book was not rented";
        }

        book.returnBook();
        return "book was returned: " + book;
    }

    // TODO(15)
    private static Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }
}
