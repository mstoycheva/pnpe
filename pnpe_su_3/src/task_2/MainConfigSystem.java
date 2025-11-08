package task_2;

import java.util.*;

public class MainConfigSystem {
    private static final List<ConfigUnit> configList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("1. Add configuration");
            System.out.println("2. Edit configuration");
            System.out.println("3. Show all configurations");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Enter number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addConfig();
                case 2 -> editConfig();
                case 3 -> showAllConfigs();
                case 4 -> System.out.println("Exit");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    private static void addConfig() {
        System.out.print("Enter key: ");
        String key = scanner.nextLine();

        System.out.print("Enter value: ");
        String value = scanner.nextLine();

        ConfigUnit config = new ConfigUnit(nextId++, key, value);
        configList.add(config);

        System.out.println("Configuration added successfully");
    }

    private static void editConfig() {
        if (configList.isEmpty()) {
            System.out.println("No configurations to edit");
            return;
        }

        System.out.print("Enter ID to edit: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Enter valid ID: ");
            scanner.next();
        }
        int id = scanner.nextInt();
        scanner.nextLine();

        ConfigUnit found = null;
        for (ConfigUnit c : configList) {
            if (c.getId() == id) {
                found = c;
                break;
            }
        }

        if (found == null) {
            System.out.println("Configuration not found.");
            return;
        }

        System.out.print("Enter new key (current: " + found.getKey() + "): ");
        String newKey = scanner.nextLine();
        if (!newKey.isEmpty()) found.setKey(newKey);

        System.out.print("Enter new value (current: " + found.getValue() + "): ");
        String newValue = scanner.nextLine();
        if (!newValue.isEmpty()) found.setValue(newValue);

        System.out.println("Configuration updated!");
    }

    private static void showAllConfigs() {
        if (configList.isEmpty()) {
            System.out.println("No configurations available.");
            return;
        }


        System.out.println("ID, KEY, VALUE");
        for (ConfigUnit c : configList) {
            System.out.println(c);
        }
    }
}
