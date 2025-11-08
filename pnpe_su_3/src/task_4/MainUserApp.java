package task_4;

import java.util.Scanner;

public class MainUserApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user = new User("admin", "12345");
        while (true) {
            System.out.print("Enter username: ");
            String inputUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String inputPassword = scanner.nextLine();

            if (!inputUsername.equals(user.getUsername())) {
                System.out.println("Invalid username");
                continue;
            }

            try {
                user.login(inputPassword);
                break;
            } catch (WrongPasswordException e) {
                System.out.println(e.getMessage());
            } catch (UserBlockedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
