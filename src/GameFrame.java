import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    // Constants (default values stored in one place for easy developer access)
    private static final Dimension DEF_DIMENSION = Toolkit.getDefaultToolkit().getScreenSize().getSize();

    // Constructors
    public GameFrame() { // Default
        this(DEF_DIMENSION);
    }
    
    public GameFrame(Dimension screenSize) { // Overloaded
        // Setting up gameFrame
        setBounds(
            0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight()
        );
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
    }

    public void closeFrame() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
