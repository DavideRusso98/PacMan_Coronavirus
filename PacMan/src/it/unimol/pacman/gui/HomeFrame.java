package it.unimol.pacman.gui;


import it.unimol.pacman.app.handler.HandlerGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HomeFrame extends JFrame {

    public HandlerGame handlerGame = new HandlerGame();

    private JLabel background;
    private final String imagePath = "resources/home_background.jpg";

    private JPanel buttonsPanel;
    private JButton quitButton;
    private JButton playButton;

    public HomeFrame() {
        super();

        this.setAlwaysOnTop(false);
        this.setBounds(500, 150, 555, 555);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.loadBackground();

        this.buttonsPanel = new JPanel();
        this.buttonsPanel.setOpaque(false);
        this.buttonsPanel.setBorder(BorderFactory.createEmptyBorder(230, 0, 0, 0));
        this.background.add(buttonsPanel);

        this.quitButton = new JButton("QUIT");
        this.quitButton.setBackground(Color.YELLOW);
        this.quitButton.addActionListener(
                actionEvent -> {
                    int click = JOptionPane.showConfirmDialog(
                            this,
                            "Are you sure you want to quit the game?",
                            "QUIT GAME",
                            JOptionPane.YES_NO_OPTION);
                    if (click == 0) {
                        System.exit(0);
                    }
                }
        );
        this.buttonsPanel.add(quitButton);

        this.playButton = new JButton("PLAY");
        this.playButton.setBackground(Color.YELLOW);
        this.playButton.addActionListener(
                actionEvent -> {
                    this.setVisible(false);
                    GameFrame newGameFrame = new GameFrame(this.handlerGame);
                    newGameFrame.setVisible(true);
                }
        );
        this.buttonsPanel.add(playButton);

    }

    public void loadBackground() {
        try {
            background = new JLabel(new ImageIcon(ImageIO.read(new File(imagePath))));
            this.add(background);
            this.background.setLayout(new FlowLayout());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
