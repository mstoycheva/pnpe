import java.util.Scanner;

public class MathUtils {
    public static int max(int a, int b) {
        //return Math.max(a, b);
        if (a > b) {
            return a;
        } else if (a < b) {
            return b;
        } else return a;
    }

    public static int min(int a, int b) {
        //return Math.min(a, b);
        if (a < b) {
            return a;
        } else if (a > b) {
            return b;
        } else return a;
    }

    public static int power(int base, int exp) {
        int result = 1;
        for(int i = 1; i <= exp; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Enter 2 numbers: ");
        int a = new Scanner(System.in).nextInt();
        int b = new Scanner(System.in).nextInt();
        System.out.printf("Max: %d\n", max(a, b));
        System.out.printf("Min: %d\n", min(a, b));
        System.out.printf("Power: %d\n", power(a, b));
    }
}
