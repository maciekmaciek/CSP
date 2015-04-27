package CSP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-25.
 */
public class Variable {
    private ArrayList<Integer> domain;

    public ArrayList<Integer> getConstraints() {
        return constraints;
    }

    private ArrayList<Integer> constraints;
    private Integer value;

    public Variable(ArrayList<Integer> domain)
    {
        this.domain = domain;
    }

    public void setDomain(ArrayList<Integer> domain)
    {
        this.domain = domain;
    }

    public List<Integer> getDomain()
    {
        return domain;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public boolean hasValue()
    {
        return this.value!=null;
    }

    public boolean hasMoreValues()
    {
        return (this.value==null && this.domain.size() > 0) || (this.value != null && this.value != this.domain.get(this.domain.size()-1));
    }

    public void setNextValue()
    {
        this.value = this.domain.get(this.domain.indexOf(value)+1);
    }

    public void bindConstraints(ArrayList<Integer> integers) {
        constraints = integers;
    }

    public void reset() {
        value = null;
    }
}
