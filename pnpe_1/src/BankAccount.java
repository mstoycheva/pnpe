import java.util.Scanner;

public class BankAccount {
    private String owner;
    private double balance;
    private static double INTEREST_RATE = 0.02;

    public static double calculateInterest(double amount) {
        return INTEREST_RATE * amount;
    }

    public static void main(String[] args) {
        System.out.println("Enter amount: ");
        double amount = new Scanner(System.in).nextDouble();
        System.out.println(calculateInterest(amount));
    }
}
