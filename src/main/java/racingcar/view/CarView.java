package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;

public class CarView {

    public String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int inputLoop() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String line = Console.readLine();
        try {
            int attempt = Integer.parseInt(line);

            if (attempt <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }

            return attempt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    public void outputRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void outputWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

        String winners = cars.stream()
                .filter(c -> c.getPosition() == maxPosition)
                .map(Car::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        System.out.println("최종 우승자 : " + winners);
    }
}
