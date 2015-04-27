package CSP;

import Interpreter.ConstraintInterpreter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-04-17.
 */
public class CSPParser {

    private File file;
    private ArrayList<Variable>varList;
    private ArrayList<ArrayList<Integer>> varsCons;
    //private HashMap<String,Variable> vars;
    private ArrayList<ConstraintInterpreter> cons;
    private VarComparator vc;

    public CSPParser(File file){
        this.file = file;
        //vars = new HashMap<>();
        cons = new ArrayList<ConstraintInterpreter>();
        varList = new ArrayList<>();
        varsCons = new ArrayList<>();
        vc = new VarComparator();
        prepare();
    }

    private void prepare() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String[] arr;
            String[] vararr = br.readLine().split(" ");
            for (String var : vararr) {
                ArrayList<Integer> al = new ArrayList<Integer>();
                varsCons.add(new ArrayList<>());
                arr = br.readLine().split(" ");
                for(String s:arr)
                    al.add(Integer.parseInt(s));
                varList.add(new Variable(var, al));
            }
            String line;
            while((line = br.readLine())!=null){
                ArrayList<String> tokens = new ArrayList<>(Arrays.asList(line.split(" ")));
                cons.add(new ConstraintInterpreter(tokens));
                for(int i = 0; i< varList.size(); i++)  //wi¹¿e ograniczenia ze zmiennymi
                    if(tokens.contains(varList.get(i).getName()))
                        varsCons.get(i).add(cons.size()-1);

                for(int i = 0; i< varList.size(); i++){
                    varList.get(i).bindConstraints(varsCons.get(i));
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    /*public HashMap<String, Variable> getVars() {
        return vars;
    }
*/

    public ArrayList<ConstraintInterpreter> getCons() {
        return cons;
    }

    public ArrayList<Variable> getVarsList() {
        return varList;
    }

    public void sortVariables() {
        Collections.sort(varList, vc);
    }
}
