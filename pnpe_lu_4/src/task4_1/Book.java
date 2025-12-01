package task4_1;

public class Book {
    // TODO(1): статично поле-брояч за аутоинкрементиране на id
    private static int counter = 1;

    // TODO(2): необходими полета
    private final int id;
    private String title;
    private String author;
    private boolean rented;
    private String rentedBy;

    public Book(String title, String author) {
        // TODO(3): присвояваме id чрез брояча
        this.id = counter++;
        this.title = title;
        this.author = author;
        this.rented = false;
        this.rentedBy = null;
    }

    // TODO(4): Getter за id
    public int getId() {
        return id;
    }

    // TODO(5): Добавяме и други getter-и (ако са ни полезни) - не са

    // TODO(6): Метод isRented() – връща дали книгата е наета
    public boolean isRented() {
        return rented;
    }

    // TODO(7): rent(String user) – отбелязва книгата като наета
    public void rent(String user) {
        if (!rented) {
            this.rented = true;
            this.rentedBy = user;
        }
    }

    // TODO(8): returnBook() – връща книгата (става свободна)
    public void returnBook() {
        this.rented = false;
        this.rentedBy = null;
    }

    // TODO(9): Предефиниране на toString() според състоянието
    @Override
    public String toString() {
        if (rented) {
            return "[" + id + "] " + title + " - " + author + " - " + rentedBy;
        }
        return "[" + id + "] " + title + " - " + author;
    }
}
