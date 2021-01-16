package SeaBattle.model.Players;

import SeaBattle.model.GameCell;
import SeaBattle.model.GameField;

public abstract class Player {
    Player opponent;
    GameField field;
    boolean myTurn;
    int shipsToKill = 10;
    ShootResult shootResult;

    Player() {
        field = new GameField();
    }
    public boolean moves(){
        return myTurn;
    }
    public int getShipsToKill() {
        return shipsToKill;
    }
    public GameField getField() {
        return field;
    }
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }
    protected void changeTurn(){
        myTurn = !myTurn;
        opponent.myTurn = !opponent.myTurn;
    }

    public enum ShootResult {
        MISSED,
        INJURED,
        KILLED
    }

    ShootResult getShot(int x, int y){
        GameCell cell = field.getCells()[x][y];
        if (cell.getState() == GameCell.CellType.NULL || cell.getState() == GameCell.CellType.ALIVE) {
            cell.getShot();
            switch (cell.getState()) {
                case MISSED:
                    return ShootResult.MISSED;
                case INJURED:
                    return ShootResult.INJURED;
                case KILLED:
                    return ShootResult.KILLED;
                default:
                    return null;
            }
        } return null;
    }
    abstract void afterShootingHandling(int x, int y);

    public void reset(){
        field.resetCells();
        shipsToKill = 10;
    }
}
