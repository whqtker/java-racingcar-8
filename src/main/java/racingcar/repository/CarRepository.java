package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarRepository {

    private final List<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
