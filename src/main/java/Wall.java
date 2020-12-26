import javax.swing.*;
import java.awt.*;

public class Wall {
    private int x;
    private int y;
    private int bricks;
    private boolean isHorizontal;
    private Image image;

    public Wall(int x, int y, boolean isHorizontal, int bricks) {
        this.x = x;
        this.y = y;
        this.bricks = bricks;
        this.isHorizontal = isHorizontal;
        init();
    }

    private void init() {
        image = new ImageIcon("assets/images/brick.png").getImage();
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void draw(Graphics g) {
        if (isHorizontal) {
            for (int i = 0; i < bricks; i++) {
                g.drawImage(getImage(), x, y + 30 * i, null);
            }
        } else {
            for (int i = 0; i < bricks; i++) {
                g.drawImage(getImage(), x + 30 * i, y, null);
            }
        }
    }


}
