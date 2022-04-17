package dev.appkr.algorithm.masking;

public class Masking {

  public static void main(String[] args) {
    final String in = "ewXsZeUo40xNHNCOpLl76ahX1NJWmZj3"; // e******************************3
    System.out.println(mask(in));
  }

  static String mask(String in) {
    final String head = in.substring(0, 1);
    final String tail = in.substring(in.length() - 1);
    final String middle = "*".repeat(in.length() - 2);

    return head + middle + tail;
  }
}
