package gcj2015_Woman;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class C {

    static Scanner in;
//    static String taskname = "C-small";
//    static String taskname = "C-small-attempt0";
//    static String taskname = "C-small-attempt1";
    static String taskname = "C-large";

    static int[] multifactorial = new int[9001];

    public static String solve() {
        int D = in.nextInt();
        if ( D < 5 ) return "...";
        if ( D > 31682 ) return "IT'S OVER 9000!";
        //int number_of_exclamation = 1;


        int j_min = 1;
        int j_max = 8999;
        int j_middle = (j_max + j_min) / 2;
        int bestCheck  = isBest(j_middle, D);
        //System.out.println(D + " " + j_min + " " + j_middle + " " + j_max + " " + bestCheck);

        int j = 1;
        while ( D <= multifactorial[j] ) j++;

//        while ( bestCheck != 1) {
//            if ( bestCheck == -2) j_min = j_middle;
//            else j_max = j_middle;
//            j_middle = (j_max + j_min) / 2;
//
//            if ( j_min >= j_max || multifactorial[j_min] == multifactorial[j_middle]) {
//                System.out.println("Trololo: D= " + D + "; j_max=" + j_max + "; j_min=" + j_min + "; j_middle= " + j_middle + "; " +   multifactorial[j_min] + " " + multifactorial[j_max]);
//                break;
//            }
//
//            bestCheck  = isBest(j_middle, D);
//            System.out.println( D + "; j_max=" + j_max + "; j_min=" + j_min + "; j_middle= " + j_middle + "; " +   multifactorial[j_min] + " " + multifactorial[j_middle]);
//        }

        String result = "IT'S OVER 9000";
        for(int i=0; i < j; i++) {
            result += "!";
        }

        return result;
    }

    public static int isBest( int j, int D ) {

        if (multifactorial[j] < D &&  D <= multifactorial[j-1] ) return 1;

        if (multifactorial[j] >= D) return -2;

        return -1;
    }

    public static int getMultyfactorial(int f) {
        BigInteger fact = new BigInteger("1");
        for( int j=9000; j > 0; j-=f) {
            fact = fact.multiply(new BigInteger("" + j));
        }
        String  s = "" + fact;
        return s.length();
    }

    public static void main(String[] args) {
        //multifactorial[0] = 4;
        for(int i=1; i < 9001; i++) {
            multifactorial[i] = getMultyfactorial(i);
           // System.out.println(i + ": " + multifactorial[i]);
        }
        //System.out.println(multifactorial[24]);


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

