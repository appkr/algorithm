package dev.appkr.leetcode;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * ```
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * ```
 *
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * - I can be placed before V (5) and X (10) to make 4 and 9.
 * - X can be placed before L (50) and C (100) to make 40 and 90.
 * - C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given an integer, convert it to a roman numeral.
 *
 * Example 1:
 * Input: num = 3
 * Output: "III"
 * Explanation: 3 is represented as 3 ones.
 *
 * Example 2:
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 *
 * Example 3:
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntToRoman {

  public static void main(String[] args) {
//    int num = 3;
//    int num = 58;
    int num = 1994;
    System.out.println(new Solution().intToRoman(num));
  }

  static class Solution {

    public String intToRoman(int num) {
      int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9 ,5, 4, 1};
      String[] code = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < value.length; i++){
        while(value[i] <= num){ // e.g. 1994, value[0]=1000 -> value[1]=900 -> value[2]..value[5]=90 -> value[6]..value[11]
          sb.append(code[i]);   // i에 해당하는 로마숫자를 결과 변수에 저장; code[0]=M -> code[1]=CM -> code[5]=XC -> code[11]=IV
          num -= value[i];      // 증감식: i에 해당하는 아라비아숫자만큼을 num에서 뺀다; num=994 -> num=94 -> num=4 -> num=0
          System.out.println(String.format("i=%d, value=%d, code=%s, num=%d", i, value[i], code[i], num));
        }
      }
      return sb.toString();
    }
  }
}
