package task4_2;

public class LibraryServer {
    private final int port;
    private final Library library;

    public LibraryServer(int port) {
        this.port = port;
        this.library = new Library();
    }

    public void start() {
        System.out.println("Сървърът стартира на порт " + port + "...");

        // TODO(20):
        // 1. Създайте ServerSocket на дадения порт (try-with-resources).
        // 2. В безкраен цикъл:
        //    - приемайте клиентски връзки (accept()) → Socket clientSocket
        //    - създавайте нов ClientHandler(clientSocket, library)
        //    - стартирайте нова нишка: new Thread(handler).start();
        try {
            System.out.println("TODO: имплементирайте логиката за приемане на клиенти.");
        } catch (Exception e) {
            System.out.println("Грешка при стартиране/работа на сървъра: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int port = 5000;
        LibraryServer server = new LibraryServer(port);
        server.start();
    }
}
