package dev.appkr.algorithm.anagrams;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class AnagramsKata {

  public static void main(String[] args) {
    List<String> strList = asList("eat", "tea", "tan", "ate", "nat", "bat");
    System.out.println(groupAnagrams(strList));
  }

  private static Collection<List<String>> groupAnagrams(List<String> strList) {
    final HashMap<String, List<String>> result = new HashMap<>();
    for (String str : strList) {
      final char[] tmp = str.toCharArray();
      Arrays.sort(tmp);
      final String sortedStr = new String(tmp);

      result.computeIfAbsent(sortedStr, k -> new ArrayList<>());
      result.compute(sortedStr, (k, v) -> {
        v.add(str);
        return v;
      });
    }

    return result.values();
  }
}
