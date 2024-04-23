import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame{
    private final JPanel gamePanel;

    public GameFrame() {
        this(true);
    }

    public GameFrame(boolean showOnInit) {
        // Setting up the frame
        setTitle("Wack-A-Mole"); // Set the title to "Wack-A-Mole"
        setSize( // Set size to user's screen size
            (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
            (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()
        );
        setUndecorated(true);
        setOpacity(0.25f);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setAlwaysOnTop(showOnInit);
        setVisible(showOnInit);

        // Setting up the game panel
        gamePanel = new JPanel();
        gamePanel.setBounds(getBounds());
        gamePanel.setVisible(true);
        gamePanel.setOpaque(false);
        
        add(gamePanel, BorderLayout.CENTER);
    }

    /**
     * Hide the frame
     */
    public void hideFrame() {
        this.setAlwaysOnTop(false);
        this.setVisible(false);
    }

    /**
     * Show the frame
     */
    public void showFrame() {
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    /**
     * Programmatically close the window.
     */
    public void closeFrame() {
        this.dispatchEvent(
            new WindowEvent(this, WindowEvent.WINDOW_CLOSING) // Programmatically close the window
        );
    }
}
