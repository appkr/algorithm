package dev.appkr.algorithm.search;

import java.util.concurrent.atomic.AtomicInteger;

public class BinarySearch {

  static AtomicInteger counter = new AtomicInteger(0);

  public static void main(String[] args) {
    final String haystack = "abcdefghijklmnopqrstuvwxyz";
    System.out.println(search(haystack, "w"));
    System.out.println("counter=" + counter.get());
  }

  static int search(String haystack, String needle) {
    int left = 0, right = haystack.length();
    while (left < right) {
      counter.incrementAndGet();
      int middle = ((right - left) / 2) + left;

      char a = needle.charAt(0),  b = haystack.charAt(middle);
      if (a == b) {
        return middle;
      }

      if (a < b) {
        right = middle + 1;
      } else {
        left = middle - 1;
      }
    }

    return -1;
  }
}
