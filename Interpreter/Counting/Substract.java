package Interpreter.Counting;

import CSP.Variable;
import Interpreter.Expression;

import java.util.Map;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-26.
 */
public class Substract implements Expression {
    Expression leftO;
    Expression rightO;

    public Substract(Expression leftO, Expression rightO) {
        this.leftO = leftO;
        this.rightO = rightO;
    }

    @Override
    public Integer interpret(Map<String, Variable> variables) {
        Integer left = leftO.interpret(variables);
        Integer right = rightO.interpret(variables);
        left = left == null ? 0 : left;
        right = right == null ? 0 : right;
        return left - right;
    }
}
