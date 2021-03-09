package dev.appkr.algorithm.palindrome;

public class Palindrome {

  public static void main (String[] args) throws java.lang.Exception {
    System.out.println(isPalindrome("amanaplanacanalpanama"));
  }

  static Boolean isPalindrome(String input) {
    String reverse = new StringBuffer(input).reverse().toString();

    return input.equals(reverse);
  }
}
