package Solver;

import CSP.CSPParser;
import CSP.Variable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-25.
 */
public class BTSolver implements Solver{
    int numSolutions;
    CSPParser cspp;
    ArrayList<HashMap<String, Integer>> allResults;

    public BTSolver(CSPParser cspp) {
        this.cspp = cspp;
        allResults = new ArrayList<>();
    }

    public boolean solveOne(){
        return solveOneR(-1);
    }

    private boolean solveOneR(int depth){
        depth++;
        Variable var = cspp.getVarsList().get(depth);
        while(var.hasMoreValues()){
            var.setNextValue();

            if(isAllowed(var)){
                if(depth == cspp.getVarsList().size()-1) { //uda³o siê
                    write1Result();
                    return true;
                } else {
                    if(solveOneR(depth))
                        return true;
                }
            }
        }
        var.reset();
        return false;
    }

    private void write1Result() {
        allResults.add((extractResults()));
    }

    private HashMap<String, Integer> extractResults() {
        HashMap<String,Integer> result = new HashMap<>();
        for(Variable var : cspp.getVarsList()){
            result.put(var.getName(), var.getValue());
        }
       return result;
    }

    private void solveFullR(int depth, boolean write){
        depth++;
        Variable var = cspp.getVarsList().get(depth);
        while(var.hasMoreValues()){
            var.setNextValue();

            if(isAllowed(var)){
                if(depth == cspp.getVarsList().size()-1) { //uda³o siê
                    if(write)
                        write1Result();
                    System.out.println(++numSolutions);
                } else {
                    solveFullR(depth, write);
                }
            }
        }
        var.reset();
    }


    public void solveFull(boolean write){
        solveFullR(-1, write);
    }

    private boolean isAllowed(Variable var){
        boolean isAllowed = true;
        ArrayList<Integer> consIndexes = var.getConstraints();
        for(int i = 0 ; i < consIndexes.size() && isAllowed; i++){
            isAllowed = cspp.getCons().
                    get(consIndexes.get(i)).
                    interpret(cspp.getVarsList()) == 1;
        }
        return isAllowed;
    }

    @Override
    public int getNumSolutions() {
        return numSolutions;
    }

    @Override
    public ArrayList<HashMap<String, Integer>> getAllSolutions() {
        return allResults;
    }
}
