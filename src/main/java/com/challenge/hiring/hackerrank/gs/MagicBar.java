package com.challenge.hiring.hackerrank.gs;

import java.util.ArrayList;
import java.util.List;

/*
 * Place the given numbers on a bar such that the left and right sides are balanced within a margin of error. The left
 * side of the bar adds 1kg for each weight placed on the left.
 */
public class MagicBar {

  public static void main(String[] args) {
    System.out.println(getOutcomeOfTheFeat(new int[] {6, 2, 1, 4, 3, 5}, 1));
    System.out.println(getOutcomeOfTheFeat(new int[] {20, 10, 4, 50, 100}, 20));
  }

  static String getOutcomeOfTheFeat(int[] weights, int marginOfError) {

    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    int sum = 0;
    for (int n : weights) {
      right.add(n);
      sum += n;
    }
    return getBalance(left, right, marginOfError, sum, 0, sum);
  }

  public static String getBalance(List<Integer> left, List<Integer> right, int marginOfError, int sum, int sumLeft,
      int sumRight) {
    if (sumLeft + left.size() == sumRight) {
      return "Perfectly Balanced";
    } else if (Math.abs(sumLeft + left.size() - sumRight) < marginOfError) {
      return "Balanced within " + Math.abs(sumLeft + left.size() - sumRight);
    }

    if (sumLeft > sumRight) {
      for (Integer e : left) {
        // if (e <= sumLeft + left.size() - sumRight) {
        List<Integer> l = new ArrayList<>(left);
        l.remove(e);
        List<Integer> r = new ArrayList<>(right);
        r.add(e);
        return getBalance(l, r, marginOfError, sum, sumLeft - e, sumRight + e);

        // }
      }
    } else {
      for (Integer e : right) {
        // if (e <= sumRight - sumLeft - left.size()) {
        List<Integer> l = new ArrayList<>(left);
        l.add(e);
        List<Integer> r = new ArrayList<>(right);
        r.remove(e);
        return getBalance(l, r, marginOfError, sum, sumLeft + e, sumRight - e);
        // }
      }
    }
    return "";

  }
}
