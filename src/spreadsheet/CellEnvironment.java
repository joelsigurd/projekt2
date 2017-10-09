package spreadsheet;

import expr.Environment;
import util.XLException;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class CellEnvironment extends Observable implements Environment {
    private Map<String, Cell> sheet;
    private CellFactory cellFactory;

    public CellEnvironment(){

        sheet = new HashMap<>();
        cellFactory = new CellFactory();

    }

    public void clearAll(){
        sheet.clear();
        setChanged();
        notifyObservers();
    }

    private void clearCurrent(String address) {
        if (sheet.containsKey(address)) {
            Cell temp = sheet.remove(address);
            try {
                Set<String> keys = sheet.keySet();
                for (String current : keys) {
                    try {
                        sheet.get(current).v1(this);
                    } catch (XLException e) {
                        throw e;
                    }
                }
            } catch (XLException e) {
                sheet.put(address, temp);
                throw e;
            } finally {
                setChanged();
                notifyObservers();
            }
        }
    }


    public void saveToFile(String path) throws FileNotFoundException{
        XLPrintStream print = new XLPrintStream(path);
        print.save(sheet.entrySet());
        print.close();
    }

    public void addExprToCell(String expr, String address) throws IOException, XLException {
        if(expr.equals("")){
            clearCurrent(address);
        } else {
            Cell cell = cellFactory.cellBuilder(expr);
            testCircular(address, cell);
            sheet.put(address, cell);
            setChanged();
            notifyObservers();
        }

    }

    private void testCircular(String address, Cell cell) throws XLException {
        Cell temp = sheet.get(address);
        BombCell circularity = new BombCell();
        sheet.put(address, circularity);
        try {
            cell.v1(this);
        } finally {
            sheet.put(address, temp);

        }

    }

    public String getExpr(String address){
        if(!sheet.containsKey(address)){
            return "";
        }
        return sheet.get(address).toString();
    }

    @Override
    public double value(String address) {
        Cell s = sheet.get(address);
        if(s == null) {
            throw new XLException("Reference to empty slot.");
        }
        return s.v1(this);

    }

    public String stringValue(String address){
        Cell cell = sheet.get(address);
        if(cell == null){
            return "";
        }
        return cell.s1(this);

    }

    public void load(String path, CellEnvironment cellEnvironment) throws IOException {
        XLBufferedReader reader = new XLBufferedReader(path);
        clearAll();
        reader.load(sheet, cellEnvironment);
        setChanged();
        notifyObservers();
        reader.close();

    }

    public String toString(String address){
        Cell cell = sheet.get(address);
        if(cell == null){
            return "";
        }
        return cell.toString();
    }

}
