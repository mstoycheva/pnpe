public class ElectricCar extends Car {
    private double batteryCapacityKWh;

    public ElectricCar(String make, String model, int year, double price,  double batteryCapacityKWh, ACType acType, Interior interior, RimType rimType) {
        super(make, model, year, price, acType, interior, rimType);
        this.batteryCapacityKWh = batteryCapacityKWh;
    }

    @Override
    public double ecoTax() {
        return batteryCapacityKWh <= 50 ? 0 : 50;
    }


    @Override
    public String toString() {
        return super.toString() + ", battery capacity: " + batteryCapacityKWh;
    }
}
