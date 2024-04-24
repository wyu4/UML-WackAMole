import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WackAMole {
    // Instance variables
    private GameFrame gameFrame;
    private GameCounter gameCounter;
    private GameMole gameMole;

    private boolean playing;
    
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public WackAMole() {
        playing = false;

        gameFrame = new GameFrame(new Dimension((int) (screenSize.getWidth()), (int) (screenSize.getHeight())));
        gameCounter = new GameCounter(new Dimension(gameFrame.getWidth(), gameFrame.getHeight() / 10));
        gameMole = new GameMole(moleOnClicked);

        gameFrame.add(gameCounter);
        gameFrame.add(gameMole);

        gameFrame.setVisible(true);
        gameFrame.setAlwaysOnTop(true);
    }

    public void startGame() {
        playing = true;
        while (playing) {
            try {
                Thread.sleep((long)(Math.random() * 3000));
                gameMole.moveRandom();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void pauseGame() {
        playing = false;
    }

    public void stopGame() {
        playing = false;
        gameFrame.closeFrame();
    }

    private ActionListener moleOnClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameMole.moveRandom();
            gameCounter.addPoint();
        }
    };
}