package dev.appkr.hackerrank;

import java.util.Arrays;

/**
 * Sherlock considers a string to be valid if all characters of the string appear the SAME NUMBER OF TIMES. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.
 *
 * Example
 * s = "abc"
 * This is a valid string because frequencies are {a:1, b:1, c:1}.
 *
 * s = "abcc"
 * This is a valid string because we can remove one c and have 1 of each character in the remaining string.
 *
 * s = "abccc"
 * This string is not valid as we can only remove 1 occurrence of c. That leaves character frequencies of {a:1, b:1, c:2}.
 *
 * Function Description
 * Complete the isValid function in the editor below.
 *
 * isValid has the following parameter(s):
 * string s: a string
 *
 * Returns
 * string: either YES or NO
 *
 * Input Format
 * A single string s.
 *
 * Constraints
 *    1 <= |s| <= 10^5
 *    Each character s[i] is ascii[a-z]
 */
public class SherlockValidString {

  public static void main(String[] args) {
    String s = "abcdefghhgfedecba";
    System.out.println(Result.isValid(s));
  }

  static class Result {

    public static String isValid(String s) {
      int[] freq = new int[26];
      for (char c : s.toCharArray()) {
        freq[c - 'a']++;
      }

      Arrays.sort(freq);

      System.out.println(Arrays.toString(freq));

      int i = 0;
      while (freq[i] == 0) {
        i++;
      }

      int min = freq[i];
      int max = freq[25];

      System.out.println(String.format("min=%d, max=%d", min, max));

      if (min == max) {
        return "YES";
      } else {
        if (((max - min == 1) && (max > freq[24])) || (min == 1) && (freq[i+1] == max)) {
          return "YES";
        }
      }

      return "NO";
    }
  }
}
