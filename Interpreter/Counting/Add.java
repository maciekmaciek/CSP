package Interpreter.Counting;

import CSP.Variable;
import Interpreter.Expression;

import java.util.ArrayList;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-26.
 */
public class Add implements Expression {
    Expression leftO;
    Expression rightO;

    public Add(Expression leftO, Expression rightO) {
        this.leftO = leftO;
        this.rightO = rightO;
    }

    @Override
    public Integer interpret(ArrayList<Variable> variables) {
        Integer left = leftO.interpret(variables);
        Integer right = rightO.interpret(variables);
        return left == null || right == null ? null : left + right;
        //left = left == null ? 0 : left;
        //right = right == null ? 0 : right;
        //return left + right;
    }
}
