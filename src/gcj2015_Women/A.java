/**
 Problem A. I/O Error
 Problem

 Our computers are so excited about the upcoming Google I/O that they've started storing their ones as capital letter Is and their zeroes as capital letter Os! For example, the character A, which is 65 in ASCII, would normally be stored as the byte 01000001, but our computers are storing it as OIOOOOOI.

 Given a string of 8-character "bytes" consisting of Is and Os, can you translate it using ASCII? Every "byte" is guaranteed to translate to a printable character (a decimal value between 32 and 126, inclusive). Note that one of these characters (the one with decimal value 32) is a space. No translated message will begin or end with a space, but there may be internal space characters.

 Solving this problem

 Usually, Google Code Jam problems have 1 Small input and 1 Large input. This problem has only 1 Small input. Once you have solved the Small input, you have finished solving this problem.

 Input

 The first line of the input gives the number of test cases, T. T test cases follow; each consists of two lines. The first line of each test case contains an integer representing the number B of "bytes" in the string to be translated. The second line of each test case contains 8 * B characters, all of which are either I or O.

 Output

 For each test case, output one line containing "Case #x: y", where x is the test case number (starting from 1) and y is the translated message.

 Limits

 Small dataset

 1 ≤ T ≤ 100.
 1 ≤ B ≤ 1000.
 Sample


 Input

 2
 2
 OIOOIIIIOIOOIOII
 21
 OIOOIOOIOOIOOOOOOOIOOIIIOOIIIIOOOOIIOOIIOOIOOIIIOOIOOOOOOOIOOOIOOIOOOOIIOOIIOOOOOIIOOIOOOOIIOOIIOOIOOOOOOIOOIOIOOOIIOIOOOIIOIIOIOOIOOOIOOOIOOOOIOOIOOOOOOOIIIOIOOOIOIOOI


 Output

 Case #1: OK
 Case #2: I '<3' "C0d3 J4m"! :)

 */
package gcj2015_Women;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class A {

    static Scanner in;
    static String roundName = "gcj2015_Women";
    static String taskname = "A-small-practice";

    public static String solve() {
        int B = in.nextInt();
        String s = in.next().replace("O", "0").replace("I", "1");

        return new String(new BigInteger(s,2).toByteArray());
    }

    public static void main(String[] args) {

        try {
            PrintWriter pW = new PrintWriter(new FileOutputStream("io/" + roundName + "/output/"
                    + taskname + ".out"));
            try {
                in = new Scanner(new FileInputStream("io/" + roundName + "/input/"
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

