public class PetrolCar extends Car {
    public PetrolCar(String make, String model, int year, double engineCapacity, double price, ACType acType, Interior interior, RimType rimType) {
        super(make, model, year, engineCapacity, price, acType, interior, rimType);
    }

    @Override
    public double ecoTax() {
        return 200 + 0.08 * engineCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + ", engine capacity: " + engineCapacity;
    }

}
