import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    // Default values
    private static final Dimension defaultDimension = Toolkit.getDefaultToolkit().getScreenSize().getSize();

    public GameFrame() {
        this(defaultDimension);
    }
    
    public GameFrame(Dimension screenSize) {
        // Setting up gameFrame
        setBounds(
            0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight()
        );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
    }

    public void closeFrame() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
