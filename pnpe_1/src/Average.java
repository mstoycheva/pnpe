import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        int average;
        int sum = 0;
        int count = 0;
        for(int i = 0; i < 10; i++){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter number:");
            int res = input.nextInt();
            sum += res;
            count++;
        }
        average = sum / count;
        System.out.println("Average is " + average);
    }
}
