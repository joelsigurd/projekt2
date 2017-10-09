package gui.menu;

import gui.StatusLabel;
import gui.XL;
import spreadsheet.CellEnvironment;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;

class LoadMenuItem extends OpenMenuItem {

    private CellEnvironment sheet;
 
    public LoadMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Load");
    }

    protected void action(String path) throws FileNotFoundException {
        try {
            sheet.load(path, sheet);
        }  catch (IOException exception) {
            statusLabel.setText("Kunde inte ladda filen");
            exception.printStackTrace();
        }

    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}