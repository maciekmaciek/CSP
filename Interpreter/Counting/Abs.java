package Interpreter.Counting;

import CSP.Variable;
import Interpreter.Expression;

import java.util.ArrayList;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-26.
 */
public class Abs implements Expression {
    Expression operand;

    public Abs(Expression operand) {
        this.operand = operand;
    }

    @Override
    public Integer interpret(ArrayList<Variable> variables) {
        Integer res = operand.interpret(variables);
        return res == null ? null : Math.abs(res);
    }
}
