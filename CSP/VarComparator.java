package CSP;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-27.
 */
public class VarComparator implements Comparator<Variable>{

    @Override
    public int compare(Variable o1, Variable o2) {
        return o1.compareTo(o2);
    }
}
