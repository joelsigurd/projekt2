package spreadsheet;

import expr.Environment;
import util.XLException;

public class BombCell implements Cell {

    public double v1(Environment env) {
        throw new XLException("Circular dependency");
    }

    public String s1(Environment env) {
        throw new XLException("Circular slot");
    }

    public String toString(){
        throw new XLException("Circular dependency");
    }

}
