package dev.appkr.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 * - 1 <= strs.length <= 200
 * - 0 <= strs[i].length <= 200
 * - strs[i] consists of only lower-case English letters.
 */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] strs = {"flower","flow","flight"};
//    String[] strs = {"dog","racecar","car"};

    System.out.println(new Solution().longestCommonPrefix(strs));
  }

  static class Solution {

    public String longestCommonPrefix(String[] strs) {
      if (strs.length == 0) {
        return "";
      }

      String prefix = strs[0];                               // flower -> flow -> flo -> fl
      for (int i = 1; i < strs.length; i++) {                // flower는 자기 자신이므로 제외; flow -> flight
        while (strs[i].indexOf(prefix) != 0) {               // 0이 나올때까지 계속. e.g. "flower".indexOf("flow") = 0, "flight".indexOf("flow") = -1
          prefix = prefix.substring(0, prefix.length() - 1); // 증감식: substring(0, n) -> substring(0, n-1)
          System.out.println("prefix=" + prefix);
          if (prefix.isEmpty())                              // 탈출 조건
            return "";
        }
      }

      return prefix;
    }
  }
}
