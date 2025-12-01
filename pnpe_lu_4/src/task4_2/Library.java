package task4_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books;
    public synchronized void handleAdd() {
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
    public synchronized void handleRent() {
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
    public synchronized void handleReturn() {
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

    public synchronized List<Book> getAllBooks() {
        return books;
    }

    public synchronized Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }
}
