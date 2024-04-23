import javax.swing.JFrame;

public class WackAMole extends JFrame {
    private boolean startedGame;
    private GameFrame gameFrame;

    private int score;
    private int timeRemaining;

    /**
     * Creates a new Wack-A-Mole game
     */
    public WackAMole() {
        this(false);
    }

    /**
     * Creates a new Wack-A-Mole game
     * @param startOnInit Start the game instantly
     */
    public WackAMole(boolean startOnInit) {
        this.startedGame = startOnInit;
        this.gameFrame = new GameFrame(true);

        this.score = 0; // Give the user a default value of 0 points
        this.timeRemaining = 60; // Give the user 60 seconds
    }

    public void startGame() {
        Mole mole = new Mole(gameFrame.getGamePanel());

        if (!startedGame) {
            startedGame = true;
            gameFrame.showFrame();
        }
    }

    public void closeGame() {
        gameFrame.closeFrame();
    }
}