package dev.appkr.algorithm.prime;

public class PrimeNumber {

  public static void main(String[] args) {
    for (int i = 0; i <= 100; i++) {
      System.out.println(String.format("%d:%s", i, isPrime(i)));
    }
  }

  private static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }

    for (int i = 2; i <= (int)Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }
}
