import javax.swing.*;
import java.awt.*;

public class Tools {
    public static Image getImage(String src) {
        return new ImageIcon("assets/images/" + src ).getImage();
    }
}
