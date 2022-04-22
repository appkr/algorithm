package dev.appkr.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Constraints:
 * - 1 <= s.length <= 104
 * - s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

  public static void main(String[] args) {
//    String s = "()";
//    String s = "()[]{}";
//    String s = "(]";
    String s = "([{}])";

    System.out.println(new Solution().isValid(s));
  }

  static class Solution {

    public boolean isValid(String s) {
      Map<Character, Character> map = new HashMap<>();
      map.put(')', '(');
      map.put('}', '{');
      map.put(']', '[');

      Stack<Character> stack = new Stack();
      // ([{}])
      for (Character c : s.toCharArray()) {
        if (!map.containsKey(c)) { // (:false -> [:false -> {:false
          stack.push(c);          // ( -> ([
        } else {
          if (stack.isEmpty()) {       // 매칭해야할 괄호가 없음
            return false;
          }
          if (stack.peek() == map.get(c)) {
            stack.pop();
          } else {
            return false;
          }
        }
      }

      return stack.size() == 0 ? true : false;
    }
  }
}
