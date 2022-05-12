package dev.appkr.leetcode;

/**
 * Implement strStr().
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Constraints:
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack and needle consist of only lowercase English characters.
 */
public class Strstr {

  public static void main(String[] args) {
    String haystack = "hello";
    String needle = "ll";
    System.out.println(new Solution().strStr(haystack, needle));
  }

  static class Solution {
    public int strStr(String haystack, String needle) {
      int h = haystack.length();
      int n = needle.length();

      if (n == 0) {
        return 0;
      }

      if (n > h) {
        return -1;
      }

      for (int i = 0; i <= h - n; i++) {
        String part = haystack.substring(i, i + n);
        if (part.equals(needle)) {
          return i;
        }
      }

      return -1;
    }
  }
}
