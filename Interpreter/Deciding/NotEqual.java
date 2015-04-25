package Interpreter.Deciding;

import CSP.Variable;
import Interpreter.Expression;

import java.util.Map;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-26.
 */
public class NotEqual implements Expression {
    Expression leftO;
    Expression rightO;

    public NotEqual(Expression leftO, Expression rightO) {
        this.leftO = leftO;
        this.rightO = rightO;
    }

    @Override
    public Integer interpret(Map<String, Variable> variables) {
        Integer left = leftO.interpret(variables);
        Integer right = rightO.interpret(variables);
        if(left == null || right == null || !right.equals(left))
            return 1;
        else
            return 0;
    }
}