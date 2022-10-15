package dev.appkr.algorithm.power;

public class PowerKata {

  public static void main(String[] args) {
    System.out.println(power(2, 1));
    System.out.println(power(2, 2));
    System.out.println(power(2, 3));
    System.out.println(power(2, 4));
    System.out.println(power(12, 3));
  }

  /**
   * @param x base
   * @param n power
   */
  static long power(int x, int n) {
    if (x == 1) {
      return 1;
    }

    int res = 1;
    for (int i = 0; i < n; i++) {
      res = res * x;
    }

    return res;
  }
}
