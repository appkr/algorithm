package dev.appkr.algorithm.anagrams;

import java.util.*;
import static java.util.Arrays.asList;

public class Anagrams {

  public static void main(String[] args) {
    List<String> strList = asList("eat", "tea", "tan", "ate", "nat", "bat");
    System.out.println(groupAnagrams(strList));
  }

  private static Collection<List<String>> groupAnagrams(List<String> strList) {
    Map<String, List<String>> map = new HashMap<>();
    strList.forEach(str -> {
      // 문자 단위로 쪼개서 정렬하고 다시 조인
      char[] tmp = str.toCharArray();
      Arrays.sort(tmp);
      final String key = new String(tmp);

      // map 초기화
      if (!map.keySet().contains(key)) {
        map.put(key, new ArrayList<>());
      }

      // map에 원본 문자열 추가
      map.get(key).add(str);
    });

    return map.values();
  }
}
