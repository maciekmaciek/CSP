package Solver;

import CSP.CSPParser;
import CSP.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-27.
 */
public interface Solver {

    public boolean solveOne();
    public void solveFull(boolean write);
    public int getNumSolutions();
    public ArrayList<HashMap<String, Integer>> getAllSolutions();
}
