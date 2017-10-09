package gui;


import java.util.Observable;

public class CurrentSlot extends Observable {
    private String address;

    void changeCurrent(String address){
        this.address = address;
        setChanged();
        notifyObservers();
    }

    public String getAddress(){
        return address;
    }
}
