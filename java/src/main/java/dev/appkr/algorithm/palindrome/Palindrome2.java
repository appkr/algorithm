package dev.appkr.algorithm.palindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindrome2 {

  public static void main (String[] args) throws java.lang.Exception {
    System.out.println(isPalindrome("amanaplanacanalpanama"));
  }

  static Boolean isPalindrome(String input) {
    List<String> tokens = new ArrayList<>(Arrays.asList(input.split("")));
    while (tokens.size() > 1) {
      if (!tokens.remove(0).equals(tokens.remove(tokens.size() - 1))) {
        return false;
      }
    }

    return true;
  }
}
