import CSP.CSPParser;
import Solver.BTSolver;
import Solver.FCSolver;

import java.io.File;

/**
 * Created by Maciej Wola�ski
 * maciekwski@gmail.com
 * on 2015-04-17.
 */
public class Main {
    public static void main(String[] args){
        //CSPParser cspp = new CSPParser(new File(System.getProperty("user.dir")+"\\src\\main\\java\\ProblemSamples\\Sudoku3d.Txt"));
        //CSPParser cspp = new CSPParser(new File(System.getProperty("user.dir")+"\\src\\main\\java\\ProblemSamples\\Hetmany.Txt"));
        //CSPParser cspp = new CSPParser(new File(System.getProperty("user.dir")+"\\src\\main\\java\\ProblemSamples\\Sudoku.Txt"));
        CSPParser cspp = new CSPParser(new File(System.getProperty("user.dir")+"\\src\\main\\java\\ProblemSamples\\BasicProblem.Txt"));
        BTSolver bts = new BTSolver(cspp);
        FCSolver fcs = new FCSolver(cspp);

        bts.solveFull(false);
        fcs.solveFull(false);
        System.out.println(bts.getNumSolutions());
        System.out.println(fcs.getNumSolutions());
    }
}
