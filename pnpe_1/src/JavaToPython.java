import java.util.Scanner;

public class JavaToPython {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.nextLine();
        String replaced = s.replaceAll("Java", "Python");
        System.out.println(replaced);
    }
}
