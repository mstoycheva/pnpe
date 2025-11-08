package task_1;

import java.util.*;

public class MainFlightSystem {
    public static Flight.status chooseStatus(Scanner scanner) {
        System.out.println("#1 PARKED");
        System.out.println("#2 TAXING");
        System.out.println("#3 RUNWAY");
        System.out.println("#4 DEPARTED");
        String choice;
        do {
            System.out.print("Your choice: ");
            choice = scanner.nextLine();
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4"));

        switch (choice) {
            case "1" -> { return Flight.status.PARKED; }
            case "2" -> { return Flight.status.TAXING; }
            case "3" -> { return Flight.status.RUNWAY; }
            default -> { return Flight.status.DEPARTED; }
        }
    }

    public static Queue<Flight> flightQueue = new LinkedList<>();
    public static List<Flight> allFlights = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("1. Add flight");
            System.out.println("2. Retrieve next flight");
            System.out.println("3. Change flight status");
            System.out.println("4. Show all flights");
            System.out.println("5. Exit");
            System.out.print("Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addFlight();
                case 2 -> retrieveNextFlight();
                case 3 -> changeFlightStatus();
                case 4 -> showAllFlights();
                case 5 -> System.out.println("Exit");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    public static void addFlight() {
        System.out.print("Enter flight number: ");
        String number = scanner.nextLine();

        System.out.print("Enter departure time: ");
        String time = scanner.nextLine();

        System.out.print("Enter destination: ");
        String dest = scanner.nextLine();

        System.out.println("Choose status:");
        Flight.status status = chooseStatus(scanner);

        Flight flight = new Flight(number, time, dest, status);
        flightQueue.add(flight);
        allFlights.add(flight);

        System.out.println("Flight added!");
    }

    private static void retrieveNextFlight() {
        Flight next = flightQueue.poll();
        if (next == null) {
            System.out.println("No more flights in queue.");
        } else {
            System.out.println("Next flight:");
            System.out.println(next);
        }
    }

    private static void changeFlightStatus() {
        System.out.print("Enter flight number: ");
        String number = scanner.nextLine();

        Flight found = null;
        for (Flight f : allFlights) {
            if (f.getFlightNumber().equalsIgnoreCase(number)) {
                found = f;
                break;
            }
        }

        if (found == null) {
            System.out.println("Flight not found.");
            return;
        }

        System.out.println("Choose a new status:");
        for (Flight.status s : Flight.status.values()) {
            System.out.println("- " + s);
        }
        System.out.print("New status: ");
        String newStatus = scanner.nextLine().toUpperCase();

        try {
            found.setStatus(Flight.status.valueOf(newStatus));
            System.out.println("Status changed successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status!");
        }
    }

    private static void showAllFlights() {
        if (allFlights.isEmpty()) {
            System.out.println("No flights found.");
            return;
        }

        for (Flight f : allFlights) {
            System.out.println(f);
        }
    }
}
