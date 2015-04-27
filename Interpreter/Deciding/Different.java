package Interpreter.Deciding;

import CSP.Variable;
import Interpreter.Expression;

import java.util.*;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-25.
 */
public class Different implements Expression {
    private ArrayList<Expression> expressions;
    //private ArrayList<Integer>results = new ArrayList<>();
    private HashSet<Integer> filterSet;

    public Different(ArrayList<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public Integer interpret(ArrayList<Variable> variables) {
        ArrayList<Integer> results = new ArrayList<>();
        for(Expression i: expressions)
        {
            results.add(i.interpret(variables));
        }
        results.removeAll(Collections.singleton(null));
        filterSet = new HashSet<>(results);
        return filterSet.size() == results.size() ? 1:0;
    }
}
