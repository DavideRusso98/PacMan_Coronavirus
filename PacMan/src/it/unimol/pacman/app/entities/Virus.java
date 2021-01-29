package it.unimol.pacman.app.entities;

import java.awt.*;

public class Virus extends Entity {

    private final int step = 1;

    public Virus(int x, int y, String imagePath) {
        this.imagePath = imagePath;
        this.loadImage();
        this.x = x;
        this.y = y;
    }

    @Override
    public Image getImage() {
        return super.getImage();
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

    @Override
    public void loadImage() {
        super.loadImage();
    }

    public Rectangle getBounds() {
        return new Rectangle(this.getX(), this.getY(), 70, 70);
    }

    public void startMoving(int x, int y) {
        if (isStillAlive) {
            if (y < this.getY()) {
                this.setY(this.getY() - step);
            }
            if (y > this.getY()) {
                this.setY(this.getY() + step);
            }
            if (x < this.getX()) {
                this.setX(this.x - step);
            }
            if (x > this.getX()) {
                this.setX(this.getX() + step);
            }
        }
    }

}
