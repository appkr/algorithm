package dev.appkr.kata;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Percentile {

  public static void main(String[] args) {
    List<Integer> latencies = IntStream
        .rangeClosed(1, 100)
        .boxed()
        .collect(Collectors.toList()); // Must be modifiable to be sorted

    Collections.shuffle(latencies);
    Collections.sort(latencies);

    System.out.println("50=" + percentile(latencies, .50));
    System.out.println("90=" + percentile(latencies, .90));
    System.out.println("95=" + percentile(latencies, .95));
    System.out.println("99=" + percentile(latencies, .99));
  }

  static Integer percentile(List<Integer> latencies, double targetPercentile) {
    final int index = (int) Math.ceil(latencies.size() * targetPercentile);
    return latencies.get(index - 1);
  }
}
