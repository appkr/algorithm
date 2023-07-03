package dev.appkr.algorithm.combination;

import java.util.*;

import static java.util.Arrays.asList;

public class Combination2 {

  public static void main(String[] args) {
    final List<String> input = new ArrayList<>(asList("a", "b", "c", "d"));
    final Set<List<String>> res = (new Solution()).combination(input);
    System.out.println(res);
  }

  static class Solution {

    public <T> Set<List<T>> combination(List<T> input) {
      Set<List<T>> res = new HashSet<>();
      Queue<T> queue = new LinkedList<>(input);

      while (queue.size() > 0) {
        final T seed = queue.poll();
        for (T append : queue) {
          final ArrayList<T> aCombination = new ArrayList<>(asList(seed, append));
          res.add(aCombination);
        }
      }

      return res;
    }
  }
}
