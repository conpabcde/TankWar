package object;

import java.awt.*;

public abstract class GameObject {
    protected int x;
    protected int y;
    protected Image[] image;
    protected int width;
    protected int height;

    public GameObject(int x, int y, Image[] image) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = image[0].getWidth(null);
        this.height= image[0].getHeight(null);
    }

    public abstract  void draw(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image[] getImage() {
        return image;
    }

    public void setImage(Image[] image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

