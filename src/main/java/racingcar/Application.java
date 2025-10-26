package racingcar;

import racingcar.controller.CarController;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.util.NumberGenerator;
import racingcar.util.NumberGeneratorImpl;
import racingcar.view.CarView;

public class Application {
    public static void main(String[] args) {
        CarRepository carRepository = new CarRepository();
        NumberGenerator numberGenerator = new NumberGeneratorImpl();
        CarService carService = new CarService(carRepository, numberGenerator);
        CarView carView = new CarView();

        CarController carController = new CarController(carView, carService);
        carController.run();
    }
}
