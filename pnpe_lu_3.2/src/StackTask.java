import java.util.Scanner;
import java.util.Stack;

public class StackTask {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add a new task");
            System.out.println("2. Remove last task");
            System.out.println("3. List all tasks");
            System.out.println("4. Exit program");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter a new task: ");
                    String task = sc.nextLine();
                    stack.push(task);
                    System.out.println("Task added");
                    break;

                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("No tasks to remove");
                    } else {
                        System.out.println("Removing last task: " + stack.pop());
                        System.out.println("Task removed");
                    }
                    break;

                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("No tasks available");
                    } else {
                        System.out.println("Tasks:");
                        for (String s : stack) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Try again");
            }

        } while (choice != 4);
    }
}
