package dev.appkr.algorithm.random;

import java.util.Random;

public class RandomHex {

  public static void main(String[] args) {
    // 16은 2^4이므로, 16진수 하나가 4bit를 표현함
    // 64bit / 4bit = 16
    // 16진수 16자리를 만들어야 함
    System.out.println(generate());
  }

  static String generate() {
    String result = "";
    char[] seeds = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    for (int i = 0; i < 16; i++) {
      final int rand = new Random().nextInt(15);
      result += String.valueOf(seeds[rand]);
    }

    return result;
  }
}
