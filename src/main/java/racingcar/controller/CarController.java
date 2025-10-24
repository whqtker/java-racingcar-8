package racingcar.controller;

import java.util.List;
import racingcar.service.CarService;
import racingcar.util.CarParser;
import racingcar.view.CarView;

public class CarController {

    private final CarView carView;
    private final CarService carService;

    public CarController(CarView carView, CarService carService) {
        this.carView = carView;
        this.carService = carService;
    }

    public void run() {
        String inputString = carView.inputNames();
        List<String> names = CarParser.parseCarNames(inputString);
        carService.registerCars(names);

        int loop = carView.inputLoop();
        for (int i = 0; i < loop; i++) {
            carService.move();
            carView.outputRound(carService.getCars());
        }

        carView.outputWinners(carService.getCars());
    }
}
