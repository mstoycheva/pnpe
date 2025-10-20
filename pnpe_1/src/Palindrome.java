import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.nextLine();
        String palindrome = new StringBuilder(s).reverse().toString();
        if(palindrome.equals(s)){
            System.out.println("Palindrome");
        } else{
            System.out.println("Not a palindrome");
        }
    }
}
