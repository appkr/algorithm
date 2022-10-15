package dev.appkr.algorithm.prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorKata {

  public static void main(String[] args) {
    System.out.println(factorize(1));
    System.out.println(factorize(2));
    System.out.println(factorize(3));
    System.out.println(factorize(4));
    System.out.println(factorize(5));
    System.out.println(factorize(6));
    System.out.println(factorize(7));
    System.out.println(factorize(8));
    System.out.println(factorize(9));
    System.out.println(factorize(10));
  }

  static List<Integer> factorize(int n) {
    final List<Integer> result = new ArrayList<>();
    if (n == 1) {
      result.add(n);
      return result;
    }
    for (int divider = 2; n > 1; divider++) { // divider 증가
      for (; n % divider == 0; n /= divider) { // n 감소
        result.add(divider);
      }
    }

    return result;
  }
}
