package SeaBattle.model;

public class Game {
    private final int timeFromStart;
    private final GameField gameField;

    public Game(GameField gameField) {
        this.timeFromStart = 0;
        this.gameField = gameField;
    }

    public int getTimeFromStart() {
        return timeFromStart;
    }
}
