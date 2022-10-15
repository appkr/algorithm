package dev.appkr.algorithm.search;

public class LinearSearchKata {

  public static void main(String[] args) {
    final String haystack = "abcdefghijklmnopqrstuvwxyz";
    System.out.println(search(haystack, "a"));
    System.out.println(search(haystack, "b"));
    System.out.println(search(haystack, "c"));
    System.out.println(search(haystack, "W"));
    System.out.println(search(haystack, "w"));
  }

  static int search(String haystack, String q) {
    for (int i = 0; i < haystack.length(); i++) {
      if (haystack.charAt(i) == q.charAt(0)) {
        return i;
      }
    }

    return -1;
  }
}
