package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.util.CarParser;
import racingcar.view.CarView;

public class CarController {

    private final CarView carView;
    private final CarRepository carRepository;

    public CarController(CarView carView, CarRepository carRepository) {
        this.carView = carView;
        this.carRepository = carRepository;
    }

    public void run() {
        String inputString = carView.input();
        List<String> carNames = CarParser.parseCarNames(inputString);
        for (String name : carNames) {
            carRepository.addCar(new Car(name, 0));
        }
    }
}
