package task_6;

import java.util.Scanner;

public class MainPasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String pass = scanner.nextLine();

        try {
            PasswordValidator.validatePassword(pass);
        } catch (ShortPasswordException | NoUppercaseException |
                 NoDigitException | NoSpecialCharacterException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
