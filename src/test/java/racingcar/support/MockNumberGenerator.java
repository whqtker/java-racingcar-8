package racingcar.support;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import racingcar.util.NumberGenerator;

public class MockNumberGenerator implements NumberGenerator {

    private final Queue<Integer> numbers;

    public MockNumberGenerator(Integer... numbers) {
        this.numbers = new ArrayDeque<>(Arrays.asList(numbers));
    }

    @Override
    public int pick() {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return numbers.poll();
    }
}
