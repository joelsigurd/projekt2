package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

class BorderPanel extends JPanel {
    BorderPanel() {
        super(new BorderLayout(2, 2));
        setBackground(Color.BLACK);
    }
}
