package dev.appkr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * ![](https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)
 *
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 * Input: digits = ""
 * Output: []
 *
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 * Constraints:
 * - 0 <= digits.length <= 4
 * - digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombination {

  public static void main(String[] args) {
    String digits = "23";
//    String digits = "";
//    String digits = "2";

    System.out.println(new Solution().letterCombinations(digits));
  }

  static class Solution {

    public List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList<>();
      if (digits.isEmpty()) {
        return result;
      }

      String[] mappings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

      result.add("");
      for (char d : digits.toCharArray()) {  // ['2', '3']
        List<String> temp = new ArrayList();
        String letters = mappings[d - '0'];  // "abc" -> "def"
        for (String t : result) {            // [""] -> ["a", "b", "c"]
          for (int i = 0; i < letters.length(); i++) {
            temp.add(t + letters.charAt(i)); // when d = '2' temp = ["a", "b", "c"] -> when d = '3' temp = ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
          }
        }

        result = temp;                       // result = ["a", "b", "c"] -> result = ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
      }

      return result;
    }
  }
}
