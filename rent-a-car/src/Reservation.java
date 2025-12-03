import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Reservation {
    private ArrayList<Car> cars = new ArrayList<>();

    public String returnCar() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number: ");
        String id = in.readLine();
        if(!findId(id)) {
            System.out.println("No such id found");
        }

        System.out.println("Enter the office");
        String office = in.readLine();
        if(office.isBlank()) {
            System.out.println("No such office found");
        }

        System.out.println("Enter the date");
        LocalDate date = LocalDate.parse(in.readLine());
        if(!findDate(date)) {
            System.out.println("Date not between actual dates");
        }

        for(Car car : cars) {
            if(car.getId().equals(id)) {
                car.setReservation(false);
                car.setDateFromReservation(null);
                car.setDateToReservation(null);
                car.setOffice(office);

                return car.getId();
            }
        }
        return null;

    }

    public ArrayList<Car> listFreeCars() throws IOException {
        ArrayList<Car> freeCars = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number: ");
        String office = in.readLine();
        if(office.isBlank()) {
            System.out.println("No such office found");
        }

        System.out.println("Enter the date");
        LocalDate date = LocalDate.parse(in.readLine());
        for(Car car : cars) {
            if(car.getOffice().equals(office)) {
                if(findDate(date)) {
                    freeCars.add(car);
                }
            }
        }
        if(freeCars.isEmpty()) {
            return null;
        }
        else {
            return freeCars;
        }
    }

    public int rentPercent() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the date");
        LocalDate date = LocalDate.parse(in.readLine());
        int counter = 0;
        for(Car car : cars) {
            if(findDate(date)) {
                counter++;
            }
        }

        if(counter == 0) {
            return 0;
        } else return counter / cars.size() * 100;
    }

    public boolean findDate(LocalDate date) {
        for (Car car : cars) {
            if(date.isBefore(car.getDateFromReservation()) && date.isAfter(car.getDateToReservation())) {
                return true;
            }
        }
        return false;
    }

    public boolean findId(String id) {
        for(Car car : cars) {
            if(car.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
