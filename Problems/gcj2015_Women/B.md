Problem B. Dreary Design

Problem

One way to represent a color is as a triple of component values (each of which can range from 0 to K, inclusive) representing levels of red, green, and blue. For example, in the color system where K = 3, (0, 2, 3) and (0, 3, 2) would be two of the possible distinct colors.

We will consider a color to be bland if and only if all pairs of its component values differ by no more than V. For example, in a system with K = 2 and V = 1, the color (2, 1, 1) is bland, because its red and green components differ by 1, its red and blue components differ by 1, and its green and blue components differ by 0, and none of these differences exceeds 1. But (2, 1, 0) is not bland, because the red and blue components differ by more than 1.

Mr. Turner loves to create gloomy landscape images and wants to design a color system in which there are many bland colors available. Given values for K and V, can you tell him how many distinct bland colors are there?

Solving this problem

Usually, Google Code Jam problems have 1 Small input and 1 Large input. This problem has 1 Small input and 2 Large inputs. Once you have solved the Small input, you will be able to download any of the two Large inputs. As usual, you will be able to retry the Small input (with a time penalty), while you will get only one chance at each of the Large inputs.

Input

The first line of the input gives the number of test cases, T. T lines follow. Each contains two space-separated integers K and V.

Output

For each test case, output one line containing "Case #x: y", where x is the test case number (starting from 1) and y is the number of distinct bland colors.

Limits

1 ≤ T ≤ 100.
V ≤ K.

Small dataset

0 ≤ K ≤ 255.
0 ≤ V ≤ 100.
All answers are guaranteed to fit in a 32-bit signed integer.
First large dataset

0 ≤ K ≤ 2,555.
0 ≤ V ≤ 555.
All answers are guaranteed to fit in a 32-bit signed integer.
Second large dataset

0 ≤ K ≤ 2,000,000,000.
0 ≤ V ≤ 1,000.
All answers are guaranteed to fit in a 64-bit signed integer.
Sample


Input

4
1 1
1 0
255 0
0 0

Output

Case #1: 8
Case #2: 2
Case #3: 256
Case #4: 1

In Case #1, there are eight possible colors -- (0, 0, 0), (0, 0, 1), (0, 1, 0), (0, 1, 1), (1, 0, 0), (1, 0, 1), (1, 1, 0), and (1, 1, 1) -- and all of them meet the definition of bland for V = 1.

In Case #2, the same eight colors are possible, but only two of them -- (0, 0, 0) and (1, 1, 1) -- meet the definition of bland for V = 0.