package it.unimol.pacman.app.handler;

import it.unimol.pacman.app.entities.Ball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandlerBall {

    private List<Ball> balls = new ArrayList<>();
    private List<Integer> positionX = new ArrayList<>();
    private List<Integer> positionY = new ArrayList<>();

    public HandlerBall() {
        this.loadBallsPosition();
        this.loadBalls();
    }

    public List<Ball> getBalls() {
        return balls;
    }

    private void loadBallsPosition() {
        int x = 80;
        for (int i = 0; i < 11; i++) {
            this.positionX.add(x);
            x = x + 80;
        }

        int y = 80;
        for (int i = 0; i < 6; i++) {
            this.positionY.add(y);
            y = y + 80;
        }
    }

    private void loadBalls() {
        for (int i = 0; i < 20; i++) {
            int newX;
            int newY;

            do {
                newX = extractXPos();
                newY = extractYPos();
            } while (!checkInvalidBallPosition(newX, newY));

            Ball ball = new Ball(newX, newY);
            this.balls.add(ball);
        }
    }

    private int extractXPos() {
        Collections.shuffle(this.positionX);
        return this.positionX.get(0);
    }

    private int extractYPos() {
        Collections.shuffle(this.positionY);
        return this.positionY.get(0);
    }

    private boolean checkInvalidBallPosition(int x, int y) {
        for (Ball ball : this.balls) {
            if ((x == ball.getX()) && (y == ball.getY())) {
                return false;
            }
        }
        return true;
    }

}
