package dev.appkr.algorithm.gcd;

public class GreatestCommonFactorKata {

  public static void main(String[] args) {
    // 최대 공약수
    // (10, 5) -> 5
    // (10, 6) -> (6, 4) -> (4, 2) -> 2
    System.out.println(gcd(10, 2)); // 2
    System.out.println(gcd(10, 3)); // ?
    System.out.println(gcd(10, 4)); // 2
    System.out.println(gcd(4, 2)); // 2
    System.out.println(gcd(10, 5)); // 5
    System.out.println(gcd(10, 6)); // 2
    System.out.println(gcd(10, 7)); // 1
    System.out.println(gcd(10, 8)); // 2
    System.out.println(gcd(10, 9)); // 1
    System.out.println(gcd(121, 11)); // 1
  }

  static int gcd(int m, int n) {
    if (m < n) {
      int tmp = m;
      m = n;
      n = tmp;
    }

    if (m % n == 0) {
      return n;
    }

    return gcd(n, m % n);
  }
}
