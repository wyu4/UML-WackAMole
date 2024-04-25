import java.awt.Rectangle;

public class GameTest {
    public static WackAMole game1 = new WackAMole(new Rectangle(500, 600)); // Create a new game
    public static WackAMole game2 = new WackAMole(new Rectangle( 500, 0, 1000,700)); // Create a new game

    public static void main(String[] args) throws Exception {
        game1.startGame(); // Start the game

        try {
            Thread.sleep(5000);
        } catch(InterruptedException ignore) {}

        game2.startGame();
    }
}
