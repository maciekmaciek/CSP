package Interpreter;

import CSP.Variable;
import Interpreter.Counting.Abs;
import Interpreter.Counting.Add;
import Interpreter.Counting.Product;
import Interpreter.Counting.Substract;
import Interpreter.Deciding.*;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-25.
 */
public class ConstraintInterpreter implements Expression {
    private Expression tree;

    public ConstraintInterpreter(ArrayList<String> exps){
        Stack<Expression> expStack = new Stack<>();

        //buduj stos i twórz drzewo
        for(String exp:exps){
            Expression right;
            Expression left;
            switch(exp){
                case "||":
                    expStack.push(new Abs(expStack.pop()));
                    break;
                case "+":
                    right = expStack.pop();
                    left = expStack.pop();
                    expStack.push(new Add(left, right));
                    break;
                case "-":
                    right = expStack.pop();
                    left = expStack.pop();
                    expStack.push(new Substract(left, right));
                    break;
                case "*":
                    right = expStack.pop();
                    left = expStack.pop();
                    expStack.push(new Product(left, right));
                    break;
                case "=":
                    right = expStack.pop();
                    left = expStack.pop();
                    expStack.push(new Equal(left, right));
                    break;
                case "<>":
                    right = expStack.pop();
                    left = expStack.pop();
                    expStack.push(new NotEqual(left, right));
                    break;
                case ">":
                    right = expStack.pop();
                    left = expStack.pop();
                    expStack.push(new More(left, right));
                    break;
                case "<":
                    right = expStack.pop();
                    left = expStack.pop();
                    expStack.push(new Less(left, right));
                    break;
                case "rozne":
                    int numParams = expStack.pop().interpret(null);
                    ArrayList<Expression> diffList = new ArrayList<>();
                    while(numParams!=0){
                        diffList.add(expStack.pop());
                        numParams--;
                    }
                    expStack.push(new Different(diffList));
                    break;
                default:
                    pushVarOrConst(exp, expStack);
            }
        }
        tree = expStack.pop();
    }

    private void pushVarOrConst(String exp, Stack<Expression> stack) {
        try{
            int num = Integer.parseInt(exp);
            stack.push(new IntegerValue(num));
        } catch (NumberFormatException nfe) {
            stack.push(new VariableHolder(exp));
        }
    }

    @Override
    public Integer interpret(ArrayList<Variable> variables) {
        return tree.interpret(variables);
    }
}
