import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;

public class GameCounter extends JLabel {
    // Constants (default values stored in one place for easy developer access)
    private static final int DEF_POINTS = 0;
    private static final Dimension DEF_DIMENSION = Toolkit.getDefaultToolkit().getScreenSize().getSize();
    private static final Font DEF_FONT = new Font(TOOL_TIP_TEXT_KEY, ALLBITS, 25);

    // Instance variables
    private int points;

    // Constructors
    public GameCounter() { // Default
        this(DEF_POINTS, DEF_DIMENSION, DEF_FONT);
    }

    public GameCounter(int startingPoints) { // Overloaded
        this(startingPoints, DEF_DIMENSION, DEF_FONT);
    }

    public GameCounter(Dimension size) { // Overloaded
        this(DEF_POINTS, size, DEF_FONT);
    }

    public GameCounter(Font font) { // Overloaded
        this(DEF_POINTS, DEF_DIMENSION, font);
    }

    public GameCounter(Dimension size, Font font) { // Overloaded
        this(DEF_POINTS, size, font);
    }

    public GameCounter(int startingPoints, Font font) { // Overloaded
        this(startingPoints, DEF_DIMENSION, font);
    }

    public GameCounter(int startingPoints, Dimension size) { // Overloaded
        this(startingPoints, size, DEF_FONT);
    }

    public GameCounter(int startingPoints, Dimension size, Font font) { // Overloaded
        points = startingPoints;

        setText("Points: " + startingPoints);
        setBounds(0, 0, (int) size.getWidth(), (int) size.getHeight());
        setForeground(new Color(255, 255, 255));
        setFont(font); // DEF_FONT
    }

    // Methods
    public void addPoint() { // Default
        addPoint(1);
    }

    public void addPoint(int amount) { // Overloaded
        points += amount;
        setText("Points: " + points);
    }
    
    public int getPoints() {
        return points;
    }
}
