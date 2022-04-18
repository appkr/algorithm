package dev.appkr.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstring {

  public static void main(String[] args) {
    final String in = "abcabcbb";
    System.out.println(new Solution().lengthOfLongestSubstring(in));
  }

  static class Solution {
    public int lengthOfLongestSubstring(String s) {
      Queue<Character> q = new LinkedList<>();

      int max = 0;
      for (char c : s.toCharArray()) {
        while(q.contains(c)) {
          q.poll(); // 검사 대상 문자가 q에 이미 있는 문자라면, 첫번째 원소를 버린다
                    // [], [a], [a,b], [b,c], ...
        }

        q.add(c);  // q에 추가한다
                   // [a], [a,b], [a,b,c], [b,c,a], ...
        max = Math.max(max,q.size());
        System.out.println(String.format("c=%s, max=%d, q=%s", c, max, q));
      }

      return max;
    }
  }
}
