public class ElectricCar extends Car {
    private double batteryCapacityKWh;

    public ElectricCar(String make, String model, int year, double engineCapacity, double price) {
        super(make, model, year, engineCapacity, price);
    }

    public double getBatteryCapacityKWh() {
        return batteryCapacityKWh;
    }

    public void setBatteryCapacityKWh(double batteryCapacityKWh) {
        this.batteryCapacityKWh = batteryCapacityKWh;
    }

    @Override
    public double ecoTax() {
        return batteryCapacityKWh <= 50 ? 0 : 50;
    }

    @Override
    public String toString() {
        return make + " " + model +  " " + year + " " + engineCapacity + " " + price + " " + batteryCapacityKWh;
    }
}
