import javax.swing.*;
import java.awt.*;

public class Tank {
    private int x;
    private int y;
    private int speed;
    private Direction direction;
    private boolean[] dirs = new boolean[4];
    private boolean isEnemy;

    public Tank(int x, int y, Direction direction) {
        this(x, y, direction, false);
    }

    public Tank(int x, int y, Direction direction, boolean isEnemy) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.isEnemy = isEnemy;
        init();
    }

    private void init() {
        speed = 5;
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

    public Direction getDirection() {
        return direction;
    }

    public boolean[] getDirs() {
        return dirs;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Image getImage() {
        String name = isEnemy ? "etank" : "itank";
        if (direction == Direction.UP) {
            return new ImageIcon("assets/images/" + name + "U.png").getImage();
        }
        if (direction == Direction.DOWN) {
            return new ImageIcon("assets/images/" + name + "D.png").getImage();
        }
        if (direction == Direction.RIGHT) {
            return new ImageIcon("assets/images/" + name + "R.png").getImage();
        }
        if (direction == Direction.LEFT) {
            return new ImageIcon("assets/images/" + name + "L.png").getImage();
        }
        if (direction == Direction.UP_LEFT) {
            return new ImageIcon("assets/images/" + name + "LU.png").getImage();
        }
        if (direction == Direction.UP_RIGHT) {
            return new ImageIcon("assets/images/" + name + "RU.png").getImage();
        }
        if (direction == Direction.DOWN_LEFT) {
            return new ImageIcon("assets/images/" + name + "LD.png").getImage();
        }
        if (direction == Direction.DOWN_RIGHT) {
            return new ImageIcon("assets/images/" + name + "RD.png").getImage();
        }
        return null;
    }

    public void move() {
        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case UP_LEFT:
                y -= speed;
                x -= speed;
                break;
            case UP_RIGHT:
                y -= speed;
                x += speed;
                break;
            case DOWN_LEFT:
                y += speed;
                x -= speed;
                break;
            case DOWN_RIGHT:
                y += speed;
                x += speed;
                break;
        }
    }

    public void detectDirection() {
        if (dirs[0] && !dirs[1] && !dirs[2] && !dirs[3]) {
            direction = Direction.UP;
        } else if (!dirs[0] && dirs[1] && !dirs[2] && !dirs[3]) {
            direction = Direction.DOWN;
        } else if (!dirs[0] && !dirs[1] && dirs[2] && !dirs[3]) {
            direction = Direction.LEFT;
        } else if (!dirs[0] && !dirs[1] && !dirs[2] && dirs[3]) {
            direction = Direction.RIGHT;
        } else if (dirs[0] && !dirs[1] && dirs[2] && !dirs[3]) {
            direction = Direction.UP_LEFT;
        } else if (dirs[0] && !dirs[1] && !dirs[2] && dirs[3]) {
            direction = Direction.UP_RIGHT;
        } else if (!dirs[0] && dirs[1] && dirs[2] && !dirs[3]) {
            direction = Direction.DOWN_LEFT;
        } else if (!dirs[0] && dirs[1] && !dirs[2] && dirs[3]) {
            direction = Direction.DOWN_RIGHT;
        }
    }

    public void draw(Graphics g) {
        if (isRunning()) {
            detectDirection();
            move();
        }
        g.drawImage(getImage(), x, y, null);
    }

    public boolean isRunning() {
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i]) {
                return true;
            }
        }
        return false;
    }
}