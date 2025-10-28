public class DieselCar extends Car {
    public DieselCar(String make, String model, int year, double engineCapacity, double price) {
        super(make, model, year, engineCapacity, price);
    }

    @Override
    public double ecoTax() {
        return 300 + 0.10 * engineCapacity;
    }
}
