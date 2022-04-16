package dev.appkr.algorithm.power;

public class Power {

  public static void main(String[] args) {
    System.out.println(power(12, 3));
  }

  /**
   * @param x base
   * @param n power
   */
  static long power(int x, int n) {
    if (n == 0) {
      return 1;
    }

    return x * power(x, n - 1);
    // 12^3
    //      = 12 * 12^2
    //      = 12 * 12 * 12^1
    //      = 12 * 12 * 12 * 1

// 루프로 구현
//    int result = 1;
//    for (int i = 0; i < n; i++) {
//      result *= x;
//    }
//
//    return result;
  }
}
