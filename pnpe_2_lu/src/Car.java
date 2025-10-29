public abstract class Car implements Extras{
    protected String make;
    protected String model;
    protected int year;
    protected double engineCapacity;
    protected double price;

    private ACType acType;
    private Interior interior;
    private RimType rimType;

    public Car(String make, String model, int year, double engineCapacity, double price, ACType acType, Interior interior, RimType rimType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.engineCapacity = engineCapacity;
        this.price = price;
        this.acType = acType;
        this.interior = interior;
        this.rimType = rimType;
    }

    public Car(String make, String model, int year, double price, ACType acType, Interior interior, RimType rimType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.engineCapacity = 0;
        this.acType = acType;
        this.interior = interior;
        this.rimType = rimType;
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
        if (acType == ACType.MANUAL) {
            totalPrice += 500;
        } else if (acType == ACType.AUTOMATIC) {
            totalPrice += 900;
        }
        if (interior == Interior.LEATHER) {
            totalPrice += 1200;
        }
        if (rimType == RimType.ALLOY) {
            totalPrice += 600;
        }
        return totalPrice;
    }
    
    @Override
    public String toString() {
        return "make: " + make + ", model: " + model + ", year: " + year + ", price: " + price;
    }
}
