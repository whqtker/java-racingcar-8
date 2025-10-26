package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.util.NumberGenerator;

public class CarService {

    private final CarRepository carRepository;
    private final NumberGenerator numberGenerator;

    public CarService(CarRepository carRepository, NumberGenerator numberGenerator) {
        this.carRepository = carRepository;
        this.numberGenerator = numberGenerator;
    }

    public void registerCars(List<String> names) {
        validateDuplicatedNames(names);
        for (String name : names) {
            carRepository.addCar(new Car(name, 0));
        }
    }

    private void validateDuplicatedNames(List<String> names) {
        Set<String> distinctNames = new HashSet<>();
        for (String name : names) {
            if (!distinctNames.add(name)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
            }
        }
    }

    public void move() {
        List<Car> cars = carRepository.getCars();

        for (Car car : cars) {
            int randomValue = numberGenerator.pick();
            car.move(randomValue);
        }
    }

    public List<Car> getCars() {
        return carRepository.getCars();
    }
}
