package SeaBattle.model;

import java.util.ArrayList;

public class Ship {

    private ArrayList<GameCell> cells;
    private ArrayList<GameCell> borders;

    public ArrayList<GameCell> getShip() {
        return cells;
    }

    public void setShip(ArrayList<GameCell> cells) {
        this.cells = cells;
    }

    public void setBorders(ArrayList<GameCell> borders) {
        this.borders = borders;
    }

    public void die(){
        for (GameCell cell : cells) {
            cell.setState(GameCell.CellType.KILLED);
        }

        for (GameCell cell : borders) {
            cell.setState(GameCell.CellType.MISSED);
        }
    }
}
