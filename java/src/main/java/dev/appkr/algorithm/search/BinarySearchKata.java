package dev.appkr.algorithm.search;

public class BinarySearchKata {

  public static void main(String[] args) {
    final String haystack = "abcdefghijklmnopqrstuvwxyz";
    System.out.println(search(haystack, "a"));
    System.out.println(search(haystack, "b"));
    System.out.println(search(haystack, "c"));
    System.out.println(search(haystack, "m"));
    System.out.println(search(haystack, "n"));
    System.out.println(search(haystack, "o"));
    System.out.println(search(haystack, "p"));
    System.out.println(search(haystack, "W"));
    System.out.println(search(haystack, "w"));
  }

  static int search(String haystack, String needle) {
    int left = 0, right = haystack.length() - 1;
    while (left < right) {
      int middle = (right + left) / 2;
      if (needle.charAt(0) < haystack.charAt(middle)) {
        right = middle;
      } else {
        left = middle;
      }

      if (needle.charAt(0) == haystack.charAt(middle)) {
        return middle;
      }
    }

    return -1;
  }
}
