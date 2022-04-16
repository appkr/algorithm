package dev.appkr.algorithm.prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {

  public static void main(String[] args) {
    System.out.println(factorize(100));
  }

  static List<Integer> factorize(int n) {
    final List<Integer> result = new ArrayList<>();
    for (int divider = 2; n > 1; divider++) {
      for (; n % divider == 0; n /= divider) {
        result.add(divider);
      }
    }

    return result;
  }
}
