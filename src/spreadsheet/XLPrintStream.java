package spreadsheet;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map.Entry;
import java.util.Set;


class XLPrintStream extends PrintStream {
    XLPrintStream(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    void save(Set<Entry<String, Cell>> set) {
        for (Entry<String, Cell> entry : set) {
            print(entry.getKey());
            print('=');
            println(entry.getValue());
        }
        flush();
        close();
    }
}
