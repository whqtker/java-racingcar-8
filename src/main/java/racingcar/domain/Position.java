package racingcar.domain;

public record Position(int position) {

    public Position {
        if (position < 0) {
            throw new IllegalArgumentException("이동 위치는 0 이상이어야 합니다.");
        }
    }

    public Position next() {
        return new Position(position + 1);
    }
}
