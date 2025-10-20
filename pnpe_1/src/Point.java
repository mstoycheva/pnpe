class Point {
    private double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public static boolean areCollinear(Point a, Point b, Point c) {
        double determinant = (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y);
        return determinant == 0;
    }
}