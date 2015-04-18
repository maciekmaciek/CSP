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
    private ArrayList<String> vars;
    private HashMap<String,ArrayList<Integer>> doms;
    private ArrayList<String> cons;
    public CSPParser(File file){
        this.file = file;
        vars = new ArrayList<String>();
        doms = new HashMap<String, ArrayList<Integer>>();
        cons = new ArrayList<String>();
        prepare();
    }

    private void prepare() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String[] arr;
            vars.addAll(Arrays.asList(br.readLine().split(" ")));
            for (String var : vars) {
                ArrayList<Integer> al = new ArrayList<Integer>();
                arr = br.readLine().split(" ");
                for(String s:arr)
                    al.add(Integer.parseInt(s));

                doms.put(var, al);
            }
            String line;
            while((line = br.readLine())!=null){
                cons.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public ArrayList<String> getVars() {
        return vars;
    }

    public HashMap<String, ArrayList<Integer>> getDoms() {
        return doms;
    }

    public ArrayList<String> getCons() {
        return cons;
    }
}
