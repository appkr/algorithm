package dev.appkr.algorithm.factorial;

public class Factorial {

  public static void main(String[] args) {
    System.out.println(factorial(4));
  }

  private static int factorial(int i) {
    if (i == 1) {
      return 1;
    } else {
      return factorial(i - 1) * i;
    }

//    int p = 1;
//    for (int j = 1; j <= i; j++) {
//      p *= j;
//    }
//    return p;
  }
}
