package dev.appkr.hackerrank;

/**
 * You are given a string containing characters A and B only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.
 * Your task is to find the minimum number of required deletions.
 *
 * Example
 *    s = "AABAAB"
 *
 * Remove an A at positions 0 and 3 to make ABAB in 2 deletions.
 *
 * Function Description
 * Complete the alternatingCharacters function in the editor below.
 *
 * alternatingCharacters has the following parameter(s):
 * string s: a string
 *
 * Returns
 * int: the minimum number of deletions required
 *
 * Input Format
 * The first line contains an integer , the number of queries.
 * The next  lines each contain a string  to analyze.
 *
 * Constraints
 *    1 <= q <= 10
 *    1 <= length of s <= 10^5
 *    Each string  will consist only of characters  and .
 *
 * Sample Input
 * 5
 * AAAA
 * BBBBB
 * ABABABAB
 * BABABA
 * AAABBB
 *
 * Sample Output
 * 3 (Axxx)
 * 4 (Bxxxx)
 * 0
 * 0
 * 4 (AxxBxx)
 */
public class AlternatingCharacters {

  public static void main(String[] args) {
    String s = "AAABBB";
    System.out.println(Result.alternatingCharacters(s));
  }

  static class Result {

    public static int alternatingCharacters(String s) {
      char visited = 'X';
      int deleteCount = 0;
      for (char c : s.toCharArray()) {
        if (visited == c) {
          deleteCount++;
        }
        visited = c;
      }

      return deleteCount;
    }
  }
}
