package gui;

import javafx.beans.Observable;

import java.awt.Color;
import java.util.Observer;

public class CurrentLabel extends ColoredLabel implements Observer {

    private CurrentSlot currentSlot;

    CurrentLabel(CurrentSlot currentSlot) {
        super("A1", Color.WHITE);
        currentSlot.addObserver(this);
        this.currentSlot = currentSlot;
    }


    public void update(java.util.Observable o, Object arg) {
        setText(currentSlot.getAddress());
    }

}