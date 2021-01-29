package it.unimol.pacman.app;

import it.unimol.pacman.app.handler.HandlerMask;
import it.unimol.pacman.app.handler.HandlerPacMan;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {

    private HandlerPacMan handlerPacMan;
    //private HandlerMask handlerMask;

    public Controller(HandlerPacMan handlerPacMan) {
        this.handlerPacMan = handlerPacMan;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        super.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (this.getHandlerPacMan().checkPacmanCollisionWall("UP"))
                this.getHandlerPacMan().getPacMan().moveUp();
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (this.getHandlerPacMan().checkPacmanCollisionWall("DOWN"))
                this.getHandlerPacMan().getPacMan().moveDown();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (this.getHandlerPacMan().checkPacmanCollisionWall("RIGHT"))
                this.getHandlerPacMan().getPacMan().moveRight();
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (this.getHandlerPacMan().checkPacmanCollisionWall("LEFT"))
                this.getHandlerPacMan().getPacMan().moveLeft();
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (this.getHandlerPacMan().checkPacmanCanShoot()) {
                this.getHandlerPacMan().getHandlerMask().setShotDirection();
                this.getHandlerPacMan().getPacMan().getMask().move();
                this.getHandlerPacMan().getPacMan().hasShooted = true;
                this.getHandlerPacMan().getPacMan().setPartialPoints(0);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
    }

    private HandlerPacMan getHandlerPacMan() {
        return handlerPacMan;
    }

}
