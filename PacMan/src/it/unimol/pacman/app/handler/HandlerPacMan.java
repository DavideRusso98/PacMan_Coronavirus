package it.unimol.pacman.app.handler;

import it.unimol.pacman.app.Controller;
import it.unimol.pacman.app.entities.*;

import java.awt.*;

public class HandlerPacMan {

    private PacMan pacMan;
    private Controller pacManController;

    private HandlerWalls handlerWalls;
    private HandlerBall handlerBall;
    private HandlerVirus handlerVirus;
    private HandlerMask handlerMask;

    public HandlerPacMan() {
        this.pacMan = new PacMan();
        this.pacManController = new Controller(this);
        this.handlerWalls = new HandlerWalls();
        this.handlerBall = new HandlerBall();
        this.handlerVirus = new HandlerVirus(this);
        this.handlerMask = new HandlerMask(this, this.handlerVirus, this.handlerWalls);
    }

    public PacMan getPacMan() {
        return pacMan;
    }

    public Controller getPacManController() {
        return pacManController;
    }

    public HandlerWalls getHandlerWalls() {
        return handlerWalls;
    }

    public HandlerBall getHandlerBall() {
        return handlerBall;
    }

    public HandlerVirus getHandlerVirus() {
        return handlerVirus;
    }

    public HandlerMask getHandlerMask() {
        return handlerMask;
    }

    public void checkPacmanCollision() {
        for (Ball ball : this.getHandlerBall().getBalls()) {
            if (this.pacMan.getBounds().intersects(ball.getBounds()) && (ball.isStillAlive)) {
                ball.isStillAlive = false;
                this.pacMan.addPoint();
            }
        }

        for (Virus virus : this.getHandlerVirus().getVirus()) {
            if (this.pacMan.getBounds().intersects(virus.getBounds()) && (virus.isStillAlive)) {
                this.pacMan.numberOfLives--;
                this.pacMan.resetPosition();
            }
        }
    }

    public boolean checkPacmanCollisionWall(String direction) {
        Rectangle nextPosition = new Rectangle();

        switch (direction) {
            case "UP":
                nextPosition = new Rectangle(this.pacMan.getX(),
                        this.pacMan.getY() - this.pacMan.getStep(),
                        this.pacMan.getBounds().width,
                        this.pacMan.getBounds().height);
                break;

            case "DOWN":
                nextPosition = new Rectangle(this.pacMan.getX(),
                        this.pacMan.getY() + this.pacMan.getStep(),
                        this.pacMan.getBounds().width,
                        this.pacMan.getBounds().height);
                break;

            case "RIGHT":
                nextPosition = new Rectangle(this.pacMan.getX() + this.pacMan.getStep(),
                        this.pacMan.getY(),
                        this.pacMan.getBounds().width,
                        this.pacMan.getBounds().height);
                break;

            case "LEFT":
                nextPosition = new Rectangle(this.pacMan.getX() - this.pacMan.getStep(),
                        this.pacMan.getY(),
                        this.pacMan.getBounds().width,
                        this.pacMan.getBounds().height);
                break;
        }

        for (Wall wall : this.getHandlerWalls().getWalls()) {
            if (nextPosition.intersects(wall.getBounds())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPacmanCanShoot() {
        if ((this.pacMan.getPartialPoints() > 5) || (this.pacMan.getPartialPoints() == 5)) {
            this.pacMan.canShoot = true;
            this.pacMan.loadShoot();
            return true;
        }
        return false;
    }

}
