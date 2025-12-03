import java.time.LocalDate;

public class Car {
    private String id;
    private String make;
    private String model;
    private String engineType;
    private String gearType;
    private String office;
    private boolean reservation;
    private LocalDate dateFromReservation;
    private LocalDate dateToReservation;

    public Car(String id, String make, String model, String engineType, String gearType, String office, boolean reservation, LocalDate dateFromReservation, LocalDate dateToReservation) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.engineType = engineType;
        this.gearType = gearType;
        this.office = office;
        this.reservation = reservation;
        this.dateFromReservation = dateFromReservation;
        this.dateToReservation = dateToReservation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public boolean isReservation() {
        return reservation;
    }

    public void setReservation(boolean reservation) {
        this.reservation = reservation;
    }

    public LocalDate getDateFromReservation() {
        return dateFromReservation;
    }

    public void setDateFromReservation(LocalDate dateFromReservation) {
        this.dateFromReservation = dateFromReservation;
    }

    public LocalDate getDateToReservation() {
        return dateToReservation;
    }

    public void setDateToReservation(LocalDate dateToReservation) {
        this.dateToReservation = dateToReservation;
    }

    @Override
    public String toString() {
        return id + " " + make + " " + model + " " + engineType + " " + gearType + " office=" + office;
    }

}
