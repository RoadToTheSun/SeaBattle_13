/*
package SeaBattle.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GameField implements Placable {

    Scanner scanner = new Scanner(System.in);

    public GameCell[][] gameField;

    private List<Ship> ships = null;
    private List<Mine> mines = null;
    private List<Minesweeper> minesweepers = null;

    public static final int shipsNumber = 10;
    public static final int rowsCount = 10;
    public static final int colCount = 10;

    public GameField(GameCell[][] field) {
        gameField = field;
    }

    public GameField() {
        gameField = new GameCell[rowsCount][colCount];
        for (int r = 0; r < rowsCount; r++)
            for (int c = 0; c < colCount; c++) {
                gameField[r][c] = new GameCell(r, c);
            }
        init();
    }

    @Override
    public String toString() {
        drawField();
        return null;
    }

    private void init() {
        placeShips();
        addMine();
        addMinesWeeper();
    }

    public List<Ship> getShips() {
        return ships;
    }

    public List<Mine> getMines() {
        return mines;
    }

    public List<Minesweeper> getMinesweepers() {
        return minesweepers;
    }

    public void drawField() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < gameField.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < gameField[1].length; j++) {
                switch (gameField[j][i].getState()) {
                    case NULL:
                        System.out.print("☐ ");
                        break;
                    case INJURED:
                        System.out.print("X ");
                        break;
                    case MINE:
                        System.out.print("⚪ ");
                        break;
                    default://minesweeper
                        System.out.print("▲ ");
                        break;
                }
            }
            System.out.println();
        }
    }

    public void placeShips() {
        ships = new ArrayList<>();
        int deck = 4;
        while (deck >= 1) {
//            System.out.println();
//            System.out.println(player.getId() + ", please place your " + deck + "-deck ship on the battlefield:");
//            System.out.println();

            drawField();

            System.out.println("Please enter OX coordinate:");
            int x = scanner.nextInt();
            System.out.println("Please enter OY coordinate:");
            int y = scanner.nextInt();
            System.out.println("Choose direction:");
            System.out.println("1. Vertical.");
            System.out.println("2. Horizontal.");
            int direction = scanner.nextInt();
            if (!isAvailable(x, y, deck, direction)){
                System.out.println("Wrong coordinates!");
                continue;
            }
            for (int i = 0; i < deck; i++) {
                if (direction == 1) {
                    gameField[x][y + i].setType(SHIP);
                } else {
                    gameField[x + i][y].setType(SHIP);
                }
            }
            ships.add(new Ship(x, y, deck, direction));
            deck--;
            //clearScreen();
        }
    }

    public void addMine() {
        mines = new ArrayList<>();
        System.out.println("Please enter OX coordinate for a mine:");
        int x = scanner.nextInt();
        System.out.println("Please enter OY coordinate for a mine:");
        int y = scanner.nextInt();
        GameCell cell = new GameCell(x, y);
        while (cell.getType()!= MINE) {

            if (!isAvailable(x, y, 1, 1)) {

                System.out.println("Wrong coordinates!");
                System.out.println("Please enter OX coordinate for a mine:");
                x = scanner.nextInt();
                System.out.println("Please enter OY coordinate for a mine:");
                y = scanner.nextInt();
                cell = new GameCell(x, y);
                continue;
            }
            cell = gameField[x][y];
            gameField[x][y].setType(MINE);
            mines.add(new Mine(x, y));
            drawField();
        }
    }

    */
/*public void addMine(Mine mine, GameCell cell) {
        mines.add(mine);
        cell.setType(GameCell.TypeOfCell.MINE);
    }*//*


    public void addMinesWeeper() {
        minesweepers = new ArrayList<>();
        System.out.println("Please enter OX coordinate for a weeper:");
        int x = scanner.nextInt();
        System.out.println("Please enter OY coordinate for a weeper:");
        int y = scanner.nextInt();
        GameCell cell = new GameCell(x, y);
        while (cell.getType()!= MINESWEEPER) {
            if (!isAvailable(x, y, 1, 1)) {
                System.out.println("Wrong coordinates!");
                System.out.println("Please enter OX coordinate for a weeper:");
                x = scanner.nextInt();
                System.out.println("Please enter OY coordinate for a weeper:");
                y = scanner.nextInt();
                continue;
            }
            cell = gameField[x][y];
            gameField[x][y].setType(MINESWEEPER);
            minesweepers.add(new Minesweeper(x, y));
            drawField();
        }
    }

    */
/*public void addMinesweeper(Minesweeper mw, GameCell cell) {
        minesweepers.add(mw);
        cell.setType(GameCell.TypeOfCell.MINESWEEPER);
    }*//*


    private boolean isAvailable(int x, int y, int deck, int rotation) {
        // out of bound check
        if (rotation == 1) {
            if (y + deck > gameField.length) {
                return false;
            }
        }
        if (rotation == 0) {
            if (x + deck > gameField[0].length){
                return false;
            }
        }

        //neighbours check without diagonals
        //XXXX
        while (deck!=0) {
            for (int i = 0; i < deck; i++) {
                int xi = 0;
                int yi = 0;
                if (rotation == 1) {
                    yi = i;
                } else{
                    xi = i;
                }
        //gameField[x][y];
                if (x + 1 + xi < gameField.length && x + 1 + xi >= 0){
                    if (gameField[x + 1 + xi][y + yi].getType()!= EMPTY){
                        return false;
                    }
                }
                if (x - 1 + xi < gameField.length && x - 1 + xi >= 0){
                    if (gameField[x - 1 + xi][y + yi].getType()!= EMPTY){
                        return false;
                    }
                }
                if (y + 1 + yi < gameField.length && y + 1 + yi >= 0){
                    if (gameField[x + xi][y + 1 + yi].getType()!= EMPTY){
                        return false;
                    }
                }
                if (y - 1 + yi < gameField.length && y - 1 + yi >= 0){
                    if (gameField[x + xi][y - 1 + yi].getType()!= EMPTY){
                        return false;
                    }
                }
            }
            deck--;
        }
        return true;
    }
}
*/
