package it.unimol.pacman.app.handler;

import it.unimol.pacman.app.entities.Virus;

import java.util.ArrayList;
import java.util.List;

public class HandlerVirus {

    private HandlerPacMan handlerPacMan;
    private List<Virus> virus = new ArrayList<>();

    public HandlerVirus(HandlerPacMan handlerPacMan) {
        this.handlerPacMan = handlerPacMan;
        this.loadVirus();
    }

    public List<Virus> getVirus() {
        return virus;
    }

    private HandlerPacMan getHandlerPacMan() {
        return handlerPacMan;
    }

    private void loadVirus() {
        Virus newVirus1 = new Virus(905, 20, "resources/red_virus.png");
        this.virus.add(newVirus1);

        Virus newVirus2 = new Virus(905, 400, "resources/brown_virus.png");
        this.virus.add(newVirus2);

        Virus newVirus3 = new Virus(20, 400, "resources/purple_virus.png");
        this.virus.add(newVirus3);

        Virus newVirus4 = new Virus(500, 400, "resources/green_virus.png");
        this.virus.add(newVirus4);
    }

    public void moveVirus() {
        for (Virus virus : this.getVirus()) {
            virus.startMoving(this.getHandlerPacMan().getPacMan().getX(), this.getHandlerPacMan().getPacMan().getY());
        }
    }

}
