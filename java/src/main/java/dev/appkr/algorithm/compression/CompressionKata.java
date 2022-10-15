package dev.appkr.algorithm.compression;

public class CompressionKata {

  public static void main(String[] args) {
    System.out.println(compress("aaaaabbccca")); // a5b2c3a1
    System.out.println(compress("aabbaaacccccccca")); // a2b2a3c8a1
    System.out.println(compress("abcd")); // abcd
  }

  static String compress(String in) {
    final String[] parts = in.split("");
    final StringBuilder builder = new StringBuilder(parts[0]);
    String prev = parts[0];
    int cnt = 1;
    for (int i = 1; i < parts.length; i++) {
      if (parts[i].equals(prev)) {
        cnt++;
      } else {
        builder.append(cnt);
        builder.append(parts[i]);
        prev = parts[i];
        cnt = 1;
      }

      if (i == parts.length - 1) {
        builder.append(cnt);
      }
    }

    final String candidate = builder.toString();
    return (candidate.length() < in.length()) ? candidate : in;
  }
}
