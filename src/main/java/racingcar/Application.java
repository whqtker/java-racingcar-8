package racingcar;

import racingcar.controller.CarController;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.view.CarView;

public class Application {
    public static void main(String[] args) {
        CarRepository carRepository = new CarRepository();
        CarService carService = new CarService(carRepository);
        CarView carView = new CarView();

        CarController carController = new CarController(carView, carService);
        carController.run();
    }
}
