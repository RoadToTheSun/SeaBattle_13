package SeaBattle.model;

import SeaBattle.GUI.MyFrame;
import SeaBattle.model.Players.ComputerPlayer;
import SeaBattle.model.Players.HumanPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener, Runnable {
    private Thread lastGame;
    private boolean reset = false;
    public static ComputerPlayer computerPlayer = new ComputerPlayer();
    public static HumanPlayer humanPlayer = new HumanPlayer();
    private static Game game = getInstance();

    private Game(){
        humanPlayer.setOpponent(computerPlayer);
        computerPlayer.setOpponent(humanPlayer);
    }

    public static void main(String[] args) {
        game.playGame();
    }

    public void playGame(){
        lastGame = new Thread(this);
        lastGame.start();
    }
    public static Game getInstance(){
        if (game == null) game = new Game();
        return game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        reset = true;
        if (!lastGame.isAlive()){
            lastGame = new Thread(this);
            lastGame.start();
        }
    }

    @Override
    public void run() {
        MyFrame.getInstance().draw();
        //MessageManager.getInstance().getStartMessage();
        boolean shootComanded = false;
        while(true){
            if (reset){
                reset = false;
                computerPlayer.reset();
                humanPlayer.reset();
                MyFrame.getInstance().draw();
                //MessageManager.getInstance().getStartMessage();
            }
            if (computerPlayer.moves() && !shootComanded) {
                computerPlayer.shoot();
                shootComanded = true;
            } else {
                shootComanded = false;
            }
            if (computerPlayer.getShipsToKill() == 0 || humanPlayer.getShipsToKill() == 0) {
                //MessageManager.getInstance().getWinMessage(humanPlayer.getShipsToKill() == 0);
                break;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
