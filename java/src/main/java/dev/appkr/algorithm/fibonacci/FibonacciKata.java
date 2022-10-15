package dev.appkr.algorithm.fibonacci;

public class FibonacciKata {

  public static void main(String[] args) {
    System.out.println(fibonacci(1)); // 0
    System.out.println(fibonacci(2)); // 1
    System.out.println(fibonacci(3)); // 1
    System.out.println(fibonacci(4)); // 2
    System.out.println(fibonacci(5)); // 3
    System.out.println(fibonacci(6)); // 5
    System.out.println(fibonacci(7)); // 8
    System.out.println(fibonacci(8)); // 13
  }

  private static long fibonacci(int nth) {
    int num1 = 0, num2 = 1;

    if (nth <= 1) {
      return num1;
    }
    if (nth == 2) {
      return num2;
    }

    int i = 3;
    while (i <= nth) {
      int sum = num1 + num2;
      num1 = num2;
      num2 = sum;
      i++;
    }

    return num2;
  }
}
