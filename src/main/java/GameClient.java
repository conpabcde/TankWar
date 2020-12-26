import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameClient extends JComponent {
    private int frameWidth;
    private int frameHeight;
    private boolean stop;
    private Image backGroundMap;
    Tank playerTank;
    ArrayList<Tank> enemyTanks = new ArrayList<>();
    ArrayList<Wall> walls = new ArrayList<>();

    GameClient() {
        this(800, 600);
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

        Image[] itankImg = new Image[8];
        Image[] etankImg = new Image[8];
        String[] sub = {"U", "D", "L", "R", "LU", "RU", "LD", "RD"};
        for (int i = 0; i < itankImg.length; i++) {
            itankImg[i] = Tools.getImage("itank" + sub[i] + ".png");
            etankImg[i] = Tools.getImage("etank" + sub[i] + ".png");
        }

        playerTank = new Tank(400, 100, Direction.DOWN,itankImg);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                enemyTanks.add(new Tank(250 + 90 * j, 400 + 80 * i, Direction.UP, true,etankImg));
            }
        }
        Image[] image = {Tools.getImage("brick.png")};
        walls.add(new Wall(100, 200, true, 15, image));
        walls.add(new Wall(650, 200, true, 15, image));
        walls.add(new Wall(200, 200, false, 13, image));
        backGroundMap = Tools.getImage("map_sand.jpg");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.setColor(Color.BLACK);
//        g.drawImage(backGroundMap,1024,864,null);
//        g.fillRect(0, 0, frameWidth, frameHeight);
        g.drawImage(backGroundMap,0,0,null);
        playerTank.draw(g);
        for (Tank t : enemyTanks) {
            t.draw(g);
        }
        for (Wall w : walls) {
            w.draw(g);
        }
    }

    public void keyPress(KeyEvent e) {
        boolean[] dirs = playerTank.getDirs();
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
        boolean[] dirs = playerTank.getDirs();
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

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }
}
