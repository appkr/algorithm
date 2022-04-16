package dev.appkr.algorithm.palindrome;

public class Palindrome3 {

  public static void main (String[] args) throws Exception {
    System.out.println(isPalindrome("amanaplanacanalpanama"));
  }

  static Boolean isPalindrome(String input) {
    int l = 0, r = input.length() - 1;
    while(l <= r) {
      if (input.charAt(l) != input.charAt(r)) {
        return false;
      }
      l++; r--;
    }

    return true;
  }
}
