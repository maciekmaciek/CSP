package Interpreter;

import CSP.Variable;

import java.util.ArrayList;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-25.
 */
public class IntegerValue implements Expression {
    private int number;
    public IntegerValue(int number)
    { this.number = number; }

    public Integer interpret(ArrayList<Variable> variables)
    { return number; }
}
