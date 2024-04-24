import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GameButton extends JButton {
    private final JLabel picture;

    public GameButton() {
        setLayout(new BorderLayout());

        picture = new JLabel();
        add(picture, BorderLayout.CENTER);
    }

    public GameButton(ActionListener listener, int x, int y, Dimension size, Color color, String text, Icon icon) {
        setBounds(x, y, size.width, size.height);
        setBackground(color);
        setToolTipText(text);
        setBorder(null);
        setFocusPainted(false);
        setLayout(new BorderLayout());

        picture = new JLabel(icon);
        picture.setLayout(null);
        picture.setBounds(0, 0, size.width, size.height);

        add(picture, BorderLayout.CENTER);

        addActionListener(listener);
    }

    @Override
    public void setIcon(Icon icon) {
        picture.setIcon(icon);
    }
}