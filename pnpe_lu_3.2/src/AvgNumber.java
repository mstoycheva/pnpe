import java.util.ArrayList;
import java.util.Scanner;

public class AvgNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            System.out.print("Enter a number or stop: ");
            String input = scanner.nextLine();

            if (input.equals("stop")) {
                break;
            }

            try {
                int num = Integer.parseInt(input);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Try again");
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("No numbers");
        } else {
            int count = numbers.size();
            double sum = 0;

            for (int n : numbers) {
                sum += n;
            }

            double avg = sum / count;

            System.out.println("Count: " + count);
            System.out.println("Avg: " + avg);
        }
    }
}
