import java.util.ArrayList;
import java.util.List;

public class Dealership{
    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void printAll() {
        if (cars.isEmpty()) {
            System.out.println("No cars in the dealership");
            return;
        }
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("#" + (i + 1) + ": "+ cars.get(i));
        }
    }

    public double totalEcoTax() {
        double sum = 0;
        for (Car car : cars) {
            sum += car.ecoTax();
        }
        return sum;
    }

    public List<Car> filterByAC(Extras.ACType acType) {
        List<Car> resultCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getAcType() == acType) {
                resultCars.add(car);
            }
        }
        return resultCars;
    }


    public List<Car> filterByInterior(Extras.Interior interior) {
        List<Car> resultCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getInterior() == interior) {
                resultCars.add(car);
            }
        }
        return resultCars;
    }


    public List<Car> filterByRim(Extras.RimType rimType) {
        List<Car> resultCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getRimType() == rimType) {
                resultCars.add(car);
            }
        }
        return resultCars;
    }
}
