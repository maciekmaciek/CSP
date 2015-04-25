package Interpreter;

import CSP.Variable;

import java.util.Map;

/**
 * Created by Maciej Wola�ski
 * maciekwski@gmail.com
 * on 2015-04-25.
 */
public class VariableHolder implements Expression {
    private String name;

    public VariableHolder(String name)
    { this.name = name; }

    public Integer interpret(Map<String, Variable> variables)  {
        return variables.get(name).getValue();
    }
}
