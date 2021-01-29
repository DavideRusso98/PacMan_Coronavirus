package it.unimol.pacman.app.entities;

import javax.swing.*;
import java.awt.*;

public abstract class Entity {

    protected Image image;
    protected String imagePath;
    protected int x;
    protected int y;
    public boolean isStillAlive = true;

    public Entity() {
    }

    public void loadImage() {
        try {
            ImageIcon imageIcon = new ImageIcon(getImgPath());
            this.image = imageIcon.getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Image getImage() {
        return image;
    }

    public String getImgPath() {
        return imagePath;
    }

    protected void setImgPath(String imgPath) {
        this.imagePath = imgPath;
    }

    public int getX() {
        return x;
    }

    protected void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }

}
