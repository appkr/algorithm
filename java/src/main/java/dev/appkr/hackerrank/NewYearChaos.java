package dev.appkr.hackerrank;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * It is New Year's Day and people are in line for the Wonderland rollercoaster ride. Each person wears a sticker indicating their initial position in the queue from  to . Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker. One person can bribe at most two others.
 * Determine the minimum number of bribes that took place to get to a given queue order. Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.
 *
 * Example
 * If person  bribes person , the queue will look like this: . Only  bribe is required. Print 1.
 * Person  had to bribe  people to get to the current position. Print Too chaotic.
 *
 * Function Description
 * Complete the function minimumBribes in the editor below.
 *
 * minimumBribes has the following parameter(s):
 *    int q[n]: the positions of the people after all bribes
 *
 * Returns
 *    No value is returned. Print the minimum number of bribes necessary or Too chaotic if someone has bribed more than  people.
 *
 * Input Format
 *    The first line contains an integer , the number of test cases.
 *  Each of the next  pairs of lines are as follows:
 *    - The first line contains an integer , the number of people in the queue
 *    - The second line has  space-separated integers describing the final state of the queue.
 *
 * Constraints
 * - 1 <= t <= 10
 * - 1 <= n <= 10^5

 * Sample Input
 * STDIN       Function
 * -----       --------
 * 2           t = 2
 * 5           n = 5
 * 2 1 5 3 4   q = [2, 1, 5, 3, 4]
 * 5           n = 5
 * 2 5 1 3 4   q = [2, 5, 1, 3, 4]
 *
 * Sample Output
 * 3
 * Too chaotic
 */
public class NewYearChaos {

  public static void main(String[] args) {
    List<Integer> q1 = asList(2, 1, 5, 3, 4);
    List<Integer> q2 = asList(2, 5, 1, 3, 4);
    Result.minimumBribes(q1);
    Result.minimumBribes(q2);
  }

  static class Result {

    public static void minimumBribes(List<Integer> q) {
      q = q.stream().map(x -> x - 1).collect(Collectors.toList());

      int totalBribeCount = 0;
      boolean tooChaotic = false;
      for (int i = q.size() - 1; i > -1; i--) {
        if (q.get(i) != i) {              // 순서가 변경되었으면
          if (q.get(i-1) == i) {          // 1칸만 변경되었으면
            q.set(i-1, q.get(i));
            q.set(i, i);
            totalBribeCount += 1;
          } else if (q.get(i-2) == i) {   // 2칸만 변경되었으면
            q.set(i-2, q.get(i-1));
            q.set(i-1, q.get(i));
            q.set(i, i);
            totalBribeCount += 2;
          } else {                        // 2칸 이상 변경되었으면
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
}
