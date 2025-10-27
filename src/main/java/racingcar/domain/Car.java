package racingcar.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private Name name;
    private int position = 0;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public String getName() {
        return this.name.name();
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
