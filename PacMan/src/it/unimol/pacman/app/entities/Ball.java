package it.unimol.pacman.app.entities;

import java.awt.*;

public class Ball extends Entity {

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.imagePath = "resources/ball.png";
        this.loadImage();
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

    public Rectangle getBounds() {
        return new Rectangle(this.getX(), this.getY(), 20, 20);
    }

}
