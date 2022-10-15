package dev.appkr.algorithm.factorial;

public class FactorialKata {

  public static void main(String[] args) {
    System.out.println(factorial(3));
  }

  private static int factorial(int i) {
    int p = 1;
    for (int j = 1; j <= i; j++) {
      p *= j;
    }

    return p;
  }
}
