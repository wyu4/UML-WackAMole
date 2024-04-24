import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;

public class GameCounter extends JLabel {
    // Default values
    private static final int defaultPoints = 0;
    private static final Dimension defaultDimension = Toolkit.getDefaultToolkit().getScreenSize().getSize();
    private static final Font defaultFont = new Font(TOOL_TIP_TEXT_KEY, ALLBITS, 25);

    // Instance variables
    private int points;

    // Constructors
    public GameCounter() { // Default
        this(defaultPoints, defaultDimension, defaultFont);
    }

    public GameCounter(int startingPoints) { // Overloaded
        this(startingPoints, defaultDimension, defaultFont);
    }

    public GameCounter(Dimension size) { // Overloaded
        this(defaultPoints, size, defaultFont);
    }

    public GameCounter(Font font) { // Overloaded
        this(defaultPoints, defaultDimension, font);
    }

    public GameCounter(Dimension size, Font font) { // Overloaded
        this(defaultPoints, size, font);
    }

    public GameCounter(int startingPoints, Font font) { // Overloaded
        this(startingPoints, defaultDimension, font);
    }

    public GameCounter(int startingPoints, Dimension size) { // Overloaded
        this(startingPoints, size, defaultFont);
    }

    public GameCounter(int startingPoints, Dimension size, Font font) { // Overloaded
        points = startingPoints;

        setText("Points: " + startingPoints);
        setBounds(0, 0, (int) size.getWidth(), (int) size.getHeight());
        setFont(font); // defaultFont
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
