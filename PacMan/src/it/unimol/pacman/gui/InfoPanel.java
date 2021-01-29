package it.unimol.pacman.gui;

import it.unimol.pacman.app.handler.HandlerGame;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private final HandlerGame handlerGame;
    //private final GameFrame gameFrame;

    public InfoPanel(HandlerGame handlerGame) {
        this.setFocusable(true);
        //this.gameFrame = gameFrame;
        this.handlerGame = handlerGame;
        this.update();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);

        this.setBackground(Color.black);
        this.drawPoints(g);
        this.drawCentralString(g);
        this.drawLives(g);
    }

    private void drawPoints(Graphics g) {
        Integer totalPoints = this.getHandlerGame().getHandlerPacman().getPacMan().getTotalPoints();

        g.setFont(new Font("Showcard Gothic", Font.PLAIN, 45));
        g.setColor(Color.yellow);
        g.drawString("POINTS:" + (totalPoints), 5, 50);
    }

    private void drawLives(Graphics g) {
        Image heartImage = null;
        try {
            ImageIcon imageIcon = new ImageIcon("resources/heart.png");
            heartImage = imageIcon.getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int x = 770;
        for (int i = 0; i < this.getHandlerGame().getHandlerPacman().getPacMan().getNumberOfLives(); i++) {
            g.drawImage(heartImage, x, -5, this);
            x = x + 70;
        }
    }

    private void drawCentralString(Graphics g) {
        if ((this.getHandlerGame().getHandlerPacman().getPacMan().getPartialPoints() > 5) || (this.getHandlerGame().getHandlerPacman().getPacMan().getPartialPoints() == 5)) {
            g.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 35));
            g.setColor(Color.red);
            g.drawString("PRESS SPACE TO SHOOT!", 330, 50);
        }
    }

    public void update() {
        new Thread(() -> {
            while (true) {

                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                this.repaint();
            }
        }
        ).start();

    }

    public HandlerGame getHandlerGame() {
        return handlerGame;
    }

}
