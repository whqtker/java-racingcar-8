package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGeneratorImpl implements NumberGenerator {

    @Override
    public int pick() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
