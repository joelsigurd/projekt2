package gui;

import spreadsheet.CellEnvironment;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

class SheetPanel extends BorderPanel {
    SheetPanel(int rows, int columns, CurrentSlot currentSlot, CellEnvironment sheet) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, currentSlot, sheet));

    }
}