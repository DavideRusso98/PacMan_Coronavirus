package it.unimol.pacman.app.entities;

import java.awt.*;

public class PacMan extends Entity {

    private String imagePathU = "resources/pacman_up.png";
    private String imagePathD = "resources/pacman_down.png";
    private String imagePathR = "resources/pacman_right.png";
    private String imagePathL = "resources/pacman_left.png";

    public int numberOfLives = 3;
    private int totalPoints = 0;
    private int partialPoints = 0;
    public boolean canShoot = false;
    public boolean hasShooted = false;
    private final int step = 12;

    private Mask mask;

    public PacMan() {
        this.setImgPath(imagePathR);
        this.loadImage();
        this.x = 20;
        this.y = 20;
    }

    @Override
    public Image getImage() {
        return super.getImage();
    }

    @Override
    public void loadImage() {
        super.loadImage();
    }

    @Override
    public String getImgPath() {
        return super.getImgPath();
    }

    @Override
    public void setImgPath(String imgPath) {
        super.setImgPath(imgPath);
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public int getStep() {
        return step;
    }

    public Rectangle getBounds() {
        return new Rectangle(this.getX(), this.getY(), 60, 60);
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    private void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getPartialPoints() {
        return partialPoints;
    }

    public void setPartialPoints(int partialPoints) {
        this.partialPoints = partialPoints;
    }

    public void addPoint() {
        this.setTotalPoints(this.getTotalPoints() + 1);
        this.setPartialPoints(this.getPartialPoints() + 1);
    }

    public void resetPosition() {
        this.setX(20);
        this.setY(20);
    }

    public void moveUp() {
        if (isStillAlive) {
            this.setImgPath(this.imagePathU);
            this.loadImage();
            this.setY(this.getY() - this.step);
        }
    }

    public void moveDown() {
        if (isStillAlive) {
            this.setImgPath(this.imagePathD);
            this.loadImage();
            this.setY(this.getY() + this.step);
        }
    }

    public void moveLeft() {
        if (isStillAlive) {
            this.setImgPath(this.imagePathL);
            this.loadImage();
            this.setX(this.getX() - this.step);
        }
    }

    public void moveRight() {
        if (isStillAlive) {
            this.setImgPath(this.imagePathR);
            this.loadImage();
            this.setX(this.getX() + this.step);
        }
    }

    public void loadShoot() {
        if (this.canShoot) {
            this.mask = new Mask(this.getX(), this.getY());
        }
    }

    public Mask getMask() {
        return mask;
    }

}
