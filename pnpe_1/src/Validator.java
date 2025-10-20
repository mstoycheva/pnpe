public class Validator {
    public static void main(String[] args) {
        Point p1 = new Point(1, 3);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(3, 6);

        if (Point.areCollinear(p1, p2, p3)) {
            System.out.println("Are Collinear");
        } else {
            System.out.println("Are not Collinear");
        }
    }
}
