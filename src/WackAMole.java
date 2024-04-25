import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WackAMole implements ActionListener {
    // Constants
    private static final Rectangle DEF_BOUNDS = new Rectangle(0, 0, 500, 500); // Default bounds of frame

    // Instance variables
    private final GameFrame gameFrame; // The main frame
    private final GameCounter gameCounter; // The game counter for points
    private final GameMole gameMole; // The mole
    private final GameButton closeButton; // The stop/close button
    private final GameButton pauseButton; // The pause button

    private Thread gameThread; // The thread used for running the game
    // I am using a different thread because the game runs on a while loop, and I want the user to be able to execute other tasks while this loop is active

    private volatile boolean gameIsRunning = false; // A flag that determines if the game should run;

    // Constructor
    /**
     * Creates a new WackAMole object
     */
    public WackAMole() { // Default
        this(DEF_BOUNDS);
    }

    /**
     * Creates a new WackAMole object
     * @param bounds The bounds of the frame
     */
    public WackAMole(Rectangle bounds) { // Overloaded
        // Create a new gameFrame
        gameFrame = new GameFrame(bounds);
        // Create a new counter
        gameCounter = new GameCounter(new Dimension(bounds.width, bounds.height / 10));
        // Create a new mole
        gameMole = new GameMole(0, 0, bounds.width, bounds.height);

        // Create new close button using GameButton class
        closeButton = new GameButton(
                gameFrame.getTopPanel().getWidth() - 50,
                0,
                new Dimension(50, 50),
                new Color(255, 0, 0),
                null,
                new ImageIcon("src/Icons/CloseIcon.png")
        );
        // Create a new pause button using GameButton class
        pauseButton = new GameButton(
                gameFrame.getTopPanel().getWidth() - 110,
                0,
                new Dimension(50, 50),
                new Color(218, 215, 77),
                null,
                new ImageIcon("src/Icons/CloseIcon.png")
        );

        // Add game components to respective containers
        gameFrame.getTopPanel().add(gameCounter);
        gameFrame.getTopPanel().add(closeButton);
        gameFrame.getTopPanel().add(pauseButton);
        gameFrame.getGamePanel().add(gameMole.getButton());

        // Add action listeners to respective containers
        gameMole.getButton().addActionListener(this);
        closeButton.addActionListener(this);
        pauseButton.addActionListener(this);
    }

    /**
     * Starts the Wack-A-Mole game.
     */
    public void startGame() {
        gameFrame.setVisible(true); // Set the frame to visible
        gameFrame.setAlwaysOnTop(true); // Set the frame to always be on top

        pauseButton.setBackground( // Make the pause button yellow
                new Color(218, 215, 77)
        );
        pauseButton.setIcon( // Change to the "pause" icon
                new ImageIcon("src/Icons/PauseIcon.png")
        );

        gameThread = new Thread() { // Create a new thread
            @Override
            public void run() {
                gameIsRunning = true; // Set flag to true

                while (gameIsRunning) { // Loop through game while gameIsRunning flag is true
                    gameMole.moveRandom(); // Move the mole to a random location
                    try {
                        Thread.sleep((long) (Math.random() * 5000)); // Wait 0-5 seconds
                    } catch (InterruptedException ignored) {}
                }
            }

            @Override
            public void interrupt() {
                Thread.currentThread().interrupt(); // Interrupt the thread
                gameIsRunning = false; // Set gameIsRunning flag to false
            }
        };
        gameThread.start(); // Start the above thread
    }

    /**
     * Temporarily pauses the game
     */
    public void pauseGame() {
        gameThread.interrupt(); // Stop the game thread
        pauseButton.setBackground( // Change the pause button to green
                new Color(32, 120, 32)
        );
        pauseButton.setIcon( // Change to the "play" icon
                new ImageIcon("src/Icons/PlayIcon.png")
        );
        gameFrame.setAlwaysOnTop(false); // The game frame is no longer always on top of other frames
    }

    /**
     * Closes the Wack-A-Mole game, along with the program.
     */
    public void stopGame() {
        gameThread.interrupt(); // Stop the game thread
        gameFrame.closeFrame(); // Close the frame
    }

    /**
     * Get the current running status of the game
     * @return Boolean representing whether the game is running or not.
     */
    public boolean isGameRunning() {
        return gameIsRunning;
    }

    // Runs when the stop button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gameMole.getButton()) { // Check if mole was clicked
            if (gameIsRunning) {
                gameMole.moveRandom(); // Move the mole
                gameCounter.addPoint(1); // Award user one point
            }
        } else if (e.getSource() == closeButton) { // Check if close button was clicked
            stopGame(); // Stop the game
        } else if (e.getSource() == pauseButton) { // Check if pause button was clicked
            if (!gameIsRunning) {
                startGame(); // Start the game if not running
            } else {
                pauseGame(); // Pause the game if running
            }
        }
    };
}