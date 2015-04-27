import CSP.CSPParser;
import Solver.BTSolver;

import java.io.File;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-17.
 */
public class Main {
    public static void main(String[] args){
        //CSPParser cspp = new CSPParser(new File(System.getProperty("user.dir")+"\\src\\main\\java\\ProblemSamples\\BasicProblem.Txt"));
        //CSPParser cspp = new CSPParser(new File(System.getProperty("user.dir")+"\\src\\main\\java\\ProblemSamples\\Hetmany.Txt"));
        CSPParser cspp = new CSPParser(new File(System.getProperty("user.dir")+"\\src\\main\\java\\ProblemSamples\\Sudoku.Txt"));
        BTSolver bts = new BTSolver(cspp);
        bts.solveFull(false);
        System.out.println(bts.getNumSolutions());
    }
}
