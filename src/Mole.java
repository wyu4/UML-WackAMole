import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;

public class Mole extends JButton {
    private final JPanel gamePanel;

    public Mole() {
        this(new GameFrame().getGamePanel());        
    }

    public Mole(JPanel gamePanel) {
        this.gamePanel = gamePanel;

        setBounds(0, 0, 250, 250);
        setVisible(true);

        this.gamePanel.add(this, BorderLayout.CENTER);
    }
}
