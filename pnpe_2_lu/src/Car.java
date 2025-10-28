public abstract class Car implements Extras{
    protected String make;
    protected String model;
    protected int year;
    protected double engineCapacity;
    protected double price;

    private ACType acType;
    private Interior interior;
    private RimType rimType;

    public Car(String make, String model, int year, double engineCapacity, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.engineCapacity = engineCapacity;
        this.price = price;
    }

    public abstract double ecoTax();

    public ACType getAcType() {
        return acType;
    }

    public void setAcType(ACType acType) {
        this.acType = acType;
    }

    public Interior getInterior() {
        return interior;
    }

    public void setInterior(Interior interior) {
        this.interior = interior;
    }

    public RimType getRimType() {
        return rimType;
    }

    public void setRimType(RimType rimType) {
        this.rimType = rimType;
    }

    @Override
    public double extrasPrice() {
        double totalPrice = 0;
        totalPrice += (acType == ACType.MANUAL) ? 500 : 900;
        totalPrice += (interior == Interior.FABRIC) ? 0 : 1200;
        totalPrice += (rimType == RimType.STEEL) ? 0 : 600;
        return totalPrice;
    }
    
    @Override
    public String toString() {
        return make + " " + model + " " + year + " " + engineCapacity + " " + price;
    }
}
