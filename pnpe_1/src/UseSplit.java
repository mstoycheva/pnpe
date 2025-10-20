import java.util.Scanner;

public class UseSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.nextLine();

        String[] words = s.trim().split(" ");
        System.out.println("Counter Words: " + words.length);

    }
}
