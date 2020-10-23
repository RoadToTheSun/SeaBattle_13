package SeaBattle.model;

public class Ship {

    public enum TypeOfShip {
        SINGLE,
        DOUBLE,
        TRIPLE,
        FOURTH
    }

    private TypeOfShip type;
    private int direction;

    public Ship(int type, int dir) {
        switch (type) {
            case 1 : this.type = TypeOfShip.SINGLE;
            case 2 : this.type = TypeOfShip.DOUBLE;
            case 3 : this.type = TypeOfShip.TRIPLE;
            case 4 : this.type = TypeOfShip.FOURTH;
            default: this.type = TypeOfShip.SINGLE;
        }
        direction = dir == 0 ? 0 : 1;
    }

    public TypeOfShip getType() {
        return type;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "type=" + type +
                ", direction=" + direction +
                '}';
    }
}
