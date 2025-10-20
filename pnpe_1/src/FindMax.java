import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {
        int max = 0;
        for(int i = 1; i<=10; i++){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the number: ");
            int num = scanner.nextInt();
            if(max < num) {
                max = num;
            }
        }
        System.out.println("MAX: " + max);
    }
}
