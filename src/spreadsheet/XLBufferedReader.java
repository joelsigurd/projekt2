package spreadsheet;

import util.XLException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

class XLBufferedReader extends BufferedReader {

    XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    void load(Map<String, Cell> map, CellEnvironment cellEnvironment) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf("=");
                cellEnvironment.addExprToCell(string.substring(0,i), string.substring(i+1));
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }


}
