package dev.appkr.algorithm.combination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class Combination1 {

  public static void main(String[] args) {
    final List<List<String>> list = new ArrayList<>();
    list.add(new ArrayList<>(asList("a", "b")));
    list.add(new ArrayList<>(asList("d", "e", "f", "g")));
    final Set<List<String>> res = (new Solution()).combination(list);
    System.out.println(res);
  }

  static class Solution {

    public <T> Set<List<T>> combination(List<List<T>> input) {
      Set<List<T>> res = new HashSet<>();
      Set<List<T>> tmp;

      int index = 0;
      for (T i : input.get(0)) {
        List<T> newList = new ArrayList<>();
        newList.add(i);
        res.add(newList);
      }

      index++;
      while (index < input.size()) {
        List<T> nextList = input.get(index);
        tmp = new HashSet<>();
        for (List<T> first : res) {
          for (T second : nextList) {
            List<T> newList = new ArrayList<T>();
            newList.addAll(first);
            newList.add(second);
            tmp.add(newList);
          }
        }
        res = tmp;
        index++;
      }

      return res;
    }
  }
}
