package it.unimol.pacman.gui;

import it.unimol.pacman.app.handler.HandlerGame;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private final GameBoard gameBoard;
    private InfoPanel infoPanel;

    public GameFrame(HandlerGame handlerGame) {
        super();

        this.setAlwaysOnTop(false);
        this.setBounds(300, 100, 1000, 660);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.gameBoard = new GameBoard(this, handlerGame);
        this.add(gameBoard);

        this.infoPanel = new InfoPanel(handlerGame);
        this.infoPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 61, 0));
        this.add(infoPanel, BorderLayout.PAGE_END);
    }

}
