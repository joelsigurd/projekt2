package gui;

import spreadsheet.CellEnvironment;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.SwingConstants;

public class SlotLabels extends GridPanel implements Observer{
    private List<SlotLabel> labelList;

    public SlotLabels(int rows, int cols, CurrentSlot currentSlot, CellEnvironment sheet) {
        super(rows + 1, cols);
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                SlotLabel label = new SlotLabel(String.valueOf(ch) + row, currentSlot, sheet);
                add(label);
                labelList.add(label);
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        CellEnvironment temp = (CellEnvironment) o;
        for (SlotLabel s1 : labelList) {
            s1.setText(temp.stringValue(s1.getLabel()));
        }
    }

}
