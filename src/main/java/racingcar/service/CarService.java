package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
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
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    public List<Car> getCars() {
        return carRepository.getCars();
    }
}
