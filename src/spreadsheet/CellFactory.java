package spreadsheet;

import expr.ExprParser;
import util.XLException;

import java.io.IOException;


class CellFactory {


    Cell cellBuilder(String s) {
        ExprParser parser = new ExprParser();

        if (s.length() > 0) {
            if (s.charAt(0) == '#') {
                return new CommentCell(s);
            }
            try {
                return new ExpressionCell(parser.build(s).toString());
            } catch (IOException e) {
                throw new XLException("Parsing error");
            }
        }
        return null;
    }

}
