package src;

import javax.swing.*;
import java.awt.*;

public class MenuSystem {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private GameUI gameUI;
    private GameLogic gameLogic;
    private ObjectManager objectManager;
    private InputHandler inputHandler;

    public MenuSystem() {
        frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        objectManager = new ObjectManager();
        gameUI = new GameUI(objectManager);
        gameLogic = new GameLogic(objectManager, gameUI);
        inputHandler = new InputHandler(objectManager);

        gameUI.addKeyListener(inputHandler);

        initializeMenu();
        initializeGame();

        frame.add(cardPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    private void initializeMenu() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JButton startButton = new JButton("Start Game");
        JButton quitButton = new JButton("Quit");

        startButton.addActionListener(e -> startGame());
        quitButton.addActionListener(e -> System.exit(0));

        menuPanel.add(Box.createVerticalGlue());
        menuPanel.add(startButton);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        menuPanel.add(quitButton);
        menuPanel.add(Box.createVerticalGlue());

        cardPanel.add(menuPanel, "Menu");
    }

    private void initializeGame() {
        cardPanel.add(gameUI, "Game");
    }

    public void showMainMenu() {
        frame.setVisible(true);
        cardLayout.show(cardPanel, "Menu");
    }

    private void startGame() {
        cardLayout.show(cardPanel, "Game");
        gameUI.requestFocusInWindow();
        gameLogic.startGame();
    }
}