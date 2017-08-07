package com.hackerearth.challenge.hiring.payu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Destroying Balls
 * There are N
 * balls in a row. The ith ball has color Ai
 * . You have to destroy all of the balls by using the following operation any number of times.
 * Operation: Let the current number of balls be k
 * . All the balls of color k
 * are destroyed at the same moment. Given the different scenarios, tell whether you will be able to destroy all the
 * balls or not.
 * Input Format:
 * First line contains t
 * , the number of test cases.
 * Each of the test case contains an integer N, the number of balls.
 * Next line contains N
 * space separated integers corresponding to the color of balls.
 * Output Format:
 * For each test case, print “YES”(without quotes) if all balls can be destroyed otherwise “NO”.
 * Constraints
 * 1≤t≤200
 * 1≤N≤1000
 * 1≤Ai≤1000000000
 * Sample Input
 * 1
 * 6
 * 1 3 3 6 6 6
 * Sample Output
 * YES
 * Explanation
 * Initially, there are 6
 * balls. Now, all balls having color equal to 6 are destroyed together at the same moment. Now, there are 3
 * balls remaining.
 * All balls having color equal to 3
 * are destroyed together at this moment. Now, there is only 1 ball remaining. All balls having color equal to 1
 * are destroyed together at this moment.
 * After this operation, all balls have been destroyed. Thus, the answer is yes.
 * Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to
 * pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem
 * statement.
 */
class DestroyingBalls {
  public static void main(String args[]) throws Exception {
    try (Scanner s = new Scanner(System.in)) {
      int t = s.nextInt();
      Map<Integer, Integer> countMap;
      while (t-- > 0) {
        int n = s.nextInt();
        int totalCount = n;
        countMap = new HashMap<>();
        while (n-- > 0) {
          int input = s.nextInt();
          if (countMap.containsKey(input)) {
            countMap.put(input, countMap.get(input) + 1);
          } else {
            countMap.put(input, 1);
          }
        }
        boolean result = totalCount > 0;
        while (totalCount > 0) {
          if (countMap.containsKey(totalCount)) {
            totalCount = totalCount - countMap.get(totalCount);
          } else {
            result = false;
            break;
          }
        }
        if (result) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }

      }
    }
  }
}
