import object.GameObject;

import javax.swing.*;
import java.awt.*;

public class Wall extends GameObject {
    private int bricks;
    private boolean isHorizontal;

    public Wall(int x, int y, boolean isHorizontal, int bricks,Image[] image) {
        super(x,y,image);
        this.bricks = bricks;
        this.isHorizontal = isHorizontal;
        init();
    }

    private void init() {
    }

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

    public int getBricks() {
        return bricks;
    }

    public void setBricks(int bricks) {
        this.bricks = bricks;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public void setHorizontal(boolean horizontal) {
        isHorizontal = horizontal;
    }

    public void draw(Graphics g) {
        if (isHorizontal) {
            for (int i = 0; i < bricks; i++) {
                g.drawImage(image[0], x, y + 30 * i, null);
            }
        } else {
            for (int i = 0; i < bricks; i++) {
                g.drawImage(image[0], x + 30 * i, y, null);
            }
        }
    }


}
