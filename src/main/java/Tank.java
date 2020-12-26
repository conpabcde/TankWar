import object.GameObject;

import javax.swing.*;
import java.awt.*;
public class Tank extends GameObject {
    private int speed;
    private Direction direction;
    private boolean[] dirs = new boolean[4];
    private boolean isEnemy;

    public Tank(int x, int y, Direction direction, Image[] images) {
        this(x, y, direction, false, images);
    }

    public Tank(int x, int y, Direction direction, boolean isEnemy,Image[] images) {
        super(x,y,images);
        this.direction = direction;
        this.isEnemy = isEnemy;
        init();
    }

    private void init() {
        speed = 5;
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
        if (x < 0) {
            x = 0;
        } else if (x > TankGame.gameClient.getFrameWidth() - width) {
            x = TankGame.gameClient.getFrameWidth() - width;
        }

        if (y < 0) {
            y = 0;
        } else if (y > TankGame.gameClient.getFrameHeight() - height) {
            y = TankGame.gameClient.getFrameHeight() - height;
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
        g.drawImage(image[direction.ordinal()], x, y, null);
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
