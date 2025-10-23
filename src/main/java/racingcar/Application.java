package racingcar;

import racingcar.controller.CarController;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.view.CarView;

public class Application {
    public static void main(String[] args) {
        CarRepository carRepository = new CarRepository();
        CarView carView = new CarView();

        CarController carController = new CarController(carView, carRepository);
        carController.run();
    }
}
