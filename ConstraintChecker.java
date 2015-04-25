import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-18.
 */
public final class ConstraintChecker {
    private Stack<String> stack;
    private String[] elements;
    private final static ConstraintChecker instance = new ConstraintChecker();
    public static ConstraintChecker getInstance() {
        return instance;
    }

    private ConstraintChecker() {
        stack = new Stack<>();
    }

    public boolean check(String con, HashMap<String, Integer> values){
        stack.clear();
        elements = con.split(" ");
        for(String elem: elements){
            if(!isOperator(elem)){
                stack.push(elem);
            } else {
                treatOperator(elem);
            }
        }
        return Boolean.parseBoolean(stack.pop());
    }

    private void treatOperator(String elem) {
        int[] taken;
        switch(elem){
            case "+":
                taken = take2();
                break;
        }
    }

    private int[] take2() {
        return new int[0];
    }

    private boolean isOperator(String elem) {
        return false;

    }
}
