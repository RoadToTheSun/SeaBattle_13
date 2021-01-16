package SeaBattle.model.Players;

import SeaBattle.model.GameCell;
import SeaBattle.model.GameField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Класс игрока - человека
 */
public class HumanPlayer extends Player implements ActionListener {

    /**
     * Конструктор класса. Первый ход присваивается человеку
     */
    public HumanPlayer() {
        super();
        myTurn = true;
    }


    /**
     * Игрок стреляет по ячейкам соперника, кликая по ним.
     * Если сейчас очередь человека (myTurn == true)
     * его клик обрабатывается, вычисляются координаты ячейки (x, y) по которой человек кликнул
     * и вызывается функция shoot(x, y)
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (myTurn) {
            GameCell cell = (GameCell) e.getSource();
            shoot(cell.getX(), cell.getY());
        }
    }

    /**
     * Задаем ActionListner на все ячейки вражеского поля
     */
    public void setActionListnerToCells(){
        GameCell[][] cells = opponent.getField().getCells();
        for (int i = 0; i < GameField.rowCount; i++) {
            for (int j = 0; j < GameField.colCount; j++) {
                cells[j][i].addActionListener(this);
            }
        }
    }

    /**
     * Добавляем обработчик нажатий на ячейки оппонента
     * @param opponent оппонент игрока
     */
    @Override
    public void setOpponent(Player opponent) {
        super.setOpponent(opponent);
        setActionListnerToCells();
    }

    /**
     * После выстрела, если корабль врага был потоплен декриментируем shipsToKill
     * Извлекаем сообщение из MessageManager
     * @param x координата Х ячейки на игровом поле, в которую производился последний выстрел
     * @param y координата Y ячейки на игровом поле, в которую производился последний выстрел
     */
    @Override
    void afterShootingHandling(int x, int y) {
        if (shootResult == ShootResult.KILLED) shipsToKill--;
        //MessageManager.getInstance().getMessage(true, shootResult);
    }

    /**
     * для новой игры
     * очередь присваиваем себе
     * Корабли для уничтожения приравниваем 10
     * заново генерим игровое поле
     */
    @Override
    public void reset() {
        super.reset();
        myTurn = true;
        shipsToKill = 10;
    }

    /**
     * Функция вызывается при произведении выстрела человеком по ячейке соперника
     * @param x координата Х ячейки на игровом поле соперника, в которую производится выстрел
     * @param y координата Y ячейки на игровом поле соперника, в которую производится выстрел
     */
    private void shoot(int x, int y) {
        shootResult = opponent.getShot(x, y);
        if (shootResult == ShootResult.MISSED){
            changeTurn();
        }
        afterShootingHandling(0, 0);
    }
}
