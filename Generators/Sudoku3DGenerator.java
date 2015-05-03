package Generators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Maciej Wolañski
 * maciekwski@gmail.com
 * on 2015-05-03.
 */
public class Sudoku3DGenerator {
    public static void main(String[] args) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\main\\java\\ProblemSamples\\Sudoku3D.txt"));
            Scanner reader = new Scanner(System.in);
            System.out.println("Podaj N, N=n^2: ");
            int n = reader.nextInt();

            StringBuffer sBuf = new StringBuffer();

            zmienne(sBuf, n);
            dziedziny(sBuf, n);
            ograniczenia(sBuf, n);
            bw.write(sBuf.toString());
            sBuf.setLength(0);
            sBuf = ograniczeniaXY(n);
            bw.write(sBuf.toString());
            sBuf.setLength(0);

            sBuf = ograniczeniaXZ(n);
            bw.write(sBuf.toString());
            sBuf.setLength(0);

            sBuf = ograniczeniaZY(n);
            bw.write(sBuf.toString());


            System.out.println("Podawanie wartoœci:");
            System.out.println("Ustalic zmienna? t/n");
            String end = reader.next();
            sBuf.setLength(0);
            while (end.equals("t")) {
                System.out.println("Adres g³êbokoœæ-rz¹d-kolumna np. 504");
                reader = new Scanner(System.in);
                String location = reader.next();
                System.out.println("Podaj wartoœæ [0,N) ");
                n = reader.nextInt();
                sBuf.append("P").append(location).append(" ").append(n).append(" ").append("=").append("\n");
                System.out.println("Kontynuowac? t/n");
                end = reader.next();
            }
            bw.write(sBuf.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void zmienne(StringBuffer buf, int n) {
        for (int h = 0; h < n; h++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    buf.append("P").append(h).append(i).append(j).append(" ");
                }
            }
        }
        buf.append("\n");
    }

    private static void dziedziny(StringBuffer buf, int n) {
        for (int h = 0; h < n; h++) {
            for (int i = 0; i < n * n; i++) {
                for (int j = 0; j < n; j++) {
                    buf.append(j).append(" ");
                }
                buf.append("\n");
            }
        }
    }

    private static void ograniczenia(StringBuffer buf, int n) {
        //rzedy
        for (int h = 0; h < n; h++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    buf.append("P").append(h).append(i).append(j).append(" ");
                }
                buf.append(n).append(" ").append("rozne").append("\n");
            }
        }


        //kolumny
        for (int h = 0; h < n; h++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    buf.append("P").append(h).append(j).append(i).append(" ");
                }
                buf.append(n).append(" ").append("rozne").append("\n");
            }
        }
    }

    private static StringBuffer ograniczeniaXY(int n) {
        int w = (int) Math.sqrt(n);
        StringBuffer buf = new StringBuffer();
        //mniejsze kwadraty XY
        for (int z = 0; z < n; z++) {
            for (int x = 0; x < w; x++) {
                for (int y = 0; y < w; y++) {
                    for (int i = 0; i < n / w; i++) {
                        for (int j = 0; j < n / w; j++) {
                            buf.append("P").append(z).append((n / w) * x + j).append((n / w) * y + i).append(" ");
                        }
                    }
                    buf.append(n).append(" ").append("rozne").append("\n");
                }
            }
        }
       // buf.append("\n");
        return buf;
    }

    private static StringBuffer ograniczeniaXZ(int n) {
        int w = (int) Math.sqrt(n);
        StringBuffer buf = new StringBuffer();
        //mniejsze kwadraty XZ
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < w; x++) {
                for (int z = 0; z < w; z++) {
                    for (int i = 0; i < n / w; i++) {
                        for (int j = 0; j < n / w; j++) {
                            buf.append("P").append((n / w) * z + i).append((n / w) * x + j).append(y).append(" ");
                        }
                    }
                    buf.append(n).append(" ").append("rozne").append("\n");
                }
            }
        }
        //buf.append("\n");

        return buf;
    }

    private static StringBuffer ograniczeniaZY(int n) {
        int w = (int) Math.sqrt(n);
        StringBuffer buf = new StringBuffer();
        //mniejsze kwadraty ZY
        for (int x = 0; x < n; x++) {
            for (int z = 0; z < w; z++) {
                for (int y = 0; y < w; y++) {
                    for (int i = 0; i < n / w; i++) {
                        for (int j = 0; j < n / w; j++) {
                            buf.append("P").append((n / w) * z + j).append(x).append((n / w) * y + i).append(" ");
                        }
                    }
                    buf.append(n).append(" ").append("rozne").append("\n");
                }
            }
        }
        //buf.append("\n");

        return buf;
    }
}

