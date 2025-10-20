import java.util.Scanner;

public class TemperatureConverter {
    static double KELVIN_OFFSET = 273.15;
    public static double toCelsius(double degree) {
        return degree - KELVIN_OFFSET;
    }
    public static double toFahrenheit(double degree) {
        return (degree - KELVIN_OFFSET) * 9 / 5 + 32;
    }

    public static void main(String[] args) {
        System.out.println("Enter a kelvin degree:");
        double d = new Scanner(System.in).nextDouble();
        System.out.println("In celsius: " + TemperatureConverter.toCelsius(d));
        System.out.printf("In fahrenheit: %.2f%n", TemperatureConverter.toFahrenheit(d));
    }
}
