package dev.appkr.hackerrank;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

/**
 * A left rotation operation on an array shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become . Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.
 * Given an array  of  integers and a number, , perform  left rotations on the array. Return the updated array to be printed as a single line of space-separated integers.
 *
 * Function Description
 * Complete the function rotLeft in the editor below.
 *
 * rotLeft has the following parameter(s):
 *    int a[n]: the array to rotate
 *    int d: the number of rotations
 *
 * Returns
 *    int a'[n]: the rotated array
 *
 * Input Format
 *    The first line contains two space-separated integers  and , the size of  and the number of left rotations.
 *    The second line contains  space-separated integers, each an .
 *
 * Constraints
 * - 1 <= n <= 10^5
 * - 1 <= d <= n
 * - 1 <= a[i] <= 10^6
 *
 * Sample Input
 * 5 4
 * 1 2 3 4 5
 *
 * Sample Output
 * 5 1 2 3 4
 *
 * Explanation
 * When we perform  left rotations, the array undergoes the following sequence of changes:
 */
public class LeftRotation {

  public static void main(String[] args) {
    List<Integer> a = new ArrayList<>(asList(1, 2, 3, 4, 5));
    int d = 4;
    System.out.println(Result.rotLeft(a, d));
  }

  static class Result {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
      for (int i = 0; i < d; i++) {
        int removed = a.remove(0);
        System.out.println("i=" + i + ", removed=" + removed);
        a.add(removed);
      }

      return a;
    }
  }
}
