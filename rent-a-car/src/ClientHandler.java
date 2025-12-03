import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler { //tuk implementirame ruuanble i overridvame run
    private Reservation reservation = new Reservation();
    private Socket socket = new Socket();

    public ClientHandler(Reservation reservation, Socket socket) {
        this.reservation = reservation;
        this.socket = socket;
    }

    public static void main(String[] args) throws IOException {
//        PrintStream printStream = new PrintStream(socket.getOutputStream());
//        Scanner input = new Scanner(socket.getInputStream());
        Scanner sc = new Scanner(System.in);
        try {
            do {
                System.out.println("1. Return car");
                System.out.println("2. List returned cars");
                System.out.println("3. Rent percent");
                System.out.println("4. Exit");
                System.out.println("Enter choice:");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1: reservation.returnCar(); break;
                    case 2: reservation.listFreeCars(); break;
                    case 3: reservation.rentPercent(); break;
                    case 4: System.exit(0);
                    default: System.out.println("Invalid choice");
                }
            } while(true);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            socket.close();
            sc.close();
            input.close();
        }
    }
}
