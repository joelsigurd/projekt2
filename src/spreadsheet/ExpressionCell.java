package spreadsheet;

import expr.Environment;
import expr.Expr;
import expr.ExprParser;

import java.io.IOException;

public class ExpressionCell implements Cell {

    private Expr expr;

    ExpressionCell(String text) throws IOException {
        ExprParser parser = new ExprParser();
        try{
            this.expr = parser.build(text);
        }
        catch (IOException exception){
            exception.printStackTrace();
            throw exception;
        }
    }
    public double v1(Environment env) {
        return expr.value(env);
    }

    public String s1(Environment env) {
        return Double.toString(v1(env));
    }

    public String toString(){
        return expr.toString();
    }
}
