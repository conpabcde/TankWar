import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TankGame {

    static GameClient gameClient = new GameClient();
    public static void main(String[] args) {
        gameClient = new GameClient();
        JFrame frame = new JFrame();
        frame.add(gameClient);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                gameClient.keyPress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gameClient.keyRelease(e);
            }
        });



    }
}
