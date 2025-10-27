package racingcar.domain;

public record Name(String name) {

    public Name {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1 ~ 5자여야 합니다.");
        }
    }
}
