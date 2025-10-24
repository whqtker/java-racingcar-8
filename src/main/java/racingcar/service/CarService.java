package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void registerCars(List<String> names) {
        for (String name : names) {
            carRepository.addCar(new Car(name, 0));
        }
    }

    public void round(int loop) {
        for (int i = 0; i < loop; i++) {
            move();
        }
    }

    private void move() {
        List<Car> cars = carRepository.getCars();

        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }
}
