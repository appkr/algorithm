package dev.appkr.algorithm.stringReverse;

public class StringReverse {

  public static void main(String[] args) {
    System.out.println(stringReverse("hello"));
  }

  static String stringReverse(String s) {
    String[] split = s.split("");
    String[] temp = new String[split.length];

    for (int i = split.length - 1; i >= 0; i--) {
      temp[split.length - 1 - i] = split[i];
    }

    return String.join("", temp);
  }
}
