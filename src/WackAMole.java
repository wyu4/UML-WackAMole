import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WackAMole {
    // Instance variables
    private GameFrame gameFrame;
    private GameCounter gameCounter;
    private GameMole gameMole;
    private GameButton stopButton;
    private GameButton pauseButton;
    private boolean playing;

    // Constructor
    public WackAMole() { // Default
        playing = false;

        // Create a frame, a counter (for points), and a mole
        gameFrame = new GameFrame(new Dimension(500, 500));
        gameCounter = new GameCounter(new Dimension(gameFrame.getWidth(), gameFrame.getHeight() / 10));
        gameMole = new GameMole(moleOnClicked);

        // Create top bar buttons
        stopButton = new GameButton(
                closeOnClicked,
                gameFrame.getTopPanel().getWidth() - 50,
                0,
                new Dimension(50, 50),
                new Color(255, 0, 0),
                "Close",
                new ImageIcon("src/Icons/CloseIcon.png")
                );

        // Add game components
        gameFrame.getTopPanel().add(gameCounter);
        gameFrame.getTopPanel().add(stopButton);
        gameFrame.getGamePanel().add(gameMole.getButton());
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

    private ActionListener closeOnClicked = new ActionListener() { // Runs when the mole is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            stopGame();
        }
    };

    private ActionListener pauseOnClicked = new ActionListener() { // Runs when the mole is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            if (playing) {
                pauseGame();
            } else {
                startGame();
            }
        }
    };
}