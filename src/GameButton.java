import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {
    // Instance variables
    private final JLabel picture; // The label containing the icon
    private int x, y; // X/Y coordinates of the button
    private Icon icon; // The icon contained inside the picture

    /**
     * Creates a new GameButton object
     */
    public GameButton() {
        this(0, 0, new Dimension(100, 100), Color.WHITE, "Button", null);
    }

    /**
     * Creates a new GameButton object
     * @param x The x position of the button
     * @param y The y position of the button
     * @param size The size of the button
     * @param color The color of the button
     * @param text The text of the button
     * @param icon The icon of the button
     */
    public GameButton(int x, int y, Dimension size, Color color, String text, Icon icon) {
        // Initializing instance variables
        this.x = x;
        this.y = y;
        this.icon = icon;

        setBounds(x, y, size.width, size.height); // Setting bounds to respective parameters
        setBackground(color); // Set the background color to parameter "color"
        setText(text); // Set the displayed text to parameter "text"
        setBorder(null); // Remove the border
        setLayout(new BorderLayout()); // Set the layout manager to border layout

        picture = new JLabel(icon); // Create JLabel to store icon
        picture.setLayout(null); // Set the picture's layout to none
        picture.setBounds(0, 0, size.width, size.height); // Scale the picture

        add(picture, BorderLayout.CENTER); // Add picture to the button
    }

    // Overriding methods to be compatible with the current setup
    @Override
    public void setIcon(Icon icon) {
        picture.setIcon(icon); // Instead of setting the button's icon, the picture's icon will be set
        this.icon = icon; // Re-initialize the icon
    }

    @Override
    public Icon getIcon() {
        return icon; // Return the picture's icon (which should also be the instance variable) instead of the button's icon
    }

    /**
     * Set the position of the button
     * @param x X position
     * @param y Y position
     */
    public void setPosition(int x, int y) {
        this.x = x; // Set instance variable to x
        this.y = y; // Set instance variable to y
        setBounds(x, y, getWidth(), getHeight()); // Set bounds while maintaining the size and the height
    }

    /**
     * Set the size of the button
     * @param size the dimension specifying the new size
     *          of this component
     */
    public void setSize(Dimension size) {
        setBounds(x, y, (int) size.width, (int) size.height);
        picture.setBounds(0, 0, (int) size.width, (int) size.height); // Set the picture's size as well
    }
}