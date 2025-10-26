package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 이름 파서 테스트")
class CarParserTest {

    @Nested
    class 파싱_성공_테스트 {

        @Test
        void 공백을_제거하고_쉼표를_구분자로_파싱한다() {
            // when
            List<String> names = CarParser.parseCarNames("aaa, bbb,   ccc");

            // then
            assertThat(names).containsExactly("aaa", "bbb", "ccc");
        }

        @Test
        void 비어있는_이름은_무시한다() {
            // when
            List<String> names = CarParser.parseCarNames("aaa,,bbb, , ,ccc,");

            // then
            assertThat(names).containsExactly("aaa", "bbb", "ccc");
        }
    }

    @Nested
    class 파싱_예외_테스트 {

        @Test
        void 파싱_후_유효한_이름이_없다면_예외가_발생한다() {
            // when & then
            assertThatThrownBy(() -> CarParser.parseCarNames(" , ,   "))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 빈_문자열이_입력으로_들어오면_예외가_발생한다() {
            // when & then
            assertThatThrownBy(() -> CarParser.parseCarNames(""))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
