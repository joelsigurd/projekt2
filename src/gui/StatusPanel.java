package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

class StatusPanel extends BorderPanel {
    StatusPanel(StatusLabel statusLabel, CurrentSlot currentSlot) {
        add(WEST, new CurrentLabel(currentSlot));
        add(CENTER, statusLabel);
    }
}