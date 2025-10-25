package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarParser {

    public static List<String> parseCarNames(String names) {
        String[] tokens = names.split(",");
        List<String> result = new ArrayList<>();

        for (String token : tokens) {
            String trimmedToken = token.trim();
            if (!trimmedToken.isEmpty()) {
                result.add(trimmedToken);
            }
        }

        if (result.isEmpty()) {
            throw new IllegalArgumentException("1개 이상의 자동차 이름을 입력하세요.");
        }

        return result;
    }
}
