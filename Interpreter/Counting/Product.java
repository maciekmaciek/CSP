package Interpreter.Counting;

import CSP.Variable;
import Interpreter.Expression;

import java.util.ArrayList;

/**
 * Created by Maciej Wola�ski
 * maciekwski@gmail.com
 * on 2015-04-26.
 */
public class Product implements Expression {
    Expression leftO;
    Expression rightO;

    public Product(Expression leftO, Expression rightO) {
        this.leftO = leftO;
        this.rightO = rightO;
    }

    @Override
    public Integer interpret(ArrayList<Variable> variables) {
        Integer left = leftO.interpret(variables);
        Integer right = rightO.interpret(variables);
        //left = left == null ? 1 : left;
        //right = right == null ? 1 : right;
        //return left * right;
        return left == null || right == null ? null : left * right;
    }
}
