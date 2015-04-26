package gcj2015_Woman;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

    static Scanner in;
    //    static String taskname = "B-small";
    static String taskname = "B-large-practice-2";
//    static String taskname = "B-small-attempt0";
//    static String taskname = "B-small-attempt1";
//    static String taskname = "B-large";


    public static String solve() {
        long K = in.nextLong();
        long V = in.nextLong();
        return "" + ( K + 1 + V * (V + 1) * (3 * K - 2 * V + 2) );
    }

    public static void main(String[] args) {

        try {
            PrintWriter pW = new PrintWriter(new FileOutputStream("output/"
                    + taskname + ".out"));
            try {
                in = new Scanner(new FileInputStream("input/"
                        + taskname + ".in"));
                int T = in.nextInt();
                for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
                    pW.println("Case #" + caseNumber + ": " + solve());
                }
                in.close();
                pW.close();
            } catch (IOException e) {
                System.out.println("Can not find file " + taskname + ".in");
            }
        } catch (IOException e) {
            System.out.println("Open or create exception with "
                    + taskname + ".out");
        }
    }
}

