import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dealership dealership = new Dealership();
        System.out.println("You need to enter 5 diesel cars, 5 petrol cars and 5 electric cars!");

        System.out.println("\nEverything was saved!\n");

        boolean flag = true;
        while (flag) {
            System.out.println("Choose an option:");
            System.out.println("#1 Print all cars");
            System.out.println("#2 Total eco tax");
            System.out.println("#3 Filter by extra");
            System.out.println("#4 Exit");
            String choice = new Scanner(System.in).nextLine().trim();
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
                    String filterChoice = new Scanner(System.in).nextLine().trim();
                    List<Car> resultCars = List.of();
                    switch (filterChoice) {
                        case "1":
                            Extras.ACType ac = chooseAc();
                            resultCars = dealership.filterByAC(ac);
                            break;
                        case "2":
//                            Extras.Interior interior = chooseInterior();
//                            resultCars = dealership.filterByInterior(interior);
                            break;
                        case "3":
//                            Extras.RimType rim = chooseRim();
//                            resultCars = dealership.filterByRim(rim);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            return;
                    }
                    if (resultCars.isEmpty()) {
                        System.out.println("Cars with extras were not found.");
                    } else {
                        System.out.println("Cars with extras:");
                        for (Car c : resultCars) {
                            System.out.println(c);
                        }
                        break;
                    }
                case "4":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again!");
            }
            System.out.println();
        }


        System.out.println("Exit.");
    }

//    private static Extras.RimType chooseRim() {
//    }
//
//    private static Extras.Interior chooseInterior() {
//    }

    public static Extras.ACType chooseAc() {
        System.out.println("#1 MANUAL");
        System.out.println("#2 AUTOMATIC");
        System.out.print("Your choice: ");
        String choice;
        do {
            choice = new Scanner(System.in).nextLine().trim();
        } while (!choice.equals("1") && !choice.equals("2"));
        if (choice.equals("1")) {
            return Extras.ACType.MANUAL;
        }
        return Extras.ACType.AUTOMATIC;
    }
}