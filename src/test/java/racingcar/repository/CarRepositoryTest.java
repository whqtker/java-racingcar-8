package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

@DisplayName("자동차 레포지토리 테스트")
class CarRepositoryTest {

    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        // given
        carRepository = new CarRepository();
    }

    @Nested
    class 저장_및_조회_테스트 {

        @Test
        void 초기_레포지토리는_비어있다() {
            // when
            List<Car> cars = carRepository.getCars();

            // then
            assertThat(cars).isEmpty();
        }

        @Test
        void 추가한_자동차는_정상적으로_조회된다() {
            // given
            Car car1 = new Car("aaa", 0);
            Car car2 = new Car("bbb", 0);

            // when
            carRepository.addCar(car1);
            carRepository.addCar(car2);
            List<Car> cars = carRepository.getCars();

            // then
            assertAll(
                    () -> assertThat(cars).hasSize(2),
                    () -> assertThat(cars).containsExactly(car1, car2)
            );
        }
    }
}
