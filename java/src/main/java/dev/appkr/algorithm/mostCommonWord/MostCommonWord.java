package dev.appkr.algorithm.mostCommonWord;

import static java.util.Comparator.comparing;

import java.util.*;

public class MostCommonWord {

  public static void main(String[] args) {
    System.out.println(
        mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
            new HashSet<String>() {{add("hit");}}));
    // NOTE in contains operation Set is O(1) while List is O(n)
    // @see https://soft.plusblog.co.kr/74
  }

  static String mostCommonWord(String paragraph, Set<String> banned) {
    String[] words = paragraph.toLowerCase().replaceAll("[^\\w\\s]", "").split("\\s");

    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      if (banned.contains(word)) {
        continue;
      }
      if (!map.containsKey(word)) {
        map.put(word, 1);
      }
      map.put(word, map.getOrDefault(word, 1) + 1);
    }

    return map.entrySet().stream().max(comparing(Map.Entry::getValue)).get().getKey();
  }
}
