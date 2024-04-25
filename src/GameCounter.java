import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;

public class GameCounter extends JLabel {
    // Constants (default values stored in one place for easy developer access)
    private static final int DEF_POINTS = 0;
    private static final Dimension DEF_DIMENSION = Toolkit.getDefaultToolkit().getScreenSize().getSize();
    private static final Font DEF_FONT = new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 25);

    // Instance variables
    private int points;

    // Constructors
    /**
     * Creates a new GameCounter object
     */
    public GameCounter() { // Default
        this(DEF_POINTS, DEF_DIMENSION, DEF_FONT);
    }

    /**
     * Creates a new GameCounter object
     * @param startingPoints The default points
     */
    public GameCounter(int startingPoints) { // Overloaded
        this(startingPoints, DEF_DIMENSION, DEF_FONT);
    }

    /**
     * Creates a new GameCounter object
     * @param size The size of the counter
     */
    public GameCounter(Dimension size) { // Overloaded
        this(DEF_POINTS, size, DEF_FONT);
    }

    /**
     * Creates a new GameCounter object
     * @param font The font of the counter
     */
    public GameCounter(Font font) { // Overloaded
        this(DEF_POINTS, DEF_DIMENSION, font);
    }

    /**
     * Creates a new GameCounter object
     * @param size The size of the counter
     * @param font The font of the counter
     */
    public GameCounter(Dimension size, Font font) { // Overloaded
        this(DEF_POINTS, size, font);
    }

    /**
     * Creates a new GameCounter object
     * @param startingPoints The default points
     * @param font The font of the counter
     */
    public GameCounter(int startingPoints, Font font) { // Overloaded
        this(startingPoints, DEF_DIMENSION, font);
    }

    /**
     * Creates a new GameCounter object
     * @param startingPoints The default points
     * @param size The size of the counter
     */
    public GameCounter(int startingPoints, Dimension size) { // Overloaded
        this(startingPoints, size, DEF_FONT);
    }

    /**
     * Creates a new GameCounter object
     * @param startingPoints The default points
     * @param size The size of the counter
     * @param font The font of the counter
     */
    public GameCounter(int startingPoints, Dimension size, Font font) { // Overloaded
        points = startingPoints;

        setText("Points: " + startingPoints);
        setBounds(0, 0, (int) size.getWidth(), (int) size.getHeight());
        setForeground(new Color(255, 255, 255));
        setFont(font); // DEF_FONT
    }

    // Methods

    /**
     * Increase the counter by one point
     */
    public void addPoint() { // Default
        addPoint(1);
    }

    /**
     * Increase the counter
     * @param amount Amount to increase by
     */
    public void addPoint(int amount) { // Overloaded
        points += amount;
        setText("Points: " + points);
    }
    
    public int getPoints() {
        return points;
    }
}
