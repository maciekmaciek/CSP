import CSP.CSPParser;
import Solver.BTSolver;
import Solver.FCSolver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-17.
 */
public class Main {
    public static void main(String[] args){
        //CSPParser cspp = new CSPParser(new File(System.getProperty("user.dir")+"\\src\\main\\java\\ProblemSamples\\Sudoku3d.Txt"));
        CSPParser cspp = new CSPParser(new File(System.getProperty("user.dir")+"\\src\\main\\java\\ProblemSamples\\Hetmany.Txt"));
        //CSPParser cspp = new CSPParser(new File(System.getProperty("user.dir")+"\\src\\main\\java\\ProblemSamples\\Sudoku.Txt"));
        //CSPParser cspp = new CSPParser(new File(System.getProperty("user.dir")+"\\src\\main\\java\\ProblemSamples\\BasicProblem.Txt"));
        BTSolver bts = new BTSolver(cspp);
        FCSolver fcs = new FCSolver(cspp);

//        bts.solveFull(true);
        for(HashMap<String, Integer> hm : bts.getAllSolutions()){
            for(Map.Entry<String, Integer> me : hm.entrySet()){
                System.out.print(me.getKey() + ": " + me.getValue() + "\t");
            }
            System.out.println();
        }
        fcs.solveFull(true);
        //fcs.solveOne();
        for(HashMap<String, Integer> hm : fcs.getAllSolutions()){
            for(Map.Entry<String, Integer> me : hm.entrySet()){
                System.out.print(me.getKey() + ": " + me.getValue() + "\t");
            }
            System.out.println();
        }
        System.out.println(bts.getNumSolutions());
        System.out.println(fcs.getNumSolutions());
    }
}
