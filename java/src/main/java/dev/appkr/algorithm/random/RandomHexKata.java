package dev.appkr.algorithm.random;

public class RandomHexKata {

  public static void main(String[] args) {
    System.out.println(generate());
  }

  static String generate() {
    char [] seeds = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f'};
    final StringBuilder builder = new StringBuilder();
    for (int i = 0; i < 16; i++) {
      final int random = (int) (Math.random() * 16);
      builder.append(seeds[random]);
    }

    return builder.toString();
  }
}
