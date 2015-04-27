package CSP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-25.
 */
public class Variable implements Comparable<Variable>{
    private String name;

    private ArrayList<Integer> domain;
    private ArrayList<Integer> changingDomain;
    private ArrayList<Integer> constraints;
    private Integer value;

   /* public Variable(ArrayList<Integer> domain)
    {
        this.domain = domain;
        restoreDomain();
    }*/

    public Variable(String name, ArrayList<Integer> domain) {
        this.domain = domain;
        restoreDomain();
        this.name = name;
    }
    public ArrayList<Integer> getConstraints() {
        return constraints;
    }

    public String getName() {
        return name;
    }

    private void restoreDomain() {
        this.changingDomain = new ArrayList<>();
        for(Integer integer:domain)
            changingDomain.add(new Integer(integer));
    }

    public void setDomain(ArrayList<Integer> domain)
    {
        this.domain = domain;
    }

    public void setChangingDomain(ArrayList<Integer> domain)
    {
        this.changingDomain = domain;
    }

    public ArrayList<Integer> getDomain()
    {
        return domain;
    }
    public ArrayList<Integer> getChangingDomain()
    {
        return changingDomain;
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
        boolean isLast = changingDomain.get(changingDomain.size()-1).equals(value);
        boolean isLast2 = changingDomain.get(changingDomain.size()-1) == (value);
        return (this.value==null && this.changingDomain.size() > 0) ||
                (this.value != null && !this.value.equals(this.changingDomain.get(this.changingDomain.size()-1)));
    }

    public void setNextValue()
    {
        this.value = this.changingDomain.get(this.changingDomain.indexOf(value)+1);
    }

    public void bindConstraints(ArrayList<Integer> integers) {
        constraints = integers;
    }

    public void reset() {
        value = null;
    }

    @Override
    public int compareTo(Variable v){
        if(v.changingDomain.size() < changingDomain.size())
            return 1;
        else if(v.changingDomain.size() > changingDomain.size())
            return -1;
        else
            return 0;
    }

}
