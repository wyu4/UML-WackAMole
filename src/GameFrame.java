import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GameFrame extends JFrame {
    // Constants (default values stored in one place for easy developer access)
    private static final Dimension DEF_DIMENSION = new Dimension(500, 550);

    private JPanel topPanel;
    private JPanel gamePanel;

    // Constructors
    public GameFrame() { // Default
        this(DEF_DIMENSION);
    }
    
    public GameFrame(Dimension screenSize) { // Overloaded
        // Setting up gameFrame
        setBounds(
            0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight()
        );
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
                0, 0, (int) screenSize.getWidth(), (int) (screenSize.getHeight()/10)
        );
        gamePanel.setBounds(
                0, (int) (screenSize.getHeight()/10), (int) screenSize.getWidth(), (int) (screenSize.getHeight()-(screenSize.getHeight()/10))
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
