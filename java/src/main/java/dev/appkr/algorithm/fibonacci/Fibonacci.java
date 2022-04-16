package dev.appkr.algorithm.fibonacci;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

public class Fibonacci {

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
    if (n <= 1) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}
