package SeaBattle.model;

import java.util.List;

public class GameField {

    GameCell[][] gameField;

    public static class GameCell {

        public void setAffected(boolean affected) {
            isAffected = affected;
        }

        public boolean isAffected() {
            return isAffected;
        }

        protected enum TypeOfCell {
            SHIP, MINE, MINESWEEPER, EMPTY
        }

        private boolean isAffected; //поражена
        private TypeOfCell type;

        public TypeOfCell getType() {
            return type;
        }

        public GameCell(String type, boolean isAffected) {
            switch (type) {
                case "ship" : this.type = TypeOfCell.SHIP;
                case "mine" : this.type = TypeOfCell.MINE;
                case "weeper" : this.type = TypeOfCell.MINESWEEPER;
                default : this.type = TypeOfCell.EMPTY;
            }
            this.isAffected = isAffected;
        }

        public boolean isEmpty() {
            return getType() == TypeOfCell.EMPTY;
        }
    }

    private List<Ship> ships = null;
    private List<Mine> mines = null;
    private List<Minesweeper> minesweepers = null;

    private final int rowsCount;
    private final int colCount;
    private final int shipsNumber;

    public GameField(int rowsCount, int colCount, int shipsNumber) {
        gameField = new GameCell[10][10];
        this.rowsCount = rowsCount;
        this.colCount = colCount;
        this.shipsNumber = shipsNumber;
    }

    public void addShip(Ship ship, GameCell cell) {
        ships.add(ship);
        if (ship.getType() == Ship.TypeOfShip.SINGLE) {
            if (ship.getDirection() == 0) {}
            else {}
        }
        else if (ship.getType() == Ship.TypeOfShip.DOUBLE) {
            if (ship.getDirection() == 0) {}
            else {}
        }
        else if (ship.getType() == Ship.TypeOfShip.TRIPLE) {
            if (ship.getDirection() == 0) {}
            else {}
        }
        else {
            if (ship.getDirection() == 0) {}
            else {}
        }
        //gameField[cell.getX()][cell.getY()]
    }

    public void addMine(Mine mine, GameCell cell) {

    }

    public void addMinesweeper(Minesweeper mw, GameCell cell) {

    }
}
