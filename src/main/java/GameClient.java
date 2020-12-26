import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameClient extends JComponent {
    private int frameWidth;
    private int frameHeight;
    private boolean stop;
    private Image backGroundMap;
    Tank tankPlayer;
    ArrayList<Tank> tanksEnemy = new ArrayList<>();
    ArrayList<Wall> walls = new ArrayList<>();

    GameClient() {
        this(800, 800);
    }

    GameClient(int frameWidth, int frameHeight) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.setPreferredSize(new Dimension(frameWidth, frameHeight));
        init();
        new Thread(() -> {
            while (!stop) {
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
        tankPlayer = new Tank(400, 100, Direction.DOWN);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                tanksEnemy.add(new Tank(250 + 90 * j, 400 + 80 * i, Direction.UP, true));
            }
        }
        walls.add(new Wall(100, 200,true,15));
        walls.add(new Wall(650, 200,true,15));
        walls.add(new Wall(200, 200,false,13));
        backGroundMap = new ImageIcon("assets/images/map_sand.jpg").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        //g.drawImage(0,0,backGroundMap);
        g.fillRect(0, 0, frameWidth, frameHeight);
        tankPlayer.draw(g);
        for (Tank t : tanksEnemy) {
            t.draw(g);
        }
        for (Wall w : walls) {
            w.draw(g);
        }
    }

    public void keyPress(KeyEvent e) {
        boolean[] dirs = tankPlayer.getDirs();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dirs[0] = true;
                break;

            case KeyEvent.VK_DOWN:
                dirs[1] = true;
                break;

            case KeyEvent.VK_LEFT:
                dirs[2] = true;
                break;

            case KeyEvent.VK_RIGHT:
                dirs[3] = true;
                break;
        }
    }

    public void keyRelease(KeyEvent e) {
        boolean[] dirs = tankPlayer.getDirs();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dirs[0] = false;
                break;

            case KeyEvent.VK_DOWN:
                dirs[1] = false;
                break;

            case KeyEvent.VK_LEFT:
                dirs[2] = false;
                break;

            case KeyEvent.VK_RIGHT:
                dirs[3] = false;
                break;
        }
    }
}
