package dev.appkr.kata;

import lombok.Data;

import java.util.*;

public class LRU {

  // requirement:
  //   - All operations should run in order of O(1)
  //   - The cache has a limited size
  //   - It's mandatory that all cache operations support concurrency
  //   - If the cache is full, adding a new item must invoke the LRU strategy
  // data structure to use:
  //   - LinkedList & HashMap
  // cache miss:
  //   - Add a new element in front of the list.
  //   - Add a new entry in HashMap and refer to the head of the list.
  // cache hit:
  //   - Remove the hit element and add it in front of the list.
  //   - Update HashMap with a new reference to the front of the list.
  public static void main(String[] args) {
    final LRUCache cache = new LRUCache(2);
    cache.set("1", "1");
    cache.set("2", "2");
    System.out.println(cache.get("1").orElse(null));
    cache.set("3", "3");
    System.out.println(cache.get("2").orElse(null));
    System.out.println(cache.get("3").orElse(null));
  }

  @Data
  static class LRUCache {

    int capacity;
    Map<String, String> map;
    LinkedList<String> list;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.map = new HashMap<>(capacity);
      this.list = new LinkedList<>();
    }

    void set(String key, String value) {
      if (map.containsKey(key)) {
        list.remove(value);
      }

      if (map.size() == capacity) {
        evict();
      }

      list.addFirst(value);
      map.put(key, value);
    }

    Optional<String> get(String key) {
      if (!map.containsKey(key)) {
        return Optional.empty();
      }

      final String value = map.get(key);
      list.remove(value);
      list.addFirst(value);
      map.put(key, value);

      return Optional.of(value);
    }

    void evict() {
      final String value = list.removeLast();
      final List<String> keys = map.entrySet().stream()
          .filter(e -> e.getValue().equals(value))
          .map(Map.Entry::getKey)
          .toList();
      keys.forEach(key -> {
        map.remove(key);
      });
    }
  }
}
