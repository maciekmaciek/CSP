package Interpreter;

import CSP.Variable;

import java.util.ArrayList;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-25.
 */
public class VariableHolder implements Expression {
    private String name;

    public VariableHolder(String name)
    { this.name = name; }

    public Integer interpret(ArrayList<Variable> variables)  {
        for(Variable var :variables)
            if(var.getName().equals(name))
                return var.getValue();
        return null;
    }
}
