package gui.menu;

import gui.StatusLabel;
import gui.XL;
import spreadsheet.CellEnvironment;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

class SaveMenuItem extends OpenMenuItem {

    private CellEnvironment sheet;

    SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
    }

    protected void action(String path) throws FileNotFoundException {
        try{
            sheet.saveToFile(path);
        }
        catch (FileNotFoundException exception){
            statusLabel.setText(exception.getMessage());
            exception.printStackTrace();
        }
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}