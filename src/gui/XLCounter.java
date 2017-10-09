package gui;

public class XLCounter {
    private int counter;

    void increment() {
        counter++;
    }

    public String toString() {
        return Integer.toString(counter);
    }
}
