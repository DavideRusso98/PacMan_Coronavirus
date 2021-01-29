package it.unimol.pacman.app.handler;

public class HandlerGame {

    private HandlerPacMan handlerPacman;

    public HandlerGame() {
        this.handlerPacman = new HandlerPacMan();
    }

    public HandlerPacMan getHandlerPacman() {
        return handlerPacman;
    }

    public boolean checkWinner() {
        if (this.getHandlerPacman().getPacMan().getTotalPoints() >= 20) {
            return true;
        } else return false;
    }

    public boolean checkLoser() {
        if (this.getHandlerPacman().getPacMan().getNumberOfLives() <= 0) {
            return true;
        } else return false;
    }

}
