import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameMole extends JButton {
    // Constants (default values stored in one place for easy developer access)
    private static final ImageIcon DEF_ICON = new ImageIcon("src/MoleIcon.png");
    private static final Dimension DEF_SIZE = new Dimension(98, 110);
    private static final int DEF_MIN_X = 0;
    private static final int DEF_MIN_Y = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/10);
    private static final int DEF_MAX_X = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() - DEF_SIZE.getWidth());
    private static final int DEF_MAX_Y = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() - DEF_SIZE.getHeight());

    // Instance variables
    private int minX; // Mole's minimum X pos at all time |
    private int minY; // Mole's minimum y pos at all time |
    private int maxX; // Mole's maximum x pos at all time |
    private int maxY; // Mole's maximum y pos at all time } These are to ensure that the mole stays on screen

    // Constructors
    // I could have a default constructor, but the mole would kind of do absolutely nothing since it won't take in an action listener
    
    /**
     * Creates a new mole object
     * @param listener The action listener to trigger when clicked
     * @apiNote The listener must be provided to create a mole object
     */
    public GameMole(ActionListener listener) { // Overloaded
        this(listener, DEF_ICON, DEF_SIZE, DEF_MIN_X, DEF_MIN_Y, DEF_MAX_X, DEF_MAX_Y);
    }

    /**
     * Creates a new mole object
     * @param listener The action listener to trigger when clicked
     * @param size The size of the mole
     * @param minX The mole's minimum x position at all time
     * @param minY The mole's minimum x position at all time
     * @param maxX The mole's maximum x position at all time
     * @param maxY The mole's maximum y position at all time
     * @apiNote The min/max positions ensure that the mole stays on screen at all time
     * @apiNote The listener must be provided to create a mole object
     */
    public GameMole(ActionListener listener, ImageIcon icon) { // Overloaded
        this(listener, icon, DEF_SIZE, DEF_MIN_X, DEF_MIN_Y, DEF_MAX_X, DEF_MAX_Y);
    }

    /**
     * Creates a new mole object
     * @param listener The action listener to trigger when clicked
     * @param icon The icon to be displayed
     * @param size The size of the mole
     * @apiNote The listener must be provided to create a mole object
     */
    public GameMole(ActionListener listener, Dimension size) { // Overloaded
        this(listener, DEF_ICON, size, DEF_MIN_X, DEF_MIN_Y, DEF_MAX_X, DEF_MAX_Y);
    }

    /**
     * Creates a new mole object
     * @param listener The action listener to trigger when clicked
     * @param minX The mole's minimum x position at all time
     * @param minY The mole's minimum x position at all time
     * @param maxX The mole's maximum x position at all time
     * @param maxY The mole's maximum y position at all time
     * @apiNote The min/max positions ensure that the mole stays on screen at all time
     * @apiNote The listener must be provided to create a mole object
     */
    public GameMole(ActionListener listener, int minX, int minY, int maxX, int maxY) { // Overloaded
        this(listener, DEF_ICON, DEF_SIZE, minX, minY, maxX, maxY);
    }

    /**
     * Creates a new mole object
     * @param listener The action listener to trigger when clicked
     * @param icon The icon to be displayed
     * @param size The size of the mole
     * @apiNote The listener must be provided to create a mole object
     */
    public GameMole(ActionListener listener, ImageIcon icon, Dimension size) { // Overloaded
        this(listener, icon, size, DEF_MIN_X, DEF_MIN_Y, DEF_MAX_X, DEF_MAX_Y);
    }

    /**
     * Creates a new mole object
     * @param listener The action listener to trigger when clicked
     * @param icon The icon to be displayed
     * @param minX The mole's minimum x position at all time
     * @param minY The mole's minimum x position at all time
     * @param maxX The mole's maximum x position at all time
     * @param maxY The mole's maximum y position at all time
     * @apiNote The min/max positions ensure that the mole stays on screen at all time
     * @apiNote The listener must be provided to create a mole object
     */
    public GameMole(ActionListener listener, ImageIcon icon, int minX, int minY, int maxX, int maxY) { // Overloaded
        this(listener, icon, DEF_SIZE, minX, minY, maxX, maxY);
    }
    /**
     * Creates a new mole object
     * @param listener The action listener to trigger when clicked
     * @param size The size of the mole
     * @param minX The mole's minimum x position at all time
     * @param minY The mole's minimum x position at all time
     * @param maxX The mole's maximum x position at all time
     * @param maxY The mole's maximum y position at all time
     * @apiNote The min/max positions ensure that the mole stays on screen at all time
     * @apiNote The listener must be provided to create a mole object
     */
    public GameMole(ActionListener listener, Dimension size, int minX, int minY, int maxX, int maxY) { // Overloaded
        this(listener, DEF_ICON, size,  minX, minY, maxX, maxY);
    }

    /**
     * Creates a new mole object
     * @param listener The action listener to trigger when clicked
     * @param icon The icon to be displayed
     * @param size The size of the mole
     * @param minX The mole's minimum x position at all time
     * @param minY The mole's minimum x position at all time
     * @param maxX The mole's maximum x position at all time
     * @param maxY The mole's maximum y position at all time
     * @apiNote The min/max positions ensure that the mole stays on screen at all time
     * @apiNote The listener must be provided to create a mole object
     */
    public GameMole(ActionListener listener, ImageIcon icon, Dimension size, int minX, int minY, int maxX, int maxY) { // Overloaded
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
    /**
     * Moves the mole to a random position within the min/max XY values provided upon object creation.
     */
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
    }

    /**
     * Generates a random number within a range
     * @param min Minimum number
     * @param max Maximum number
     * @return Random number within a range
     */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}