package task_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPr {
    private static final List<Product> prStock = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Add product");
            System.out.println("2. Show prStock");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Enter number: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> showWarehouse();
                case 3 -> System.out.println("Exit");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Enter valid number: ");
            scanner.next();
        }
        int quantity = scanner.nextInt();

        System.out.print("Enter hazard level (0–10): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Enter valid number: ");
            scanner.next();
        }
        int hazard = scanner.nextInt();
        scanner.nextLine();

        Product product = new Product(name, quantity, hazard);

        try {
            storeProduct(product);
            prStock.add(product);
            System.out.println("Product stored successfully!");
        } catch (OverstockException | HazardousMaterialException e) {
            System.out.println("⚠️  " + e.getMessage());
        }
    }

    private static void storeProduct(Product p) throws OverstockException, HazardousMaterialException {
        if (p.getQuantity() > 1000) {
            throw new OverstockException("Quantity too high! (>" + 1000 + ")");
        }
        if (p.getHazardLevel() > 7) {
            throw new HazardousMaterialException("Hazard level too dangerous! (>7)");
        }
    }

    private static void showWarehouse() {
        if (prStock.isEmpty()) {
            System.out.println("Warehouse is empty.");
            return;
        }
        for (Product p : prStock) {
            System.out.println(p);
        }
    }
}