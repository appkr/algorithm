package dev.appkr.algorithm.compression;

public class Compression {

  public static void main(String[] args) {
    String in = "aabbccca"; // a2b2c3a1
    System.out.println(compress(in));
  }

  static String compress(String in) {
    final char[] tokens = in.toCharArray();
    int freq = 1;
    char prev = tokens[0];
    String result = "";

    for (int i = 1; i < tokens.length; i++) {
      if (tokens[i] == prev) {
        prev = tokens[i];
        freq++;
      } else {
        result += (String.valueOf(prev) + freq);
        prev = tokens[i];
        freq = 1;

        if (i == tokens.length - 1) {
          // 마지막 원소이면
          result += (String.valueOf(prev) + freq);
        }
      }
    }

    return result;
  }
}
