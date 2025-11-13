import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String text = sc.nextLine();

        if (text.isBlank()) {
            System.out.println("No text");
        } else {
            StringBuilder reversed = new StringBuilder();
            for (int i = text.length() - 1; i >= 0; i--) {
                reversed.append(text.charAt(i));
            }

            System.out.println(reversed);
        }
    }
}
