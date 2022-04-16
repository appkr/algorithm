package dev.appkr.algorithm.factorial;

import org.apache.commons.lang3.time.StopWatch;

public class Factorial {

  public static void main(String[] args) {
    final StopWatch stopWatch = new StopWatch();
    stopWatch.start();

    System.out.println(factorial(15));

    stopWatch.stop();
    System.out.printf("Elapsed: %dns", stopWatch.getNanoTime());
  }

  private static int factorial(int i) {
    if (i == 1) {
      return 1;
    }
    return factorial(i - 1) * i;

//    int p = 1;
//    for (int j = 1; j <= i; j++) {
//      p *= j;
//    }
//    return p;
  }
}
