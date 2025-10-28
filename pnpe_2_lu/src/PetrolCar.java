public class PetrolCar extends Car {
    public PetrolCar(String make, String model, int year, double engineCapacity, double price) {
        super(make, model, year, engineCapacity, price);
    }

    @Override
    public double ecoTax() {
        return 200 + 0.08 * engineCapacity;
    }
}
