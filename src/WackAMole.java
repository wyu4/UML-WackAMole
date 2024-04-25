import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WackAMole implements ActionListener {
    // Constants
    private static final Rectangle DEF_BOUNDS = new Rectangle(0, 0, 500, 500);

    // Instance variables
    private final GameFrame gameFrame;
    private final GameCounter gameCounter;
    private final GameMole gameMole;
    private final GameButton stopButton;
    private final GameButton pauseButton;

    private Thread gameThread;

    private volatile boolean gameIsRunning = false; // A flag that determines if the game should run;

    // Constructor
    public WackAMole() {
        this(DEF_BOUNDS);
    }

    /**
     * Creates a new WackAMole object
     * @param bounds The bounds of the frame
     */
    public WackAMole(Rectangle bounds) { // Default
        // Create a new gameFrame
        gameFrame = new GameFrame(bounds);
        // Create a new counter
        gameCounter = new GameCounter(new Dimension(bounds.width, bounds.height / 10));
        // Create a new mole
        gameMole = new GameMole(0, 0, bounds.width, bounds.height);

        // Create new close button using GameButton class
        stopButton = new GameButton(
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
        gameFrame.getTopPanel().add(stopButton);
        gameFrame.getTopPanel().add(pauseButton);
        gameFrame.getGamePanel().add(gameMole.getButton());

        // Add action listeners
        gameMole.getButton().addActionListener(this);
        stopButton.addActionListener(this);
        pauseButton.addActionListener(this);
    }

    /**
     * Starts the Wack-A-Mole game.
     */
    public void startGame() {
        gameFrame.setVisible(true); // Set the frame to visible
        gameFrame.setAlwaysOnTop(true); // Set the frame to always be on top

        pauseButton.setBackground(
                new Color(218, 215, 77)
        );
        pauseButton.setIcon(
                new ImageIcon("src/Icons/PauseIcon.png")
        );

        gameThread = new Thread() {
            @Override
            public void run() {
                System.out.println("Game thread started.");
                gameIsRunning = true; // Set flag to true

                while (gameIsRunning) { // Loop through game while flag is true
                    gameMole.moveRandom();
                    try {
                        Thread.sleep((long) (Math.random() * 5000));
                    } catch (InterruptedException ignored) {}
                }
            }

            @Override
            public void interrupt() {
                Thread.currentThread().interrupt();
                gameIsRunning = false;
                System.out.println("Game thread stopped.");
            }
        };
        gameThread.start();
    }

    public void pauseGame() {
        gameThread.interrupt();
        pauseButton.setBackground(
                new Color(32, 120, 32)
        );
        pauseButton.setIcon(
                new ImageIcon("src/Icons/PlayIcon.png")
        );
        gameFrame.setAlwaysOnTop(false);
    }

    /**
     * Closes the Wack-A-Mole game, along with the program.
     */
    public void stopGame() {
        gameThread.interrupt();

        gameFrame.closeFrame();
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
        if (e.getSource() == gameMole.getButton()) {

            if (gameIsRunning) {
                gameMole.moveRandom(); // Move the mole
                gameCounter.addPoint(1); // Award user one point
            }

        } else if (e.getSource() == stopButton) {

            stopGame();

        } else if (e.getSource() == pauseButton) {

            if (!gameIsRunning) {
                startGame();
            } else {
                pauseGame();
            }

        }
    };
}