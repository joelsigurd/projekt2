package gui;


import spreadsheet.CellEnvironment;
import util.XLException;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;

public class Editor extends JTextField implements Observer, KeyListener {
    private CurrentSlot currentSlot;
    private CellEnvironment sheet;
    private StatusLabel statusLabel;

    Editor(CurrentSlot currentSlot, CellEnvironment sheet, StatusLabel statusLabel) {
        this.currentSlot = currentSlot;
        this.sheet = sheet;
        this.statusLabel = statusLabel;
        setBackground(Color.WHITE);
        addKeyListener(this);
        currentSlot.addObserver(this);

    }

    @Override
    public void update(Observable o, Object arg) {
        setText(sheet.toString(currentSlot.getAddress()));
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_ENTER:
                try {
                    String expr = getText();
                    sheet.addExprToCell(currentSlot.getAddress(), expr);
                    setText(sheet.toString(currentSlot.getAddress()));
                } catch (XLException exep){
                    statusLabel.setText(exep.getMessage());
                    setText(sheet.toString(currentSlot.getAddress()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
