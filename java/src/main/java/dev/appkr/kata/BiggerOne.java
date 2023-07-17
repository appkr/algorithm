package cote;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Data;

/*
Q1) "키 몸무게" 배열이 주어졌을 때, 다른 원소에 비해 키도 크고 몸무게도 크면 크다고 판단한다.
키는 큰데 몸무게는 작으면, 또는 반대의 경우는 판단할 수 없다.
키와 몸무게가 가장 큰 원소를 반환하라.
// "190 80", "170 50" ==> [190,80]
// "170 50", "190 80" ==> [190,80]

A1)
- Physical 클래스를 만들어서 키와 몸무게를 추상화하고
- 크다, 크지 않다, 판단할 수 없다의 기능을 Physical 클래스에 캡슐화했습니다

---

Q2) Q1을 확장하여 비교할 원소의 갯수가 3개 이상이라면,
// "190 80", "170 50", "160 40" ==> [190,80]
// "170 50", "190 80", "160 40" ==> [190,80]
// "170 50", "180 40", "190 30" ==> []

A2)
- Stream의 reduce API를 이용해서 가장 큰 Physical 객체를 찾았습니다.
- reduce 연산에 사용할 accumulator:BinaryFunction을 Physical 클래스의 pickBiggerOne 정적 함수로 캡슐화했습니다

---

Q3) 각 원소의 등수를 반환하라; 판단할 수 없으면 1등으로 간주한다
// "190 80", "170 50", "160 40" ==> [1, 2, 3]

A3)
- Physicals 란 일급 콜렉션 클래스를 만들고
- rankup이란 메서드에서 순위를 구하도록 구현했습니다
- 비교할 원소가 총 3개일 경우, (0, 1), (0, 2), (1, 2) 조합을 만들기 위해 Queue 데이터 구조를 이용했고,
- 순위는 Map 데이터 구조에 모두 1등으로 초기화한 후, 비교 메서드의 비교 결과에 따라 순위를 낮추도록 했습니다.

---

Q4) "키 몸무게" 외에 "체력"까지 주어졌을 때, 가장 큰 원소를 반환하라
// "190 80 3", "170 50 2", "160 40 1" ==> [190, 80, 3]

A4) Physical 클래스에 strength: int 필드를 추가하고 비교 메서드를 변경하면 비교적 쉽게 구현할 수 있을 거라 판단해서 구현해보지 않았습니다.
*/
public class BiggerOne {

  public static void main(String[] args) {
    // Test case for Q2
    System.out.println(Arrays.toString(findBiggestOneIn(new String[]{"190 80", "170 50", "160 40"}))); // [190, 80]
    System.out.println(Arrays.toString(findBiggestOneIn(new String[]{"170 50", "190 80", "160 40"}))); // [190, 80]
    System.out.println(Arrays.toString(findBiggestOneIn(new String[]{"170 50", "180 40", "190 30"}))); // []

    // Test case for Q3
    System.out.println(Arrays.toString(rankOf(new String[]{"190 80", "170 50", "160 40"}))); // [1, 2, 3]
    System.out.println(Arrays.toString(rankOf(new String[]{"170 50", "190 80", "160 40"}))); // [2, 1, 3]
    System.out.println(Arrays.toString(rankOf(new String[]{"170 50", "180 40", "190 30"}))); // [1, 1, 1]
    System.out.println(Arrays.toString(rankOf(new String[]{"170 50", "180 60", "190 55"}))); // [3, 1, 1]
  }

  static int[] findBiggestOneIn(String[] in) {
    Physical biggest = Stream.of(in)
        .map(Physical::from)
        .reduce(new Physical(), Physical::pickBiggerOne);

    final Physical answer = Optional.ofNullable(biggest).orElse(new Physical());

    return answer.toArray();
  }

  static int[] rankOf(String[] in) {
    List<Physical> elements = Stream.of(in).map(Physical::from).collect(Collectors.toList());
    Physicals pCollection = new Physicals(elements);
    pCollection.rankup();

    return pCollection.getRankMap().entrySet().stream()
        .mapToInt(Map.Entry::getValue)
        .toArray();
  }

  @Data
  static class Physical {

    int height;
    int weight;

    static Physical from(String source) {
      String[] part = source.split("\\s+");
      if (part.length != 2) {
        throw new IllegalArgumentException("Expected 2 element, but given " + part.length);
      }
      return new Physical(Integer.valueOf(part[0]), Integer.valueOf(part[1]));
    }

    Physical(int height, int weight) {
      this.height = height;
      this.weight = weight;
    }

    Physical() {
    }

    static Physical pickBiggerOne(Physical left, Physical right) {
      if (left == null || right == null) {
        return null;
      }

      boolean leftIsBigger = left.isTallerThan(right) && left.isHeavierThan(right);
      boolean rightIsBigger = !left.isTallerThan(right) && !left.isHeavierThan(right);
      if (leftIsBigger) {
        return left;
      }
      if (rightIsBigger) {
        return right;
      }

      return null;
    }

    boolean isTallerThan(Physical other) {
      return this.height > other.height;
    }

    boolean isHeavierThan(Physical other) {
      return this.weight > other.weight;
    }

    int[] toArray() {
      if (this.height == 0 && this.height == 0) {
        return new int[]{};
      }
      return new int[]{this.height, this.weight};
    }
  }

  @Data
  static class Physicals {

    int maxRank;
    LinkedList<Physical> queue;
    Map<Integer, Integer> rankMap = new HashMap<>();

    public Physicals(Collection<Physical> elements) {
      this.maxRank = elements.size();
      this.queue = new LinkedList<>(elements);
      for (int i = 0; i < elements.size(); i++) {
        // 모두 1등으로 초기화한다
        this.rankMap.put(i, 1);
      }
    }

    void rankup() {
      int leftRankKey = 0;
      while (queue.size() > 0) {
        // left 객체와 rank를 구한다
        Physical left = queue.poll();
        int rankOfLeft = rankMap.get(leftRankKey);

        // 조합을 만들어서 비교한다
        int rightRankKey = leftRankKey + 1;
        for (int i = 0; i < queue.size(); i++) {
          // right 객체와 rank를 구한다
          Physical right = queue.get(i);
          int rankOfRight = rankMap.get(rightRankKey);

          boolean taller = left.isTallerThan(right);
          boolean heavier = left.isHeavierThan(right);
          if ((taller && !heavier) || (!taller && heavier)) {
            // 판단할 수 없다면, 아무 액션도 하지 않는다
            rightRankKey++;
            continue;
          }

          if (taller && heavier) {
            // left가 더 크다 -> right의 rank를 낮춘다
            rankMap.put(rightRankKey,  Math.min(maxRank, ++rankOfRight));
            rightRankKey++;
            continue;
          }

          if (!taller && !heavier) {
            // right가 더 크다 -> left의 rank를 낮춘다
            rankMap.put(leftRankKey,  Math.min(maxRank, ++rankOfLeft));
            rightRankKey++;
            continue;
          }
        }

        leftRankKey++;
      }
    }
  }
}
