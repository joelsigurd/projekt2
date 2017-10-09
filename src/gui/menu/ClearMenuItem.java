package gui.menu;


import spreadsheet.CellEnvironment;
import gui.CurrentSlot;
import gui.StatusLabel;
import util.XLException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JMenuItem;

class ClearMenuItem extends JMenuItem implements ActionListener {
    private CellEnvironment sheet;
    private CurrentSlot currentSlot;
    private StatusLabel statusLabel;

    ClearMenuItem(CurrentSlot currentSlot, CellEnvironment sheet, StatusLabel statusLabel) {
        super("Clear");
        this.sheet = sheet;
        this.currentSlot = currentSlot;
        this.statusLabel = statusLabel;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            sheet.addExprToCell(currentSlot.getAddress(), "");
        } catch (XLException exe){
            statusLabel.setText(exe.getMessage());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
