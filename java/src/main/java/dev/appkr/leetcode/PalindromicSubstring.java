package dev.appkr.leetcode;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class PalindromicSubstring {

  public static void main(String[] args) {
    String s = "baamanaplanacanalpanamabab";
    System.out.println(new Solution().longestPalindrome(s));
  }

  static class Solution {

    public String longestPalindrome(String s) {
      System.out.println(s.length());
      String res = "";
      int max = 0;
      for (int i = 0; i < s.length(); i++) {
        // while1: 같은 인덱스에서 시작해서 왼쪽, 오른쪽으로 한칸식 벌려가며 검사
        int l = i, r = i;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { // l, r 인덱스가 범위 안이고, 인덱스에 해당하는 문자가 같으면
          int charCount = r - l + 1;     // 벌어진 인덱스의 차에 1을 더해서 문자 개수를 구한다. e.g. 6 - 5 + 1 = 2
          if (charCount > max) {
            res = s.substring(l, r + 1); // 발견한 팰린드롬 저장
            max = charCount;
          }

          System.out.println(String.format("i=%d, while1, l=%d, r=%d, res=%s, max=%d", i, l, r, res, max));
          l--; r++;
        }

        // while2: 인접한 인덱스에서 시작해서 왼쪽, 오른쪽으로 한칸식 벌려가며 검사
        l = i; r = i + 1;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
          int charCount = r - l + 1;
          if (charCount > max) {
            res = s.substring(l, r + 1);
            max = charCount;
          }

          System.out.println(String.format("i=%d, while2, l=%d, r=%d, res=%s, max=%d", i, l, r, res, max));
          l--; r++;
        }
      }

      return res;

// SOLUTION: Brute force
//  substring(0, 1), substring(0, 2), substring(0, 3), substring(0, 4) -> palindrome 검사 후 max 값 업데이트
//                   substring(1, 2), substring(1, 3), substring(1, 4) -> palindrome 검사 후 max 값 업데이트
//                                    substring(2, 3), substring(2, 4) -> palindrome 검사 후 max 값 업데이트
//                                                     substring(3, 4) -> palindrome 검사 후 max 값 업데이트
//
// Note: Time Limit Exceeded
//      String res = "";
//      int max = 0;
//      for (int i = 0; i < s.length(); i++) {
//        for (int j = i + 1; j < s.length() + 1; j++) {
//          String ss = s.substring(i, j);
//          if (isPalindrome(ss)) {
//            if (ss.length() > max) {
//              max = ss.length();
//              res = ss;
//            }
//          }
//          System.out.println(String.format("i=%d, j=%d, ss=%s, max=%d, res=%s", i, j, ss, max, res));
//        }
//      }
//
//      return res;
//    }
//
//    boolean isPalindrome(String s) {
//      int l = 0, r = s.length() - 1;
//      while (l <= r) {
//        if (s.charAt(l) != s.charAt(r)) {
//          return false;
//        }
//        l++; r--;
//      }
//
//      return true;
//    }
    }
  }
}
