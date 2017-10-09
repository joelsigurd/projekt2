package spreadsheet;

import expr.Environment;

public class CommentCell implements Cell {

    private String text;

    public CommentCell(String text){
        this.text = text;
    }

    @Override
    public double v1(Environment env) {
        return 0;
    }

    @Override
    public String s1(Environment env) {
        return text.substring(1);
    }

    public String toString(){
        return text.substring(0);
    }

}
