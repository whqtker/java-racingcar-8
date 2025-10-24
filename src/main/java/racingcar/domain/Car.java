package racingcar.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private String name;
    private int position = 0;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            this.position++;
        }
    }
}
