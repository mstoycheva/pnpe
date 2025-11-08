package task_5;

import java.util.Scanner;

public class MainEmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        try {
            EmailValidator.validateEmail(email);
        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
