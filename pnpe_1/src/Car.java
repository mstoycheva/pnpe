import java.util.Scanner;

public class Car {
    private String model;
    private static int count;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Car.count = count;
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.setModel("Audi");
        setCount(1);
        System.out.println(car.getModel() + " " + getCount());
    }
}
