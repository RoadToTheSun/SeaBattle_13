package SeaBattle.model;

/**
 * Класс, моделирующий игровое поле
 */
public class GameField {
    /**
     * Максимальное и минимальное значения координаты
     */
    public static final int rowCount = 10, colCount = 10;

    /**
     * Ячейки составляющие данное поле
     */
    private GameCell[][] cells = new GameCell[rowCount][colCount];

    /**
     * Конструктор класса
     */
    public GameField() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                cells[j][i] = new GameCell(j, i, GameCell.CellType.NULL, null);
            }
        }

        FieldCreator.setBufferField(cells);
        FieldCreator.createShips(this);
    }

    /**
     * Геттер для ячеек поля
     * @return ячейки поля
     */
    public GameCell[][] getCells() {
        return cells;
    }

    /**
     * Сеттер для ячеек поля
     * @param cells ячейки поля
     */
    public void setCells(GameCell[][] cells) {
        this.cells = cells;
    }

    /**
     * Функция сбрасывает все ячейки поля в состояние NULL
     */
    public void resetCells(){
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                cells[j][i].setState(GameCell.CellType.NULL);
            }
        }

        FieldCreator.setBufferField(cells);
        FieldCreator.createShips(this);
    }
}

