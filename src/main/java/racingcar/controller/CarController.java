package racingcar.controller;

import java.util.List;
import racingcar.service.CarService;
import racingcar.util.CarParser;
import racingcar.view.CarInputView;
import racingcar.view.CarOutputView;

public class CarController {

    private final CarInputView carInputView;
    private final CarOutputView carOutputView;
    private final CarService carService;

    public CarController(CarInputView carInputView, CarOutputView carOutputView, CarService carService) {
        this.carInputView = carInputView;
        this.carOutputView = carOutputView;
        this.carService = carService;
    }

    public void run() {
        String inputString = carInputView.inputNames();
        List<String> names = CarParser.parseCarNames(inputString);
        carService.registerCars(names);

        int loop = carInputView.inputLoop();
        for (int i = 0; i < loop; i++) {
            carService.move();
            carOutputView.outputRound(carService.getCars());
        }

        carOutputView.outputWinners(carService.getCars());
    }
}
