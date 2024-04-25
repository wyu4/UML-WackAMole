import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {
    // Instance variables
    private final JLabel picture; // The label containing the icon
    private int x, y; // X/Y coordinates of the button
    private Dimension size; // The size of the JButton
    private Icon icon; // The icon contained inside the picture

    /**
     * Creates a new GameButton object
     */
    public GameButton() {
        setLayout(new BorderLayout());

        picture = new JLabel();
        add(picture, BorderLayout.CENTER);
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
        this.x = x;
        this.y = y;
        this.size = size;
        this.icon = icon;

        setBounds(x, y, size.width, size.height);
        setBackground(color);
        setText(text);
        setBorder(null);
        setFocusPainted(false);
        setLayout(new BorderLayout());

        picture = new JLabel(icon);
        picture.setLayout(null);
        picture.setBounds(0, 0, size.width, size.height);

        add(picture, BorderLayout.CENTER);
    }

    @Override
    public void setIcon(Icon icon) {
        picture.setIcon(icon);
        this.icon = icon;
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(x, y, getWidth(), getHeight());
    }

    public void setSize(Dimension size) {
        this.size = size;
        setBounds(x, y, (int) size.width, (int) size.height);
    }
}