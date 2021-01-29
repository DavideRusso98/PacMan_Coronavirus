package it.unimol.pacman.gui;

import it.unimol.pacman.app.handler.HandlerGame;
import it.unimol.pacman.app.entities.Ball;
import it.unimol.pacman.app.entities.Virus;
import it.unimol.pacman.app.entities.Wall;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

    private final HandlerGame handlerGame;
    private final GameFrame gameFrame;

    public GameBoard(GameFrame gameFrame, HandlerGame handlerGame) {
        this.setFocusable(true);
        this.gameFrame = gameFrame;
        this.handlerGame = handlerGame;
        this.addKeyListener(this.getHandlerGame().getHandlerPacman().getPacManController());
        this.update();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        this.setBackground(Color.black);
        this.drawWalls((Graphics2D) g);
        this.drawBalls(g);
        this.drawPacman(g);
        this.drawVirus(g);
        this.drawMask(g);
    }

    public HandlerGame getHandlerGame() {
        return handlerGame;
    }

    private void drawWalls(Graphics2D g) {
        g.setColor(Color.blue);

        for (Wall wall : this.getHandlerGame().getHandlerPacman().getHandlerWalls().getWalls()) {
            g.draw(wall);
            g.fill(wall);
        }
    }

    private void drawBalls(Graphics g) {
        this.getHandlerGame().getHandlerPacman().checkPacmanCollision();
        for (Ball ball : this.getHandlerGame().getHandlerPacman().getHandlerBall().getBalls()) {
            if (ball.isStillAlive) {
                g.drawImage(ball.getImage(), ball.getX(), ball.getY(), this);
            }
        }
    }

    private void drawPacman(Graphics g) {
        g.drawImage(this.getHandlerGame().getHandlerPacman().getPacMan().getImage(),
                this.getHandlerGame().getHandlerPacman().getPacMan().getX(),
                this.getHandlerGame().getHandlerPacman().getPacMan().getY(),
                this);
    }

    private void drawVirus(Graphics g) {
        for (Virus virus : this.getHandlerGame().getHandlerPacman().getHandlerVirus().getVirus()) {
            if (virus.isStillAlive) {
                g.drawImage(virus.getImage(), virus.getX(), virus.getY(), this);
            }
        }
    }

    private void drawMask(Graphics g) {
        if (this.getHandlerGame().getHandlerPacman().getPacMan().hasShooted) {

            this.getHandlerGame().getHandlerPacman().getHandlerMask().checkMaskCollision();

            if (this.getHandlerGame().getHandlerPacman().getPacMan().getMask().isStillAlive) {
                g.drawImage(this.getHandlerGame().getHandlerPacman().getPacMan().getMask().getImage(),
                        this.getHandlerGame().getHandlerPacman().getPacMan().getMask().getX(),
                        this.getHandlerGame().getHandlerPacman().getPacMan().getMask().getY(), this);
            }
        }
    }

    public void update() {
        new Thread(() -> {

            boolean playGame = true;
            while (playGame) {

                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (this.getHandlerGame().checkWinner()) {
                    playGame = false;

                    final ImageIcon icon = new ImageIcon("resources/green_virus_killed.png");
                    int click = JOptionPane.showConfirmDialog(this,
                            "You tested negative for the coronavirus!" + "\n" + "Do you want to play again?",
                            "VICTORY!",
                            JOptionPane.YES_OPTION, JOptionPane.NO_OPTION, icon);
                    if (click == 0) {
                        this.gameFrame.dispose();
                        HomeFrame newHomeFrame = new HomeFrame();
                        newHomeFrame.setVisible(true);
                    } else {
                        System.exit(0);
                    }

                } else if (this.handlerGame.checkLoser()) {
                    playGame = false;

                    final ImageIcon icon = new ImageIcon("resources/green_virus.png");
                    int click = JOptionPane.showConfirmDialog(this,
                            "You tested positive for the coronavirus!" + "\n" + "Do you want to play again?",
                            "DEFEAT!",
                            JOptionPane.YES_OPTION, JOptionPane.NO_OPTION, icon);
                    if (click == 0) {
                        this.gameFrame.dispose();
                        HomeFrame newHomeFrame = new HomeFrame();
                        newHomeFrame.setVisible(true);
                    } else {
                        System.exit(0);
                    }

                }

                if (this.getHandlerGame().getHandlerPacman().getPacMan().hasShooted) {
                    this.getHandlerGame().getHandlerPacman().getPacMan().getMask().move();
                }

                this.getHandlerGame().getHandlerPacman().getHandlerVirus().moveVirus();

                this.repaint();
            }
        }
        ).start();

    }

}


