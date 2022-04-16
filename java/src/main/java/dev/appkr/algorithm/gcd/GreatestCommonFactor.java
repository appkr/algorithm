package dev.appkr.algorithm.gcd;

public class GreatestCommonFactor {

  public static void main(String[] args) {
    // 최대 공약수
    // (10, 5) -> 5
    // (10, 6) -> (6, 4) -> (4, 2) -> 2
    System.out.println(gcd(10, 5));
    System.out.println(gcd(10, 6));
  }

  static int gcd(int m, int n) {
    if (m < n) {
      // 항상 m이 n보다 커야 하므로, m와 n의 값을 바꾼다
      int tmp = m;
      m = n;
      n = tmp;
    }

    int remain = m % n;
    if (remain == 0) {
      // 탈출 조건 (base case)
      return n;
    }

    // recursive case
    return gcd(n, remain);
  }
}
