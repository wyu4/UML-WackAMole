import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GameFrame extends JFrame {
    // Constants (default values stored in one place for easy developer access)
    private static final Rectangle DEF_BOUNDS = new Rectangle(0, 0, 500, 550);
    private static final String DEF_NAME = "Wack-A-Mole";

    private final JPanel topPanel;
    private final JPanel gamePanel;

    // Constructors
    /**
     * Creates a new GameFrame object
     */
    public GameFrame() { // Default
        this(DEF_NAME, DEF_BOUNDS);
    }

    /**
     * Creates a new GameFrame object
     * @param name The name of the frame
     */
    public GameFrame(String name) { // Default
        this(name, DEF_BOUNDS);
    }

    /**
     * Creates a new GameFrame object
     * @param bounds The bounds of the frame
     */
    public GameFrame(Rectangle bounds) { // Default
        this(DEF_NAME, bounds);
    }
    /**
     * Creates a new GameFrame object
     * @param name The name of the frame
     * @param bounds The bounds of the frame
     */
    public GameFrame(String name, Rectangle bounds) { // Overloaded
        // Setting up gameFrame
        setName(name);
        setBounds(bounds);
        setAlwaysOnTop(true);
        getContentPane().setBackground(new Color(26, 13, 0));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);

        topPanel = new JPanel();
        gamePanel = new JPanel();
        topPanel.setLayout(null);
        gamePanel.setLayout(null);
        topPanel.setBounds(
                0, 0, bounds.width, bounds.height/10
        );
        gamePanel.setBounds(
                0, bounds.height/10, bounds.width, bounds.height-(bounds.height/10)
        );
        topPanel.setBackground(new Color(0, 0, 0));
        gamePanel.setBackground(new Color(26, 13, 0));

        add(topPanel);
        add(gamePanel);
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public void closeFrame() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
