package racingcar.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private String name;
    private int position = 0;

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String str) {
        if (str.isEmpty() || str.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1 ~ 5자여야 합니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            this.position++;
        }
    }
}
