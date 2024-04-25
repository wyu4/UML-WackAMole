import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GameFrame extends JFrame {
    // Constants (default values stored in one place for easy developer access)
    private static final Rectangle DEF_BOUNDS = new Rectangle(0, 0, 500, 550); // Default bounds
    private static final String DEF_NAME = "Wack-A-Mole"; // Default name of the frame

    private final JPanel topPanel; // The top panel
    private final JPanel gamePanel; // The game panel (should contain the actual game)

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
        setName(name); // Setting the name to parameter "name"
        setBounds(bounds); // Setting the bounds to parameter "bounds"
        setAlwaysOnTop(true); // Setting to frame to always be on top
        getContentPane().setBackground(new Color(26, 13, 0)); // Set the background color to dark brown
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Exit the program when the user closes the frame
        setUndecorated(true); // Hide default decorations
        setLayout(null); // Set the frame's layout to none

        // Initializing instance variables
        topPanel = new JPanel();
        gamePanel = new JPanel();

        // Setting up instance variable properties
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

        // Add the top panel and the game panel to the frame
        add(topPanel);
        add(gamePanel);
    }

    /**
     * Get the top panel
     * @return JPanel representing the top panel
     */
    public JPanel getTopPanel() {
        return topPanel;
    }

    /**
     * Get the game panel
     * @return JPanel representing the game panel
     */
    public JPanel getGamePanel() {
        return gamePanel;
    }

    /**
     * Programmatically close the frame.
     * @apiNote This will be detected by the default close operation
     */
    public void closeFrame() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
