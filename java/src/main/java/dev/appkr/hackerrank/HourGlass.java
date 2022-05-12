package dev.appkr.hackerrank;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a  2D Array, :
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 *
 * An hourglass in  is a subset of values with indices falling in this pattern in 's graphical representation:
 * a b c
 *   d
 * e f g
 *
 * There are  hourglasses in . An hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum. The array will always be .
 *
 * Example
 * -9 -9 -9  1 1 1
 *  0 -9  0  4 3 2
 * -9 -9 -9  1 2 3
 *  0  0  8  6 6 0
 *  0  0  0 -2 0 0
 *  0  0  1  2 4 0
 *
 * The  hourglass sums are:
 * -63, -34, -9, 12,
 * -10,   0, 28, 23,
 * -27, -11, -2, 10,
 *   9,  17, 25, 18
 *
 * The highest hourglass sum is  from the hourglass beginning at row , column :
 * 0 4 3
 *   1
 * 8 6 6
 *
 * Function Description
 * Complete the function hourglassSum in the editor below.
 * hourglassSum has the following parameter(s):
 *    int arr[6][6]: an array of integers
 * Returns
 *    int: the maximum hourglass sum
 * Input Format
 *    Each of the  lines of inputs  contains  space-separated integers .
 *
 * Constraints
 * - -9 <= arr[i][j] <= 9
 * - 0 <= i,j <= 5
 *
 * Output Format
 * Print the largest (maximum) hourglass sum found in .
 *
 * Sample Input
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 *
 * Sample Output
 * 19
 *
 * The hourglass with the maximum sum () is:
 * 2 4 4
 *   2
 * 1 2 4
 */
public class HourGlass {

  public static void main(String[] args) {
    List<List<Integer>> arr = asList(
        asList(1, 1, 1, 0, 0, 0),
        asList(0, 1, 0, 0, 0, 0),
        asList(1, 1, 1, 0, 0, 0),
        asList(0, 0, 2, 4, 4, 0),
        asList(0, 0, 0, 2, 0, 0),
        asList(0, 0, 1, 2, 4, 0)
    );

    System.out.println(Result.hourglassSum(arr));
  }

  static class Result {

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
}
