package src;

import javax.swing.*;
import java.awt.*;

public class GameUI extends JPanel {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final int UNIT_SIZE = 20;

    private ObjectManager objectManager;

    public GameUI(ObjectManager objectManager) {
        this.objectManager = objectManager;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.DARK_GRAY);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (objectManager.isGameRunning()) {
            drawGame(g);
        } else {
            drawGameOver(g);
        }
    }

    private void drawGame(Graphics g) {
        // Draw food
        g.setColor(new Color(210, 115, 90));
        g.fillOval(objectManager.getFoodX(), objectManager.getFoodY(), UNIT_SIZE, UNIT_SIZE);

        // Draw snake
        g.setColor(Color.WHITE);
        g.fillRect(objectManager.getSnakeX(0), objectManager.getSnakeY(0), UNIT_SIZE, UNIT_SIZE);

        for (int i = 1; i < objectManager.getSnakeLength(); i++) {
            g.setColor(new Color(40, 200, 150));
            g.fillRect(objectManager.getSnakeX(i), objectManager.getSnakeY(i), UNIT_SIZE, UNIT_SIZE);
        }

        // Draw score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 25));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score: " + objectManager.getFoodEaten(), (WIDTH - metrics.stringWidth("Score: " + objectManager.getFoodEaten())) / 2, g.getFont().getSize());
    }

    private void drawGameOver(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 50));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (WIDTH - metrics1.stringWidth("Game Over")) / 2, HEIGHT / 2);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 25));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Score: " + objectManager.getFoodEaten(), (WIDTH - metrics2.stringWidth("Score: " + objectManager.getFoodEaten())) / 2, g.getFont().getSize());
    }
}