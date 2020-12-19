import object.Direction;
import object.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameClient extends JComponent {
    private int frameWidth;
    private int frameHeight;
    private boolean stop;
    Tank tankPlayer;

    GameClient() {
        this(800, 600);
    }

    GameClient(int frameWidth, int frameHeight) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.setPreferredSize(new Dimension(frameWidth, frameHeight));
        init();
        new Thread(() -> {
            while(!stop) {
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    void init() {
        tankPlayer = new Tank(100, 100, Direction.RIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(tankPlayer.getImage(), tankPlayer.getX(), tankPlayer.getY(), null);
    }

    public void keyPress(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                tankPlayer.setDirection(Direction.UP);
                break;

            case KeyEvent.VK_DOWN:
                tankPlayer.setDirection(Direction.DOWN);
                break;

            case KeyEvent.VK_RIGHT:
                tankPlayer.setDirection(Direction.RIGHT);
                break;

            case KeyEvent.VK_LEFT:
                tankPlayer.setDirection(Direction.LEFT);
                break;
        }

        tankPlayer.move();
    }

    public void keyRelease(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                tankPlayer.setDirection(Direction.UP);
                break;

            case KeyEvent.VK_DOWN:
                tankPlayer.setDirection(Direction.DOWN);
                break;

            case KeyEvent.VK_RIGHT:
                tankPlayer.setDirection(Direction.RIGHT);
                break;

            case KeyEvent.VK_LEFT:
                tankPlayer.setDirection(Direction.LEFT);
                break;

        }
        tankPlayer.move();
    }

}
