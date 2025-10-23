package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class CarParser {

    public static List<String> parseCarNames(String names) {
        return Arrays.asList(names.split(","));
    }
}
