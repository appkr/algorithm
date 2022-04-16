package dev.appkr.algorithm.fibonacci;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

public class Fibonacci2 {

  public static void main(String[] args) {
    final StopWatch stopWatch = new StopWatch();
    stopWatch.start();

    // 1 2 3 4 5 6 7 8 9 10
    // 0 1 1 2 3 5 8 13 21 34
    System.out.println(fibonacci(47));

    stopWatch.stop();
    System.out.printf("Elapsed: %dms", stopWatch.getTime(TimeUnit.MILLISECONDS));
  }

  private static long fibonacci(int n) {
    int num1 = 0, num2 = 1;

    if (n <= 1) {
      return num1;
    }
    if (n == 2) {
      return num2;
    }

    int i = 3; // n==1, n==2 인 경우는 이미 처리했으므로, 3부터 루프 시작
    while (i <= n) {
      int sumOfPrevTwo = num1 + num2;
      num1 = num2;
      num2 = sumOfPrevTwo;
      i++;
    }

    return num2;
  }
}
