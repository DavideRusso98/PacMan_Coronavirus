package it.unimol.pacman.app.handler;

import it.unimol.pacman.app.entities.Wall;

import java.util.ArrayList;
import java.util.List;

public class HandlerWalls {

    private List<Wall> walls = new ArrayList<>();

    public HandlerWalls() {
        this.loadWalls();
    }

    public List<Wall> getWalls() {
        return walls;
    }

    private void loadWalls() {
        Wall wallUp = new Wall(0, 0, 1000, 20);
        this.walls.add(wallUp);

        Wall wallDown = new Wall(0, 530, 1000, 20);
        this.walls.add(wallDown);

        Wall wallLeft = new Wall(0, 0, 20, 550);
        this.walls.add(wallLeft);

        Wall wallRight = new Wall(966, 0, 20, 550);
        this.walls.add(wallRight);
    }

}
