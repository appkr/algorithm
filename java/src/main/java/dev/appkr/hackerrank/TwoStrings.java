package dev.appkr.hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two strings, determine if they share a common substring. A substring may be as small as one character.
 *
 * Example
 *    s1 = "and"
 *    s2 = "art"
 * These share the common substring a.
 *
 *    s1 = "be"
 *    s2 = "cat"
 * These do not share a substring.
 *
 * Function Description
 * Complete the function twoStrings in the editor below.
 *
 * twoStrings has the following parameter(s):
 *    string s1: a string
 *    string s2: another string
 *
 * Returns
 *    string: either YES or NO
 *
 * Input Format
 * The first line contains a single integer , the number of test cases.
 * The following  pairs of lines are as follows:
 *    The first line contains string .
 *    The second line contains string .
 *
 * Constraints
 *    s1 and s2 consist of characters in the range ascii[a-z].
 *    1 <= p <= 10
 *    1 <= |s1|, |s2| <= 105
 *
 * Output Format
 *    For each pair of strings, return YES or NO.
 *
 * Sample Input
 * 2
 * hello
 * world
 * hi
 * world
 *
 * Sample Output
 * YES
 * NO
 */
public class TwoStrings {

  public static void main(String[] args) {
    String s1 = "hello";
    String s2 = "world";
    System.out.println(Result.twoStrings(s1, s2));
  }

  static class Result {

    public static String twoStrings(String s1, String s2) {
//      Set<String> set1 = new HashSet<>(Arrays.asList(s1.split("")));
//      Set<String> set2 = new HashSet<>(Arrays.asList(s2.split("")));
//
//      set1.retainAll(set2);
//
//      return (set1.size() > 0) ? "YES" : "NO";

       for (char a : s1.toCharArray()) {
         if (s2.indexOf(a) > -1) return "YES";
       }

       return "NO";
    }
  }
}
