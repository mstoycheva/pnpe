package task4_1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryClient {
    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) throws IOException {
       //TODO(12)
//        DataInputStream in = null;
//        DataOutputStream out = null;
        Socket socket = new Socket("127.0.0.1", 5000);
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        Scanner input = new Scanner(socket.getInputStream());
        String result = "";

        try {
//            in = new DataInputStream(clientSocket.getInputStream());
//            out = new DataOutputStream(clientSocket.getOutputStream());
//            int choice = in.readInt();
            int choice;
            do {
                System.out.println("1. Add a new book");
                System.out.println("2. Rent a book");
                System.out.println("3. Return a book");
                System.out.println("4. Exit");
                System.out.println("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        handleAdd();
                        break;
                    case 2:
                        handleRent();
                        break;
                    case 3:
                        handleReturn();
                        break;
                    default:
                        result = "invalid choice";
                }
            } while (choice != 4);

//            out.writeUTF(result);
//            out.flush();

            printStream.println(result);
            printStream.flush();

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        } finally {
            if(socket != null) {
                socket.close();
            }
            if (scanner != null)
                scanner.close();
            if (input != null)
                input.close();
        }
    }
    // TODO(12) тези методи работят с scanner
    private static void handleAdd() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the title of the book: ");
        String title = in.nextLine();
        System.out.println("Enter the author of the book: ");
        String author = in.nextLine();

        if (title.isBlank()) {
            return;
        }
        if (author.isBlank()) {
            return;
        }

        Book newBook = new Book(title, author);
        books.add(newBook);
        System.out.println("successfully added book: " + newBook);

    }

    // TODO(13)
    private static void handleRent() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the id of the book: ");
        int id = in.nextInt();
        in.nextLine();
        System.out.println("Enter the name of the user: ");
        String user = in.nextLine();

        Book book = findBook(id);
        if (book == null) {
            return;
        }
        if (book.isRented()) {
            return;
        }
        if (user.isBlank()) {
            return;
        }

        book.rent(user);
        System.out.println("successfully rented book: " + book);
    }

    // TODO(14)
    private static void handleReturn() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the id of the book: ");
        int id = in.nextInt();
        in.nextLine();
        Book book = findBook(id);
        if (book == null) {
            return;
        }
        if (!book.isRented()) {
            return;
        }

        book.returnBook();
        System.out.println("successfully returned book: " + book);
    }


    // TODO(12) тези методи работят с DataInputStream
//    private static String handleAdd(DataInputStream in) throws IOException {
//        String title = in.readUTF();
//        String author = in.readUTF();
//
//        if (title.isBlank()) {
//            return "title error";
//        }
//        if (author.isBlank()) {
//            return "author error";
//        }
//
//        Book newBook = new Book(title, author);
//        books.add(newBook);
//
//        return "book was added:  " + newBook;
//    }
//
//    // TODO(13)
//    private static String handleRent(DataInputStream in) throws IOException {
//        int id = in.readInt();
//        String user = in.readUTF();
//
//        Book book = findBook(id);
//        if (book == null) {
//            return "no book with id " + id;
//        }
//        if (book.isRented()) {
//            return "already rented";
//        }
//        if (user.isBlank()) {
//            return "user error";
//        }
//
//        book.rent(user);
//        return "book was rented: " + book;
//    }
//
//    // TODO(14)
//    private static String handleReturn(DataInputStream in) throws IOException {
//        int id = in.readInt();
//
//        Book book = findBook(id);
//        if (book == null) {
//            return "no book with " + id;
//        }
//        if (!book.isRented()) {
//            return "book was not rented";
//        }
//
//        book.returnBook();
//        return "book was returned: " + book;
//    }
//
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
