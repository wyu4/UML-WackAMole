import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameMole extends JButton {
    // Default values
    private static final ImageIcon defaultIcon = new ImageIcon("src/MoleIcon.png");
    private static final Dimension defaultSize = new Dimension(98, 110);
    private static final int defaultMinX = 0;
    private static final int defaultMinY = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/10);
    private static final int defaultMaxX = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() - defaultSize.getWidth());
    private static final int defaultMaxY = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() - defaultSize.getHeight());

    // Instance variables
    private ActionListener listener;
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    // Constructors
    public GameMole(ActionListener listener) {
        this(listener, defaultIcon, defaultSize, defaultMinX, defaultMinY, defaultMaxX, defaultMaxY);
    }

    public GameMole(ActionListener listener, ImageIcon icon) {
        this(listener, icon, defaultSize, defaultMinX, defaultMinY, defaultMaxX, defaultMaxY);
    }

    public GameMole(ActionListener listener, Dimension size) {
        this(listener, defaultIcon, size, defaultMinX, defaultMinY, defaultMaxX, defaultMaxY);
    }

    public GameMole(ActionListener listener, int minX, int minY, int maxX, int maxY) {
        this(listener, defaultIcon, defaultSize, minX, minY, maxX, maxY);
    }

    public GameMole(ActionListener listener, ImageIcon icon, Dimension size) {
        this(listener, icon, size, defaultMinX, defaultMinY, defaultMaxX, defaultMaxY);
    }

    public GameMole(ActionListener listener, ImageIcon icon, int minX, int minY, int maxX, int maxY) {
        this(listener, icon, defaultSize, minX, minY, maxX, maxY);
    }

    public GameMole(ActionListener listener, Dimension size, int minX, int minY, int maxX, int maxY) {
        this(listener, defaultIcon, size,  minX, minY, maxX, maxY);
    }

    public GameMole(ActionListener listener, ImageIcon icon, Dimension size, int minX, int minY, int maxX, int maxY) {
        this.listener = listener;
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;

        setBounds((Math.abs(minX + minX)/2), (Math.abs(minY + maxY)/2), (int) size.getWidth(), (int) size.getHeight());
        setIcon(icon);
        setText("MOLE");
        addActionListener(listener);
    }

    // Methods
    public void moveRandom() {
        Dimension newPos = new Dimension(
            getRandomNumber(minX, maxX),
            getRandomNumber(minY, maxY)
        );
        setBounds(
            (int) newPos.getWidth(),
            (int) newPos.getHeight(),
            getWidth(),
            getHeight()
        );

        System.out.println("Moved mole to a new location: " + newPos.toString());
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}