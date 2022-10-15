package dev.appkr.algorithm.mostCommonWord;

import static java.util.Comparator.comparingInt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MostCommonWordKata {

  public static void main(String[] args) {
    System.out.println(
        mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
            new HashSet<String>() {{add("hit");}}));
    // NOTE in contains operation Set is O(1) while List is O(n)
    // @see https://soft.plusblog.co.kr/74
  }

  static String mostCommonWord(String paragraph, Set<String> banned) {
    final String[] parts = paragraph
        .toLowerCase()
        .replace(",", "")
        .replace(".", "")
        .split(" ");
    System.out.println("parts = " + Arrays.toString(parts));

    final HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < parts.length; i++) {
      if (banned.contains(parts[i])) {
        continue;
      }
      map.computeIfAbsent(parts[i], k -> 0);
      map.computeIfPresent(parts[i], (k, v) -> ++v);
    }

    System.out.println("map = " + map);

    return map
        .entrySet()
        .stream()
        .max(comparingInt(s -> s.getValue()))
        .get()
        .getKey();
  }
}
