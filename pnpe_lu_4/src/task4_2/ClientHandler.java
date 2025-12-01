package task4_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final Library library;

    public ClientHandler(Socket socket, Library library) {
        this.socket = socket;
        this.library = library;
    }

    @Override
    public void run() {
        System.out.println("Нов клиент: " + socket.getInetAddress() + ":" + socket.getPort());

        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // TODO(15):
            // В цикъл:
            // 1. Прочетете int command от клиента.
            // 2. Ако командата е 0 – изпратете съобщение за затваряне и прекъснете цикъла.
            // 3. Обработете командите:
            //      1 – добавяне на книга
            //      2 – наемане на книга
            //      3 – връщане на книга
            //
            //
            //   За 1,2,3 можете да извикате помощни методи:
            //      handleAdd(in), handleRent(in), handleReturn(in)
            //   и да върнете получените низове към клиента чрез out.writeUTF(...).
            //

            // Внимавайте да обработите EOFException – клиентът може да затвори сокета.

            // Временно, за да се вижда, че тук има TODO:
            System.out.println("TODO: имплементирайте протокола в run().");

        } catch (EOFException e) {
            System.out.println("Клиентът затвори връзката.");
        } catch (IOException e) {
            System.out.println("Грешка при обслужване на клиент: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {}
            System.out.println("Клиентът е прекъснат: " + socket.getInetAddress() + ":" + socket.getPort());
        }
    }

    // Операция 1 – добавяне на книга
    private String handleAdd(DataInputStream in) throws IOException {
        // TODO(16):
        // 1. Прочетете title и author (UTF низове) от входа.
        // 2. Извикайте library.addBook(title, author).
        // 3. Върнете подходящо съобщение:
        //    "Книгата е добавена: ..." + информация за книгата.
        return "TODO handleAdd";
    }

    // Операция 2 – наемане на книга
    private String handleRent(DataInputStream in) throws IOException {
        // TODO(17):
        // 1. Прочетете id (int) и user (UTF) от входа.
        // 2. Извикайте library.rentBook(id, user).
        // 3. Върнете получения низ.
        return "TODO handleRent";
    }

    // Операция 3 – връщане на книга
    private String handleReturn(DataInputStream in) throws IOException {
        // TODO(18):
        // 1. Прочетете id (int) от входа.
        // 2. Извикайте library.returnBook(id).
        // 3. Върнете получения низ.
        return "TODO handleReturn";
    }

    // Операция 4 – списък на всички книги
    private void handleListAll(DataOutputStream out) throws IOException {
        // TODO(19):
        // 1. Вземете списък с всички книги от library.getAllBooks().
        // 2. Изпратете броя им (out.writeInt(size)).
        // 3. За всяка книга изпратете out.writeUTF(book.toString()).
        System.out.println("TODO handleListAll");
    }
}
