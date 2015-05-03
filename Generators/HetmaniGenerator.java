package Generators;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-05-03.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.nio.file.*;
public class HetmaniGenerator {


    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Ilu Hetmanów: ");
        int n = reader.nextInt();

        StringBuffer sBuf = new StringBuffer();
        zmienne(sBuf, n);
        dziedziny(sBuf, n);
        ograniczenia(sBuf, n);

        try {
            Files.write(Paths.get(System.getProperty("user.dir") + "\\src\\main\\java\\ProblemSamples\\Hetmany.Txt"), sBuf.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zmienne(StringBuffer buf, int n) {
        for (int i = 0; i < n; i++) {
            buf.append("H").append(i).append(" ");
        }
        buf.append("\n");
    }

    private static void dziedziny(StringBuffer buf, int n) {
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                buf.append(j).append(" ");
            }
            buf.append("\n");
        }
    }

    private static void ograniczenia(StringBuffer buf, int n) {
        //liniowe
        for(int i = 0;i < n;i++) {
            for(int j = i+1;j < n;j++) {
                buf.append("H").append(i).append(" ").append("H").append(j).append(" <> ").append('\n');
            }
        }

        //ukoœne
        for(int i = 0;i < n;i++) {
            //if(i!=0) //pierwszy to wie¿a
            for(int j = i+1;j < n;j++) {
            //for(int j = i+1;j < n-1;j++) { //ostatni to wie¿a
                buf.append("H").append(i).append(" ").append("H").append(j).append(" - ").append("|| ");
                buf.append(i).append(" ").append(j).append(" - ").append("||");
                buf.append(" <> ").append('\n');
            }
        }
    }

}
