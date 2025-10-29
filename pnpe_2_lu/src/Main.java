import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dealership dealership = new Dealership();
        Scanner scanner = new Scanner(System.in);

        System.out.println("You need to enter 5 diesel cars, 5 petrol cars and 5 electric cars!");

        for (int i = 0; i < 1; i++) {
            System.out.println("Entering diesel car #" + (i + 1));

            String make = readValidString(scanner, "Enter make for diesel car #" + (i + 1));
            String model = readValidString(scanner, "Enter model for diesel car #" + (i + 1));
            int year = readValidIntInRange(scanner, "Enter year (1900-2025) for diesel car #" + (i + 1), 1900, 2025);
            int engineCapacity = readValidIntInRange(scanner, "Enter engine capacity (> 0) for diesel car #" + (i + 1), 1, Integer.MAX_VALUE);
            double price = readValidDoubleInRange(scanner, "Enter price (>= 0) for diesel car #" + (i + 1), 0, Double.MAX_VALUE);

            System.out.println("Enter AC type for diesel car #" + (i + 1));
            Extras.ACType ac = chooseAc(scanner);

            System.out.println("Enter interior type for diesel car #" + (i + 1));
            Extras.Interior interior = chooseInterior(scanner);

            System.out.println("Enter rim type for diesel car #" + (i + 1));
            Extras.RimType rim = chooseRim(scanner);

            Car car = new DieselCar(make, model, year, engineCapacity, price, ac, interior, rim);
            dealership.getCars().add(car);
        }

        for (int i = 0; i < 1; i++) {
            System.out.println("Entering petrol car #" + (i + 1));

            String make = readValidString(scanner, "Enter make for petrol car #" + (i + 1));
            String model = readValidString(scanner, "Enter model for petrol car #" + (i + 1));
            int year = readValidIntInRange(scanner, "Enter year (1900-2025) for petrol car #" + (i + 1), 1900, 2025);
            int engineCapacity = readValidIntInRange(scanner, "Enter engine capacity (> 0) for petrol car #" + (i + 1), 1, Integer.MAX_VALUE);
            double price = readValidDoubleInRange(scanner, "Enter price (>= 0) for petrol car #" + (i + 1), 0, Double.MAX_VALUE);

            System.out.println("Enter AC type for petrol car #" + (i + 1));
            Extras.ACType ac = chooseAc(scanner);

            System.out.println("Enter interior type for petrol car #" + (i + 1));
            Extras.Interior interior = chooseInterior(scanner);

            System.out.println("Enter rim type for petrol car #" + (i + 1));
            Extras.RimType rim = chooseRim(scanner);

            Car car = new PetrolCar(make, model, year, engineCapacity, price, ac, interior, rim);
            dealership.getCars().add(car);
        }

        for (int i = 0; i < 1; i++) {
            System.out.println("Entering electrical car #" + (i + 1));

            String make = readValidString(scanner, "Enter make for electrical car #" + (i + 1));
            String model = readValidString(scanner, "Enter model for electrical car #" + (i + 1));
            int year = readValidIntInRange(scanner, "Enter year (1900-2025) for electrical car #" + (i + 1), 1900, 2025);
            int batteryCapacity = readValidIntInRange(scanner, "Enter battery capacity (> 0) for electrical car #" + (i + 1), 1, Integer.MAX_VALUE);
            double price = readValidDoubleInRange(scanner, "Enter price (>= 0) for electrical car #" + (i + 1), 0, Double.MAX_VALUE);

            System.out.println("Enter AC type for electrical car #" + (i + 1));
            Extras.ACType ac = chooseAc(scanner);

            System.out.println("Enter interior type for electrical car #" + (i + 1));
            Extras.Interior interior = chooseInterior(scanner);

            System.out.println("Enter rim type for electrical car #" + (i + 1));
            Extras.RimType rim = chooseRim(scanner);

            Car car = new ElectricCar(make, model, year, batteryCapacity, price, ac, interior, rim);
            dealership.getCars().add(car);
        }

        System.out.println("\nEverything was saved!\n");

        boolean flag = true;
        while (flag) {
            System.out.println("Choose an option:");
            System.out.println("#1 Print all cars");
            System.out.println("#2 Total eco tax");
            System.out.println("#3 Filter by extra");
            System.out.println("#4 Extra price per car");
            System.out.println("#5 Eco tax per car");
            System.out.println("#6 Exit");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    dealership.printAll();
                    break;
                case "2":
                    System.out.printf("Total eco tax: %.2f\n", dealership.totalEcoTax());
                    break;
                case "3":
                    System.out.println("Filter by extra:");
                    System.out.println("#1 ACType");
                    System.out.println("#2 Interior");
                    System.out.println("#3 RimType");

                    String filterChoice = scanner.nextLine();

                    List<Car> resultCars = List.of();

                    switch (filterChoice) {
                        case "1":
                            Extras.ACType ac = chooseAc(scanner);
                            resultCars = dealership.filterByAC(ac);
                            break;
                        case "2":
                            Extras.Interior interior = chooseInterior(scanner);
                            resultCars = dealership.filterByInterior(interior);
                            break;
                        case "3":
                            Extras.RimType rim = chooseRim(scanner);
                            resultCars = dealership.filterByRim(rim);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    if (!resultCars.isEmpty()) {
                        System.out.println("Cars with extras:");
                        for (Car c : resultCars) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("Cars with extras were not found.");
                    }
                    break;
                case "4":
                    System.out.println("Extras price per car:");
                    for (int i = 0; i < dealership.getCars().size(); i++) {
                        Car car = dealership.getCars().get(i);
                        double extrasPrice = car.extrasPrice();
                        System.out.printf("#%d: %s %s has extras price: %.2f\n", (i + 1), car.make, car.model, extrasPrice);
                    }
                    break;
                case "5":
                    System.out.println("Eco tax per car:");
                    for (int i = 0; i < dealership.getCars().size(); i++) {
                        Car car = dealership.getCars().get(i);
                        double exoTax = car.ecoTax();
                        System.out.printf("#%d: %s %s has eco tax: %.2f\n", (i + 1), car.make, car.model, exoTax);
                    }
                    break;
                case "6":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again!");
            }
            System.out.println();
        }

        scanner.close();
        System.out.println("Exit.");
    }

    public static int readValidIntInRange(Scanner scanner, String enter, int min, int max) {
        int value;
        do {
            System.out.println(enter);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
            value = scanner.nextInt();
            scanner.nextLine();

            if (value < min || value > max) {
                System.out.printf("Value must be between %d and %d. Try again.\n", min, max);
            }
        } while (value < min || value > max);
        return value;
    }

    public static double readValidDoubleInRange(Scanner scanner, String enter, double min, double max) {
        double value;
        do {
            System.out.println(enter);
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
            value = scanner.nextDouble();
            scanner.nextLine();

            if (value < min || value > max) {
                System.out.printf("Value must be between %.2f and %.2f. Try again.\n", min, max);
            }
        } while (value < min || value > max);
        return value;
    }

    public static String readValidString(Scanner scanner, String enter) {
        String value;
        do {
            System.out.println(enter);
            value = scanner.nextLine();
            if (value.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (value.isEmpty());
        return value;
    }

    private static Extras.RimType chooseRim(Scanner scanner) {
        System.out.println("#1 STEEL");
        System.out.println("#2 ALLOY");
        String choice;
        do {
            System.out.print("Your choice: ");
            choice = scanner.nextLine();
        } while (!choice.equals("1") && !choice.equals("2"));
        if (choice.equals("1")) {
            return Extras.RimType.STEEL;
        }
        return Extras.RimType.ALLOY;
    }

    private static Extras.Interior chooseInterior(Scanner scanner) {
        System.out.println("#1 FABRIC");
        System.out.println("#2 LEATHER");
        String choice;
        do {
            System.out.print("Your choice: ");
            choice = scanner.nextLine();
        } while (!choice.equals("1") && !choice.equals("2"));
        if (choice.equals("1")) {
            return Extras.Interior.FABRIC;
        }
        return Extras.Interior.LEATHER;
    }

    public static Extras.ACType chooseAc(Scanner scanner) {
        System.out.println("#1 MANUAL");
        System.out.println("#2 AUTOMATIC");
        String choice;
        do {
            System.out.print("Your choice: ");
            choice = scanner.nextLine();
        } while (!choice.equals("1") && !choice.equals("2"));
        if (choice.equals("1")) {
            return Extras.ACType.MANUAL;
        }
        return Extras.ACType.AUTOMATIC;
    }
}