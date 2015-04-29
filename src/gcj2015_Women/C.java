/*
Problem C. Power Levels

Problem

A multifactorial -- that is, a number N followed by some nonzero number E of exclamation points -- is defined as the product of all positive numbers (N - K*E) for which K is a nonnegative integer. Normal factorials meet the definition of multifactorials, for example:

5! = 5 * (5-1) * (5-2) * (5-3) * (5-4) = 120

Here are the other multifactorials of 5:

5!! equals 5 * (5-2) * (5-4) = 15

5!!! equals 5 * (5-3) = 10

5!!!! equals 5 * (5-4) = 5

5 followed by five or more !s = 5

5 with no exclamation points is not considered a multifactorial.

The villainous Anima and her underling Minera love three things: multifactorials, yelling "IT'S OVER 9000" followed by some number of exclamation points, and going around the universe looking for people to fight.

When Anima and Minera encounter a potential opponent, Anima asks Minera to use her scanner device to determine the opponent's power level, which is always a positive integer that does not begin with any leading zeroes. Today, the display on Minera's scanner is blurry, and she can only tell Anima the number of digits D in the opponent's power level, and not what any of those digits are.

Anima wants to yell IT'S OVER followed by a multifactorial of 9000 to accurately describe the opponent's power level. She will never yell something that might not be true, and she will never use more exclamation points than she needs to. For example, if D = 31682, Anima can't yell IT'S OVER 9000!, because she knows that 9000! also has 31682 digits and the opponent's power level might be a 31682-digit number that is less than or equal to 9000!. However, since 9000!! has fewer than 31682 digits, she can be confident that the opponent's power level is greater than 9000!!, so IT'S OVER 9000!! is guaranteed to be true. Although the opponent's power level is also definitely greater than 9000!!!, 9000!!!!, and so on, she won't use more exclamation points than she needs to. So, in this example, she will yell IT'S OVER 9000!!

If there is no multifactorial of 9000 that is definitely less than the opponent's power level, Anima will remain dramatically silent. We represent dramatic silence as an ellipsis: ...

What should Anima say?

Input

The first line of the input gives the number of test cases, T. T lines follow. Each contains a positive integer D, the number of digits in an opponent's power level.

Output

For each test case, output one line containing "Case #x: y", where x is the test case number (starting from 1) and y is either ... if Anima must remain silent, or IT'S OVER 9000 followed by some positive number of exclamation points. Make sure your output exactly matches these specifications. You may wish to copy our apostrophe character into your code to avoid possible Unicode issues.

Limits

Small dataset

T = 19.
1 ≤ D ≤ 19.
Large dataset

1 ≤ T ≤ 100.
1 ≤ D ≤ 100000.
Sample


Input

5
1
19
206
31682
31683


Output

Case #1: ...
Case #2: IT'S OVER 9000!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Case #3: IT'S OVER 9000!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Case #4: IT'S OVER 9000!!
Case #5: IT'S OVER 9000!


Note that sample cases 3 through 5 are outside the range of the Small data set.

In Case #1, Anima knows that all multifactorials of 9000 are at least 9000, so the opponent's single-digit power level, whatever it is, can't exceed any of them.

The output for Case #2, which is the largest possible input for the Small dataset, has 1990 exclamation points, in case you don't wish to count them.

In Case #3, both 9000 with 156 exclamation points and 9000 with 157 exclamation points have 205 digits, whereas 9000 with 155 exclamation points has 207 digits. Anima could make the claim with either 156 or 157, but she always chooses as few exclamation points as possible. This output has 156 exclamation points.

*/

package gcj2015_Women;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class C {

    static Scanner in;
    static String roundName = "gcj2015_Women";

//    static String taskname = "C-small";
//    static String taskname = "C-small-practice";
    static String taskname = "C-large-practice";

    static int[] multifactorial = new int[9001];

    public static String solve() {
        int D = in.nextInt();
        if ( D < 5 ) return "...";
        if ( D > 31682 ) {
            return "IT'S OVER 9000!";
        }

        int j_min = 1;
        int j_max = 8999;
        int j_middle = (j_max + j_min) / 2;
        int bestCheck  = isBest(j_middle, D);

        int j = 1;
        while ( D <= multifactorial[j] ) j++;

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
        for(int i=1; i < 9001; i++) {
            multifactorial[i] = getMultyfactorial(i);
        }

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

