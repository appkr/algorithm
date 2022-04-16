package dev.appkr.algorithm.search;

import java.util.concurrent.atomic.AtomicInteger;

public class LinearSearch {

  static AtomicInteger counter = new AtomicInteger(0);

  public static void main(String[] args) {
    final String haystack = "abcdefghijklmnopqrstuvwxyz";
    System.out.println(search(haystack, "w"));
    System.out.println("counter=" + counter.get());
  }

  static int search(String haystack, String q) {
    final int length = haystack.length();
    for (int i = 0; i < length; i++) {
      counter.incrementAndGet();
      if (haystack.charAt(i) == q.charAt(0)) {
        return i;
      }
    }

    return -1;
  }
}
