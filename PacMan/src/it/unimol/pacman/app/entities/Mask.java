package it.unimol.pacman.app.entities;

import java.awt.*;

public class Mask extends Entity {

    private final int step = 3;
    public String direction;
    public boolean canKill = true;

    public Mask(int x, int y) {
        this.x = x;
        this.y = y;
        this.imagePath = "resources/mask.png";
        this.loadImage();
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

    private String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Rectangle getBounds() {
        return new Rectangle(this.getX(), this.getY(), 40, 33);
    }

    public void move() {
        if (this.getDirection().equalsIgnoreCase("U")) {
            this.setY(this.getY() - step);
        }
        if (this.getDirection().equalsIgnoreCase("D")) {
            this.setY(this.getY() + step);
        }
        if (this.getDirection().equalsIgnoreCase("L")) {
            this.setX(this.getX() - step);
        }
        if (this.getDirection().equalsIgnoreCase("R")) {
            this.setX(this.getX() + step);
        }
    }

}
