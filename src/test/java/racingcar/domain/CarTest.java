package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 도메인 테스트")
class CarTest {

    @Nested
    class 자동차_이름_테스트 {

        @Test
        void 이름으로_자동차를_생성한다() {
            // given
            String name = "whqt";
            int position = 0;

            // when
            Car car = new Car(name, position);

            // then
            assertAll(
                    () -> assertThat(car.getName()).isEqualTo("whqt"),
                    () -> assertThat(car.getPosition()).isZero()
            );
        }

        @Test
        void 이름이_빈_문자열이거나_6자_이상이면_예외가_발생한다() {
            // given
            String emptyName = "";
            String longName = "whqtker";

            // when & then
            assertAll(
                    () -> assertThatThrownBy(() -> new Car(emptyName, 0))
                            .isInstanceOf(IllegalArgumentException.class),
                    () -> assertThatThrownBy(() -> new Car(longName, 0))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    class 자동차_이동_테스트 {

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 3})
        void 무작위_숫자가_3_이하이면_이동하지_않는다(int randomNumber) {
            // given
            Car car = new Car("whqt", 0);

            // when
            car.move(randomNumber);

            // then
            assertThat(car.getPosition()).isZero();
        }

        @ParameterizedTest
        @ValueSource(ints = {4, 5, 6, 7, 8, 9})
        void 무작위_숫자가_4_이상이면_이동한다(int randomNumber) {
            // given
            Car car = new Car("whqt", 0);

            // when
            car.move(randomNumber);

            // then
            assertThat(car.getPosition()).isEqualTo(1);
        }

        @Test
        void 이동_횟수는_누적된다() {
            // given
            Car car = new Car("whqt", 0);

            // when
            car.move(4);
            car.move(9);
            car.move(0);

            // then
            assertThat(car.getPosition()).isEqualTo(2);
        }
    }
}
