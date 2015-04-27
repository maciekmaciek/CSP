package Interpreter.Deciding;

import CSP.Variable;
import Interpreter.Expression;

import java.util.ArrayList;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-26.
 */
public class Less implements Expression {
    Expression leftO;
    Expression rightO;

    public Less(Expression leftO, Expression rightO) {
        this.leftO = leftO;
        this.rightO = rightO;
    }

    @Override
    public Integer interpret(ArrayList<Variable> variables) {
        Integer left = leftO.interpret(variables);
        Integer right = rightO.interpret(variables);
        if(left == null || right == null || left < right)
            return 1;
        else
            return 0;
    }
}
