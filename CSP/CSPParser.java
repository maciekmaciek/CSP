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
    private HashMap<String,Variable> vars;
    private ArrayList<ConstraintInterpreter> cons;
    public CSPParser(File file){
        this.file = file;
        vars = new HashMap<>();
        cons = new ArrayList<ConstraintInterpreter>();
        prepare();
    }

    private void prepare() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<String> varList =new ArrayList<>();
            String[] arr;
            varList.addAll(Arrays.asList(br.readLine().split(" ")));
            for (String var : varList) {
                ArrayList<Integer> al = new ArrayList<Integer>();
                arr = br.readLine().split(" ");
                for(String s:arr)
                    al.add(Integer.parseInt(s));
                vars.put(var, new Variable(al));
            }
            String line;
            while((line = br.readLine())!=null){
                cons.add(new ConstraintInterpreter(new ArrayList<String>(Arrays.asList(line.split(" ")))));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public HashMap<String, Variable> getVars() {
        return vars;
    }


    public ArrayList<ConstraintInterpreter> getCons() {
        return cons;
    }
}
