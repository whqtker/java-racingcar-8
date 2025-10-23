package racingcar.domain;

public class Car {

    private String name;
    private int velocity = 0;

    public Car(String name, int velocity) {
        this.name = name;
        this.velocity = velocity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVelocity() {
        return this.velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
}
