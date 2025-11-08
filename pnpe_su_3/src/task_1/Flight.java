package task_1;

public class Flight {
    private String flightNumber;
    private String departureTime;
    private String destination;
    public enum status {
        PARKED, TAXING, RUNWAY, DEPARTED
    };
    private status status;

    public Flight(String flightNumber, String departureTime, String destination, status status) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.destination = destination;
        this.status = status;
    }

    public Flight.status getStatus() {
        return status;
    }

    public void setStatus(Flight.status status) {
        this.status = status;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return String.format("Flight: %s, Departure: %s, Destination: %s, Status: %s",
                flightNumber, departureTime, destination, status);
    }
}
