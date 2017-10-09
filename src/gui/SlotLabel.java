package gui;



import spreadsheet.CellEnvironment;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;


public class SlotLabel extends ColoredLabel implements Observer, MouseListener {
    private String label;
    private CurrentSlot currentSlot;
    private CellEnvironment cellEnvironment;


    SlotLabel(String s, CurrentSlot currentSlot, CellEnvironment sheet) {
        super("                    ", Color.WHITE, RIGHT);
        this.label = label;
        this.currentSlot = this.currentSlot;
        addMouseListener(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        setText(cellEnvironment.stringValue(label));
        if(currentSlot.getAddress().equals(label)){
            setBackground(Color.YELLOW);
        } else {
            setBackground(Color.WHITE);
            currentSlot.deleteObserver(this);
        }

    }

    String getLabel(){
        return this.label;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        currentSlot.changeCurrent(label);
        currentSlot.addObserver(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
