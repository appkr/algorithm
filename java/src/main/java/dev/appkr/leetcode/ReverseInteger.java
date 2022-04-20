package dev.appkr.leetcode;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * Example 1:
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 * Input: x = 120
 * Output: 21
 */
public class ReverseInteger {

  public static void main(String[] args) {
//    int x = 123;
//    int x = -123;
    int x = 120;
    System.out.println(new Solution().reverse(x));
  }

  static class Solution {
    public int reverse(int x) {
      boolean minus = false;
      if (x < 0) {
        minus = true;
      }

      x = Math.abs(x);
      String y = String.valueOf(x);
      y = new StringBuilder(y).reverse().toString();

      int res;
      try {
        res = Integer.parseInt(y);
      } catch (Exception e) {
        return 0;
      }

      if (minus) {
        res = res * -1;
      }

      return res;
    }
  }
}
