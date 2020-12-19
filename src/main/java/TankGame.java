import javax.swing.*;

public class TankGame {
    public static void main(String[] args) {
        GameClient gameClient = new GameClient(1920,1080);
        JFrame frame = new JFrame();
        frame.add(gameClient);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
}
