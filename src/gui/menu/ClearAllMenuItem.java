package gui.menu;

import spreadsheet.CellEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class ClearAllMenuItem extends JMenuItem implements ActionListener {

    private CellEnvironment sheet;

    ClearAllMenuItem() {
        super("Clear all");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        sheet.clearAll();
    }
}