package com.challenge.hiring.hackerrank.gs;

import java.util.HashMap;
import java.util.Map;

/*
 * Class to find the largest (prime/non prime) number which occurs prime number of times.
 */
public class CountLargestPrime {

  public static void main(String[] args) {
    // for (int i = 0; i < 100; i++) {
    // System.out.println("isprime " + i + " " + isPrime(i));
    // }
    System.out.println(getLargestNumberWithPrimeOccurences(new int[] {1, 11, 11, 11, 23, 11, 37, 51, 37, 37}, 2));
    System.out.println(getLargestNumberWithPrimeOccurences(new int[] {}, 2));
    System.out.println(getLargestNumberWithPrimeOccurences(new int[] {1, 2, 3}, 2));
    System.out.println(getLargestNumberWithPrimeOccurences(new int[] {1, 2, 3}, 0));
    System.out.println(getLargestNumberWithPrimeOccurences(new int[] {1, 11, 11, 11, 37, 11, 37, 37, 37, 37}, 2));
  }

  static int getLargestNumberWithPrimeOccurences(int[] inputArray, int minOccurence) {
    int largestElement = -1;
    int occurances = 0;

    Map<Integer, Integer> countMap = new HashMap<>();
    for (int i = 0; i < inputArray.length; i++) {
      if (countMap.containsKey(inputArray[i])) {
        countMap.put(inputArray[i], countMap.get(inputArray[i]) + 1);
      } else {
        countMap.put(inputArray[i], 1);
      }
    }

    for (Integer key : countMap.keySet()) {
      Integer value = countMap.get(key);
      if (value >= minOccurence && key > largestElement && isPrime(value)) {
        largestElement = key;
        occurances = value;
      }
    }
    System.out.println(occurances);
    return largestElement;

  }

  public static boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

}
