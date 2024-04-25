import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameMole {
    // Constants (default values stored in one place for easy developer access)
    private static final ImageIcon DEF_ICON = new ImageIcon("src/Icons/MoleIcon.png");
    private static final Dimension DEF_SIZE = new Dimension(98, 110);
    private static final int DEF_MIN_X = 0;
    private static final int DEF_MIN_Y = 50;
    private static final int DEF_MAX_X = 500;
    private static final int DEF_MAX_Y = 500;

    // Instance variables
    private final GameButton mole;
    private int minX; // Mole's minimum X pos at all time |
    private int minY; // Mole's minimum y pos at all time |
    private int maxX; // Mole's maximum x pos at all time |
    private int maxY; // Mole's maximum y pos at all time } These are to ensure that the mole stays on screen

    /////////////////////////////////////////////////////////////////////
    // Constructors
    /////////////////////////////////////////////////////////////////////
    /**
     * Creates a new mole object
     */
    public GameMole() { // Overloaded
        this(DEF_ICON, DEF_SIZE, DEF_MIN_X, DEF_MIN_Y, DEF_MAX_X, DEF_MAX_Y);
    }

    /**
     * Creates a new mole object
     * @param icon The icon to be displayed
     * @apiNote The min/max positions ensure that the mole stays on screen at all time
     */
    public GameMole(ImageIcon icon) { // Overloaded
        this(icon, DEF_SIZE, DEF_MIN_X, DEF_MIN_Y, DEF_MAX_X, DEF_MAX_Y);
    }

    /**
     * Creates a new mole object
     * @param size The size of the mole
     */
    public GameMole(Dimension size) { // Overloaded
        this(DEF_ICON, size, DEF_MIN_X, DEF_MIN_Y, DEF_MAX_X, DEF_MAX_Y);
    }

    /**
     * Creates a new mole object
     * @param minX The mole's minimum x position at all time
     * @param minY The mole's minimum x position at all time
     * @param maxX The mole's maximum x position at all time
     * @param maxY The mole's maximum y position at all time
     * @apiNote The min/max positions ensure that the mole stays on screen at all time
     */
    public GameMole(int minX, int minY, int maxX, int maxY) { // Overloaded
        this(DEF_ICON, DEF_SIZE, minX, minY, maxX, maxY);
    }

    /**
     * Creates a new mole object
     * @param icon The icon to be displayed
     * @param size The size of the mole
     */
    public GameMole(ImageIcon icon, Dimension size) { // Overloaded
        this(icon, size, DEF_MIN_X, DEF_MIN_Y, DEF_MAX_X, DEF_MAX_Y);
    }

    /**
     * Creates a new mole object
     * @param icon The icon to be displayed
     * @param minX The mole's minimum x position at all time
     * @param minY The mole's minimum x position at all time
     * @param maxX The mole's maximum x position at all time
     * @param maxY The mole's maximum y position at all time
     * @apiNote The min/max positions ensure that the mole stays on screen at all time
     */
    public GameMole(ImageIcon icon, int minX, int minY, int maxX, int maxY) { // Overloaded
        this(icon, DEF_SIZE, minX, minY, maxX, maxY);
    }
    /**
     * Creates a new mole object
     * @param size The size of the mole
     * @param minX The mole's minimum x position at all time
     * @param minY The mole's minimum x position at all time
     * @param maxX The mole's maximum x position at all time
     * @param maxY The mole's maximum y position at all time
     * @apiNote The min/max positions ensure that the mole stays on screen at all time
     */
    public GameMole(Dimension size, int minX, int minY, int maxX, int maxY) { // Overloaded
        this(DEF_ICON, size,  minX, minY, maxX, maxY);
    }

    /**
     * Creates a new mole object
     * @param icon The icon to be displayed
     * @param size The size of the mole
     * @param minX The mole's minimum x position at all time
     * @param minY The mole's minimum x position at all time
     * @param maxX The mole's maximum x position at all time
     * @param maxY The mole's maximum y position at all time
     * @apiNote The min/max positions ensure that the mole stays on screen at all time
     */
    public GameMole(ImageIcon icon, Dimension size, int minX, int minY, int maxX, int maxY) { // Overloaded
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX - size.width;
        this.maxY = maxY - size.height;

        // Create new mole using GameButton class
        mole = new GameButton(
                Math.abs(minX + minX)/2,
                Math.abs(minY + maxY)/2,
                new Dimension((int) size.getWidth(), (int) size.getHeight()),
                new Color(26, 13, 0),
                null,
                icon
        );
        System.out.println("Mole created!");
    }
    
    /////////////////////////////////////////////////////////////////////
    // Methods
    /////////////////////////////////////////////////////////////////////

    /**
     * Moves the mole to a random position within the min/max XY values provided upon object creation.
     */
    public void moveRandom() {
        // Create a new Dimension object containing valid randomized coordinate
        Dimension newPos = new Dimension(
            getRandomNumber(minX, maxX),
            getRandomNumber(minY, maxY)
        );
        // Apply new coordinate to mole
        mole.setBounds(
            (int) newPos.getWidth(),
            (int) newPos.getHeight(),
                mole.getWidth(),
                mole.getHeight()
        );
    }

    /**
     * Get the button that listens for the user input
     * @return JButton that listens for the user input
     */
    public JButton getButton() {
        return mole;
    }

    /**
     * Get the minimum x position of the mole
     * @return Integer representing the minimum x position
     */
    public int getMinX() {
        return minX;
    }
    /**
     * Set the minimum x position of the mole
     * @param minX Integer representing the minimum x position
     */
    public void setMinX(int minX) {
        this.minX = minX;
    }

    /**
     * Get the minimum y position of the mole
     * @return Integer representing the minimum y position
     */
    public int getMinY() {
        return minY;
    }
    /**
     * Set the minimum y position of the mole
     * @param minY Integer representing the minimum y position
     */
    public void setMinY(int minY) {
        this.minY = minY;
    }

    /**
     * Get the maximum x position of the mole
     * @return Integer representing the maximum x position
     */
    public int getMaxX() {
        return maxX;
    }
    /**
     * Set the maximum x position of the mole
     * @param maxX Integer representing the maximum x position
     */
    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    /**
     * Get the maximum y position of the mole
     * @return Integer representing the maximum y position
     */
    public int getMaxY() {
        return maxY;
    }
    /**
     * Set the maximum y position of the mole
     * @param maxY Integer representing the maximum y position
     */
    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    /**
     * Generates a random number within a range
     * @param min Minimum number
     * @param max Maximum number
     * @return Random number within a range
     */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * Math.abs(max - min)) + min);
    }
}