import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WackAMole {
    // Constants (default values stored in one place for easy developer access)
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    // Instance variables
    private GameFrame gameFrame;
    private GameCounter gameCounter;
    private GameMole gameMole;
    private boolean playing;

    // Constructor
    public WackAMole() { // Default
        playing = false;

        // Create a frame, a counter (for points), and a mole
        gameFrame = new GameFrame(new Dimension((int) (SCREEN_SIZE.getWidth()), (int) (SCREEN_SIZE.getHeight())));
        gameCounter = new GameCounter(new Dimension(gameFrame.getWidth(), gameFrame.getHeight() / 10));
        gameMole = new GameMole(moleOnClicked);

        // Add game components
        gameFrame.add(gameCounter);
        gameFrame.add(gameMole);  
    }

    /**
     * Starts the Wack-A-Mole game.
     */
    public void startGame() {
        gameFrame.setVisible(true); // Set the frame to visible
        gameFrame.setAlwaysOnTop(true); // Set the frame to always be on top

        playing = true; // Set playing to true

        while (playing) { // Loop through program while playing is true
            try { // Wait 0-3 seconds
                Thread.sleep((long)(Math.random() * 3000));
            } catch (Exception e) {}

            gameMole.moveRandom(); // Move the mole
        }
    }

    /**
     * Pauses the Wack-A-Mole game.
     */
    public void pauseGame() {
        playing = false;
    }

    /**
     * Closes the Wack-A-Mole game, along with the program.
     */
    public void stopGame() {
        playing = false;
        gameFrame.closeFrame();
    }

    // Action listeners
    private ActionListener moleOnClicked = new ActionListener() { // Runs when the mole is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            if (playing) { // The following will only run while the user is playing
                gameMole.moveRandom(); // Move the mole
                gameCounter.addPoint(); // Award user one point
            }
        }
    };
}