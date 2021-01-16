package SeaBattle.GUI;

import SeaBattle.model.Game;
import SeaBattle.model.GameCell;
import SeaBattle.model.GameField;

import javax.swing.*;
import java.awt.*;

/**
 * главный фрейм, на котором отображается игра
 *
 * Класс синглтон
 */
public class MyFrame extends JFrame {

    JPanel player1Field;
    JPanel player2Field;
    JPanel window;
    static JLabel textLabel;

    /**
     * Иконки для ячеек
     */
    private final ImageIcon alive = new ImageIcon(getClass().getResource("Resources/alive.png"));
    private final ImageIcon killed = new ImageIcon(getClass().getResource("Resources/killed.png"));
    private final ImageIcon injured = new ImageIcon(getClass().getResource("Resources/injured.png"));
    private final ImageIcon missed = new ImageIcon(getClass().getResource("Resources/missed.png"));
    private final ImageIcon nothing = new ImageIcon(getClass().getResource("Resources/null.png"));

    /**
     * наш синглтоновский инстанс
     */
    private static MyFrame instance;


    private MyFrame() throws HeadlessException {
        super("Sea Battle");
        setSize(800, 600);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*
        Главная панель, на которую крепится все остальные эллементы
        */
        window = new JPanel();

        initializeFields();
        textLabel = new JLabel("Мой ход");
        JButton newGameButton = new JButton("Новая игра");
        newGameButton.addActionListener(Game.getInstance());

        window.setLayout(new GridLayout(2, 2));
        window.add(textLabel);
        window.add(newGameButton);

        add(window);
        setVisible(true);


    }

    public void initializeFields(){
        player1Field = new JPanel();
        player2Field = new JPanel();

        initializeField(player1Field, Game.computerPlayer.getField());
        initializeField(player2Field, Game.humanPlayer.getField());

        window.add(player1Field);
        window.add(player2Field);
    }

    /**
     * функция создает отображаемую игровую панель игрового поля,
     * заполняя отображаемую игровую панель ячейками из матрицы
     * игрового поля
     * @param jPanel панель игрового поля
     * @param field матрица игрового поля
     */
    private void initializeField(JPanel jPanel, GameField field){
        if (field == null) return;
        jPanel.setLayout(new GridLayout(10, 10));
        jPanel.setMaximumSize(new Dimension(400, 400));

        GameCell[][] cells = field.getCells();
        for (int i = 0; i < GameField.rowCount; i++) {
            for (int j = 0; j < GameField.colCount; j++) {
                cells[j][i].setIcon(nothing);
                jPanel.add(cells[j][i]);

            }
        }
    }


    /**
     * Функция отрисовывает поля игроков после каждого шага
     */
    public void draw(){

        GameField humanField = Game.humanPlayer.getField();
        GameField computerField = Game.computerPlayer.getField();

        updateField(humanField, false);
        updateField(computerField, true);
    }


    /**
     * Функция обновляет отображение поля игрока
     * @param field поле игрока
     * @param computerField true, если в обработку передается поле компьютерного игрока, иначе false
     */
    private void updateField(GameField field, boolean computerField){
        if (field == null) return;
        GameCell[][] cells = field.getCells();
        for (int i = 0; i < GameField.rowCount; i++) {
            for (int j = 0; j < GameField.colCount; j++) {
                GameCell cell = cells[j][i];

                if (computerField){
                    updateComputerCell(cell);
                } else {
                    updateHumanCell(cell);
                }
            }
        }
    }


    /**
     * Функция обновляет отображение конкретной ячейки на поле компьютера
     * @param cell ячейка
     */
    private void updateComputerCell(GameCell cell){
        GameCell.CellType state = cell.getState();

        if (state != null)
            switch (state){
                case NULL:
                    cell.setIcon(nothing);
                    break;
                case INJURED:
                    cell.setIcon(injured);
                    break;
                case KILLED:
                    cell.setIcon(killed);
                    break;
                case MISSED:
                    cell.setIcon(missed);
                    break;
            }

    }

    /**
     * Функция обновляет отображение конкретной ячейки на поле человека
     * @param cell ячейка
     */
    private void updateHumanCell(GameCell cell){
        GameCell.CellType state = cell.getState();

        if (state != null)
            switch (state){
                case NULL:
                    cell.setIcon(nothing);
                    break;
                case MISSED:
                    cell.setIcon(missed);
                    break;
                case ALIVE:
                    cell.setIcon(alive);
                    break;
                case INJURED:
                    cell.setIcon(injured);
                    break;
                case KILLED:
                    cell.setIcon(killed);
                    break;
            }
    }


    /**
     * Функция для получения экземпляра класса MyFrame
     * @return экземпляр класса MyFrame
     */
    public static MyFrame getInstance(){
        if (instance == null)
            instance = new MyFrame();
        return instance;
    }
}
