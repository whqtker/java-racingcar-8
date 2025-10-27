package racingcar;

import racingcar.controller.CarController;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.util.NumberGenerator;
import racingcar.util.NumberGeneratorImpl;
import racingcar.view.CarInputView;
import racingcar.view.CarOutputView;

public class Application {
    public static void main(String[] args) {
        CarRepository carRepository = new CarRepository();
        NumberGenerator numberGenerator = new NumberGeneratorImpl();
        CarService carService = new CarService(carRepository, numberGenerator);
        CarInputView carInputView = new CarInputView();
        CarOutputView carOutputView = new CarOutputView();

        CarController carController = new CarController(carInputView, carOutputView, carService);
        carController.run();
    }
}
