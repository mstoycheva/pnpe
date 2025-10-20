import java.util.Scanner;

public class Circle {
    static double PI = 3.14159;
    public static double area(double radius) {
        return PI * radius * radius;
    }
    public static double perimeter(double radius) {
        return 2 * PI * radius;
    }

    public static void main(String[] args) {
        System.out.println("Enter the radius of the circle: ");
        double radius = new Scanner(System.in).nextDouble();
        System.out.printf("The area is %.3f%n", Circle.area(radius));
        System.out.printf("The perimeter is %.3f", Circle.perimeter(radius));
    }
}
