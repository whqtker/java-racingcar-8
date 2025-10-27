package racingcar.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private Name name;
    private Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public String getName() {
        return this.name.name();
    }

    public int getPosition() {
        return this.position.position();
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            this.position = this.position.next();
        }
    }
}
