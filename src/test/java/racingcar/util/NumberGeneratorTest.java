package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("난수 생성기 테스트")
class NumberGeneratorTest {

    @RepeatedTest(1000)
    void 범위_0_이상_9_이하의_정수를_반환한다() {
        // given
        NumberGenerator generator = new NumberGeneratorImpl();

        // when
        int value = generator.pick();

        // then
        assertThat(value).isBetween(0, 9);
    }
}
