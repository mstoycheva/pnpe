package task4_2;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // Колекцията от книги в библиотеката
    private final List<Book> books = new ArrayList<>();

    // TODO(10): Добавете синхронизиран метод за добавяне на книга
    // public synchronized Book addBook(String title, String author) { ... }
    public synchronized Book addBook(String title, String author) {
        // TODO(10):
        // 1. Проверете, че title и author не са празни (по желание).
        // 2. Създайте нов обект Book.
        // 3. Добавете го в списъка books.
        // 4. Върнете създадената книга.
        return null; // временно
    }

    // TODO(11): Добавете синхронизиран метод за наемане на книга по id
    // public synchronized String rentBook(int id, String user) { ... }
    public synchronized String rentBook(int id, String user) {
        // TODO(11):
        // 1. Намерете книгата по id (използвайте помощен метод findBookById).
        // 2. Ако няма такава книга → "Няма книга с id = ...".
        // 3. Ако вече е наета → "Книгата вече е наета: ...".
        // 4. Иначе отбележете, че е наета (book.rent(user))
        //    и върнете съобщение "Книгата е наета успешно: ...".
        return "TODO rentBook"; // временно
    }

    // TODO(12): Добавете синхронизиран метод за връщане на книга по id
    // public synchronized String returnBook(int id) { ... }
    public synchronized String returnBook(int id) {
        // TODO(12):
        // 1. Намерете книгата по id.
        // 2. Ако няма такава книга → "Няма книга с id = ...".
        // 3. Ако книгата не е била наета → "Книгата не е била наета".
        // 4. Иначе я върнете (book.returnBook())
        //    и върнете "Книгата е върната: ...".
        return "TODO returnBook"; // временно
    }

    // TODO(13): Връщане на копие на списъка с всички книги (по желание)
    public synchronized List<Book> getAllBooks() {
        // Примерно:
        // return new ArrayList<>(books);
        return new ArrayList<>(); // временно
    }

    // TODO(14): Помощен метод за търсене на книга по id
    private Book findBookById(int id) {
        // TODO(14):
        // 1. Обходете списъка books.
        // 2. Ако намерите книга с даденото id – върнете я.
        // 3. Ако няма такава – върнете null.
        return null; // временно
    }
}
