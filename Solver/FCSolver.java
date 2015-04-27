package Solver;

import CSP.CSPParser;
import CSP.Variable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-17.
 */
public class FCSolver implements Solver{
    int numSolutions;
    CSPParser cspp;
    ArrayList<HashMap<String, Integer>> allResults;
    HashMap<String, ArrayList<Integer>> preCutDoms;


    public FCSolver(CSPParser cspp) {
        this.cspp = cspp;
        allResults = new ArrayList<>();
    }

    public boolean solveOne(){
        return solveOneR(-1);
    }

    private boolean solveOneR(int depth){
        depth++;
        Variable var = cspp.getVarsList().get(depth);
        preCutDoms = backupDomains();
        while(var.hasMoreValues()){
            var.setNextValue();

            if(isAllowed(var)){
                if(depth == cspp.getVarsList().size()-1) { //uda³o siê
                    write1Result();
                    return true;
                } else {
                    if(cutFromDomains(depth)) {
                        sortVariables();
                        if (solveOneR(depth))
                            return true;
                    }
                }
            }
        }
        restoreDomains();
        var.reset();

        return false;
    }

    private void restoreDomains() {
        for(Variable var : cspp.getVarsList()){
            var.setChangingDomain(preCutDoms.get(var.getName()));
        }
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
        preCutDoms = backupDomains();

        while(var.hasMoreValues()){
            var.setNextValue();

            if(isAllowed(var)){
                if(depth == cspp.getVarsList().size()-1) { //uda³o siê
                    if(write)
                        write1Result();
                    System.out.println(numSolutions++);
                } else {
                    if(cutFromDomains(depth)) {
                        //sortVariables();
                        solveFullR(depth, write);
                    }
                }
            }
        }
        restoreDomains();
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

    private void sortVariables() {
        cspp.sortVariables();
    }

    private boolean cutFromDomains(int depth) {
        boolean allFull = true;
        //backup
        HashMap<String, ArrayList<Integer>> tempDomains = backupDomains();


        //wycinanie
        int failedIndex = tempDomains.size()-1;

        for(int i = depth+1; i<cspp.getVarsList().size() && allFull; i++){
            Variable var = cspp.getVarsList().get(i);

            ArrayList<Integer> changingDomain = var.getChangingDomain();
            int size = changingDomain.size();
            for(int j = 0; j < size; j++){
                var.setValue(changingDomain.get(j));
                if(!isAllowed(var)){
                    var.reset();
                    changingDomain.remove(j);
                    size--;
                    j--;
                }
            }
            var.reset();

            allFull = changingDomain.size()!=0;
        }
        //przywracanie
        if(!allFull) {
            for(int i = depth+1; i <= failedIndex; i++){
                Variable var = cspp.getVarsList().get(i);
                var.setChangingDomain(tempDomains.get(var.getName()));
            }
        }
        return allFull;
    }

    private HashMap<String, ArrayList<Integer>> backupDomains() {
        HashMap<String, ArrayList<Integer>> result = new HashMap<>();
        for(Variable var: cspp.getVarsList()) {
            ArrayList<Integer> dom = new ArrayList<>();
            for(Integer in:var.getChangingDomain()){
                dom.add(new Integer(in));
            }

            result.put(var.getName(), dom);
        }
        return result;
    }
}


