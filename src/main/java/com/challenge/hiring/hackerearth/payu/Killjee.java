package com.challenge.hiring.hackerearth.payu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Killjee and subsets
 * Killjee is playing with an array a
 * , which has n
 * integers. He is trying to encrypt this array as a single integer.
 * Let l
 * be the largest number in array a. Then, the code for array a is ∑lj=0bj∗31j mod 109+7
 * .
 * Here, bj
 * is the size of largest subset of array a whose XOR is equal to j.If there exist no subset of array a whose XOR is j
 * then bj=0
 * .
 * INPUT CONSTRAINTS:
 * 1≤n≤104
 * 1≤ai≤103
 * INPUT FORMAT :
 * First line of input contains a single integer n
 * . Next line contains n space separated integers, elements of array a
 * .
 * OUTPUT FORMAT :
 * Print a single integer code of the array a
 * .
 * Sample Input
 * 4
 * 1 2 3 4
 * Sample Output
 * 3755653
 * Explanation
 * Here, b[0]=3
 * as the subset (1,2,3) has xor value equal to 0
 * .
 * b[1]
 * =2, as the subset (2,3) has xor value equal to 1
 * b[2]
 * = 2, as the subset (1,3) has xor value equal to 2
 * b[3]
 * =2, as the subset (1,2) has xor value equal to 3
 * b[4]
 * = 4, as the subset (1,2,3,4) has xor value equal to 0
 * .
 * Thus, the answer = (b[0]×310)+(b[1]×311)+(b[2]×312)+(b[3]×313)+(b[4]×314)
 * Modulo 109+7 = 3755653
 * .
 * Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to
 * pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem
 * statement.
 */
public class Killjee {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter wr = new PrintWriter(System.out);
    int n = Integer.parseInt(br.readLine().trim());
    String[] arr_a = br.readLine().split(" ");
    int[] a = new int[n];
    for (int i_a = 0; i_a < arr_a.length; i_a++) {
      a[i_a] = Integer.parseInt(arr_a[i_a]);
    }

    int out_ = solve(a);
    System.out.println(out_);

    wr.close();
    br.close();
  }

  static int solve(int[] a) {
    int largest = 0;
    int totalXor = 0;
    List<Integer> remaining = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      if (a[i] > largest) {
        largest = a[i];
      }
      totalXor = totalXor ^ a[i];
      remaining.add(a[i]);
    }
    Map<Integer, Integer> bMap = new ConcurrentHashMap<>();
    for (int i = 0; i <= largest; i++) {
      bMap.put(i, 0);
    }
    getBMap(bMap, totalXor, remaining, new ArrayList<>(), a.length);
    // for (int j = 0; j < a.length - 1; j++) {
    // int xor = a[j];
    // int size = 1;
    // if (bMap.containsKey(xor) && bMap.get(xor) < size) {
    // bMap.put(xor, size);
    // }
    // for (int k = j + 1; k < a.length; k++) {
    // size++;
    // xor = xor ^ a[k];
    // if (bMap.containsKey(xor) && bMap.get(xor) < size) {
    // bMap.put(xor, size);
    // }
    // }
    // }
    // System.out.println(bMap);
    Long output = 0l;
    for (int i = 0; i <= largest; i++) {
      output = output + new Double(bMap.get(i) * Math.pow(31, i)).longValue();
    }
    Long modulo = output % ((new Double(Math.pow(10, 9)).longValue()) + 7);

    return modulo.intValue();
  }

  public static void getBMap(Map<Integer, Integer> bMap, int totalXor, List<Integer> remaining, List<Integer> subset, int totalSize) {
    if (bMap.containsKey(totalXor) && bMap.get(totalXor) < (totalSize - subset.size())) {
      bMap.put(totalXor, (totalSize - subset.size()));
    }
    if (remaining.isEmpty())
      return;
    else {
      for (int i = 0; i < remaining.size(); i++) {
        Integer e = remaining.get(i);
        List<Integer> s = new ArrayList<>(subset);
        List<Integer> r = new ArrayList<>(remaining);

        s.add(e);
        r.remove(i);
        getBMap(bMap, totalXor ^ e, r, s, totalSize);
      }
    }
  }
}
