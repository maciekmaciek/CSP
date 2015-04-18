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

        return false;
    }
}
