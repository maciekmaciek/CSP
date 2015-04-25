package Interpreter;

import CSP.Variable;

import java.util.Map;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-25.
 */
public interface Expression {
    public Integer interpret(Map<String, Variable> variables);
}
