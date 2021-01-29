package it.unimol.pacman.app.handler;

import it.unimol.pacman.app.entities.Virus;
import it.unimol.pacman.app.entities.Wall;

public class HandlerMask {

    private HandlerPacMan handlerPacMan;
    private HandlerVirus handlerVirus;
    private HandlerWalls handlerWalls;

    public HandlerMask(HandlerPacMan handlerPacMan, HandlerVirus handlerVirus, HandlerWalls handlerWalls) {
        this.handlerPacMan = handlerPacMan;
        this.handlerVirus = handlerVirus;
        this.handlerWalls = handlerWalls;
    }

    private HandlerPacMan getHandlerPacMan() {
        return handlerPacMan;
    }

    private HandlerVirus getHandlerVirus() {
        return handlerVirus;
    }

    private HandlerWalls getHandlerWalls() {
        return handlerWalls;
    }

    public void setShotDirection() {
        if (this.getHandlerPacMan().getPacMan().getImgPath().equalsIgnoreCase("resources/pacman_up.png")) {
            this.getHandlerPacMan().getPacMan().getMask().setDirection("U");
        } else if (this.getHandlerPacMan().getPacMan().getImgPath().equalsIgnoreCase("resources/pacman_down.png")) {
            this.getHandlerPacMan().getPacMan().getMask().setDirection("D");
        } else if (this.getHandlerPacMan().getPacMan().getImgPath().equalsIgnoreCase("resources/pacman_left.png")) {
            this.getHandlerPacMan().getPacMan().getMask().setDirection("L");
        } else
            this.getHandlerPacMan().getPacMan().getMask().setDirection("R");
    }

    public void checkMaskCollision() {
        for (Wall wall : this.getHandlerWalls().getWalls()) {
            if (this.getHandlerPacMan().getPacMan().getMask().getBounds().intersects(wall.getBounds())) {
                this.getHandlerPacMan().getPacMan().getMask().isStillAlive = false;
            }
        }

        for (Virus virus : this.getHandlerVirus().getVirus()) {
            if ((this.getHandlerPacMan().getPacMan().getMask().getBounds().intersects(virus.getBounds()) && (virus.isStillAlive)) && (this.getHandlerPacMan().getPacMan().getMask().canKill)) {
                this.getHandlerPacMan().getPacMan().getMask().isStillAlive = false;
                virus.isStillAlive = false;
                this.getHandlerPacMan().getPacMan().getMask().canKill = false;
            }
        }
    }

}
