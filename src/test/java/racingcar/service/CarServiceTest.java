package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.support.MockNumberGenerator;
import racingcar.util.NumberGenerator;

@DisplayName("자동차 서비스 테스트")
class CarServiceTest {

    private CarRepository carRepository;
    private CarService carService;
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        // given
        carRepository = new CarRepository();
        numberGenerator = new MockNumberGenerator(4, 3, 9, 4);
        carService = new CarService(carRepository, numberGenerator);
    }

    @Nested
    class 자동차_등록_테스트 {

        @Test
        void 자동차_이름들을_등록하면_저장소에_추가된다() {
            // given
            List<String> names = List.of("aaa", "bbb");

            // when
            carService.registerCars(names);

            // then
            List<Car> cars = carService.getCars();
            assertAll(
                    () -> assertThat(cars).hasSize(2),
                    () -> assertThat(cars.get(0).getName()).isEqualTo("aaa"),
                    () -> assertThat(cars.get(0).getPosition()).isZero(),
                    () -> assertThat(cars.get(1).getName()).isEqualTo("bbb"),
                    () -> assertThat(cars.get(1).getPosition()).isZero()
            );
        }

        @Test
        void 중복_이름이_있으면_예외가_발생한다() {
            // given
            List<String> names = List.of("aaa", "aaa");

            // when & then
            assertThatThrownBy(() -> carService.registerCars(names))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class 자동차_이동_테스트 {

        @Test
        void 무작위_숫자에_따라_각_자동차의_이동이_결정된다() {
            // given
            carService.registerCars(List.of("aaa", "bbb"));

            // when
            carService.move(); // (4, 3)

            // then
            List<Car> cars = carService.getCars();
            assertAll(
                    () -> assertThat(cars.get(0).getPosition()).isEqualTo(1),
                    () -> assertThat(cars.get(1).getPosition()).isEqualTo(0)
            );
        }

        @Test
        void 이동_결과는_누적된다() {
            // given
            carService.registerCars(List.of("aaa", "bbb"));

            // when
            carService.move(); // (4, 3)
            carService.move(); // (9, 4)

            // then
            List<Car> cars = carService.getCars();
            assertAll(
                    () -> assertThat(cars.get(0).getPosition()).isEqualTo(2),
                    () -> assertThat(cars.get(1).getPosition()).isEqualTo(1)
            );
        }
    }
}
