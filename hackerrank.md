hackerrank

## HourGlass
https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

```java
class Result {
    public static int hourglassSum(List<List<Integer>> arr) {
        int max = Integer.MIN_VALUE;
        List<Integer> aHourGlass = new ArrayList<>();
        for(int i = 0; i < arr.size() - 2; i++) {
            for (int j = 0; j < arr.get(i).size() - 2; j++) {
                aHourGlass.add(arr.get(i).get(j));
                aHourGlass.add(arr.get(i).get(j+1));
                aHourGlass.add(arr.get(i).get(j+2));
                aHourGlass.add(arr.get(i+1).get(j+1));
                aHourGlass.add(arr.get(i+2).get(j));
                aHourGlass.add(arr.get(i+2).get(j+1));
                aHourGlass.add(arr.get(i+2).get(j+2));

                int sum = aHourGlass.stream().mapToInt(Integer::intValue).sum();
                if (sum > max) {
                    max = sum;
                }
                
                System.out.println("HourGlass=" + aHourGlass);
                System.out.println(String.format("Max=%d, Sum=%d", max, sum));
                
                aHourGlass = new ArrayList<>();
            }
        }
        
        return max;
    }
}
```

## LeftRotation
https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

```java
class Result {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        for (int i = 0; i < d; i++) {
            int removed = a.remove(0);
            System.out.println("i=" + i + ", removed=" + removed);
            a.add(removed);            
        }
        
        return a;
    }

}
```

## New Year Chaos
https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

```java
class Result {

    public static void minimumBribes(List<Integer> q) {
    q = q.stream().map(x -> x - 1).collect(Collectors.toList());

    int totalBribeCount = 0;
    boolean tooChaotic = false;
    for (int i = q.size() - 1; i > -1; i--) {
      if (q.get(i) != i) {
        if (q.get(i-1) == i) {
          q.set(i-1, q.get(i));
          q.set(i, i);
          totalBribeCount++;
        } else if (q.get(i-2) == i) {
          q.set(i-2, q.get(i-1));
          q.set(i-1, q.get(i));
          q.set(i, i);
          totalBribeCount += 2;
        } else {
          tooChaotic = true;
          break;
        }
      }
    }

    if (tooChaotic) {
      System.out.println("Too chaotic");
    } else {
      System.out.println(totalBribeCount);
    }
  }
}
```

## Mininum Swap
https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

```java
public class Solution {

  static int minimumSwaps(int[] arr) {
    int swapCount = 0;
    for (int i = 0; i < arr.length; i++) {
      if (i + 1 != arr[i]) {
        int idx = findIndex(arr, i + 1);
        swap(arr, i, idx);
        swapCount++;
      }
    }

    return swapCount;
  }

  static int findIndex(int[] arr, int search) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == search) {
        return i;
      }
    }

    return -1;
  }

  static void swap(int[] arr, int x, int y) {
    int tmp = arr[x];
    arr[x] = arr[y];
    arr[y] = tmp;
  }
}
```

## RansomeNote
https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

```java
class Result {

    public static void checkMagazine(List<String> magazine, List<String> note) {
      Collections.sort(magazine);
      Collections.sort(note);
      
      boolean failFlag = false;
      for (String word : note) {
        boolean found = false;
        if (!magazine.remove(word)) {
          failFlag = true;
          System.out.println("No");
          break;
        }
      }
      
      if (!failFlag) {
        System.out.println("Yes");
      }
    }
}
```

## Two Strings
https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

```java
class Result {

    public static String twoStrings(String s1, String s2) {
      Set<String> set1 = new HashSet<>(Arrays.asList(s1.split("")));
      Set<String> set2 = new HashSet<>(Arrays.asList(s2.split("")));
     
      set1.retainAll(set2);
      
      return (set1.size() > 0) ? "YES" : "NO";
      
      // for (char a : s1.toCharArray()) {
      //   if (s2.indexOf(a) > -1) return "YES";
      // }
      
      // return "NO";
    }
}
```

## Making Anagrams
https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

```java
class Result {

    public static int makeAnagram(String first, String second) {
      int[] freq = new int[26];
      first.chars().forEach((c) -> {
        freq[c - 'a']++;
      });
      second.chars().forEach((c) -> {
        freq[c - 'a']--;
      });
      return Arrays.stream(freq).map(Math::abs).sum();
    }

}
```

## Alternating Characters
https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

```java
class Result {

    public static int alternatingCharacters(String s) {
      char visited = 'X';
      int deleteCount = 0;
      for (char c : s.toCharArray()) {
        if (visited == c) {
          deleteCount++;
        }
        visited = c;
      }
      return deleteCount;
    }

}
```

## Sherlock and the Valid String
https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

```java
class Result {

    public static String isValid(String s) {
      int[] freq = new int[26];
      for (char c : s.toCharArray()) {
        freq[c - 'a']++;
      }
      
      Arrays.sort(freq);

      System.out.println(Arrays.toString(freq));
      
      int i = 0;
      while (freq[i] == 0) {
        i++;
      }
      
      int min = freq[i];
      int max = freq[25];
      
      System.out.println(String.format("min=%d, max=%d", min, max));
      
      if(min == max) return "YES";
      else{
        if(((max - min == 1) && (max > freq[24])) ||
            (min == 1) && (freq[i+1] == max))
            return "YES";
      }
      return "NO";
    }

}
```
