package dev.appkr.algorithm.anagrams;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Anagrams2 {

  public static void main(String[] args) {
    List<String> strList = asList("eat", "tea", "tan", "ate", "nat", "bat");
    System.out.println(groupAnagrams(strList));
  }

  private static Collection<List<String>> groupAnagrams(List<String> strList) {
    final Map<String, List<String>> map = strList.stream()
        .map(str -> {
          char[] tmp = str.toCharArray();
          Arrays.sort(tmp);
          return new Tuple(new String(tmp), str);
        }).collect(groupingBy(Tuple::getSorted, mapping(Tuple::getOriginal, toList())));

    return map.values();
  }

  static class Tuple {
    String sorted;
    String original;

    public Tuple(String sorted, String original) {
      this.sorted = sorted;
      this.original = original;
    }

    public String getSorted() {
      return sorted;
    }

    public String getOriginal() {
      return original;
    }
  }
}
