package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLogic implements ActionListener {
    private static final int DELAY = 80;

    private ObjectManager objectManager;
    private GameUI gameUI;
    private Timer timer;

    public GameLogic(ObjectManager objectManager, GameUI gameUI) {
        this.objectManager = objectManager;
        this.gameUI = gameUI;
        this.timer = new Timer(DELAY, this);
    }

    public void startGame() {
        objectManager.resetGame();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (objectManager.isGameRunning()) {
            objectManager.moveSnake();
            objectManager.checkFoodCollision();
            objectManager.checkCollisions();
        }
        gameUI.repaint();
    }

    public void stopGame() {
        timer.stop();
    }
}