package SeaBattle.model;

public class Player {

    private final String id;
    private GameField gameField;
    private int[][] shoots;
    private boolean isFired;
    private GameField.GameCell lastShoot;

    public String getId() {
        return id;
    }

    public Player(String id, GameField gameField) {
        this.id = id;
        this.gameField = gameField;
        shoots = new int[10][10];
        isFired = false;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public void fire(GameField.GameCell cell) {
        lastShoot = cell;
        cell.setAffected(true);
        isFired = true;
    }

    public boolean isNext() {
        return !isFired || lastShoot.getType() != GameField.GameCell.TypeOfCell.EMPTY;
    }
}
