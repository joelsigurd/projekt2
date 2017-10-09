package spreadsheet;

import expr.Environment;

public interface Cell {

    double v1(Environment env);

    String s1(Environment env);

    String toString();
}
