import javax.swing.*;
import java.awt.*;

public class GameClient extends JComponent {
    private int frameWidth;
    private int frameHeight;

    GameClient() {
        this(800,600);
    }

    GameClient(int frameWidth, int frameHeight) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.setPreferredSize(new Dimension(frameWidth,frameHeight));
    }
}
