package dev.appkr.hackerrank;

import java.util.Arrays;

/**
 * You are given an unordered array consisting of CONSECUTIVE integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. Find the minimum number of swaps required to sort the array in ascending order.
 *
 * Example
 * Perform the following steps:
 * i   arr                     swap (indices)
 * 0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
 * 1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
 * 2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
 * 3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
 * 4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
 * 5   [1, 2, 3, 4, 5, 6, 7]
 * It took  swaps to sort the array.
 *
 * Function Description
 * Complete the function minimumSwaps in the editor below.
 *
 * minimumSwaps has the following parameter(s):
 *    int arr[n]: an unordered array of integers
 *
 * Returns
 *    int: the minimum number of swaps to sort the array
 *
 * Input Format
 *    The first line contains an integer, , the size of .
 *    The second line contains  space-separated integers .
 *
 * Constraints
 *    1 <= n <= 10^5
 *    1 <= arr[i] <= n
 *
 * Sample Input 0
 * 4
 * 4 3 1 2
 *
 * Sample Output 0
 * 3
 *
 * Explanation 0
 * Given array: [4, 3, 1, 2]
 * After swapping(0,2)  we get [1, 3, 4, 2]
 * After swapping(1, 2)  we get [1, 4, 3, 2]
 * After swapping(1, 3)  we get [1, 2, 3, 4]
 * So, we need a minimum of  swaps to sort the array in ascending order.
 *
 * Sample Input 1
 * 5
 * 2 3 4 1 5
 *
 * Sample Output 1
 * 3
 *
 * Explanation 1
 * Given array [2, 3, 4, 1, 5]
 * After swapping(2, 3)  we get [2, 3, 1, 4, 5]
 * After swapping(0, 1)  we get [3, 2, 1, 4, 5]
 * After swapping(0, 2)  we get [1, 2, 3, 4, 5]
 * So, we need a minimum of  swaps to sort the array in ascending order.
 *
 * Sample Input 2
 * 7
 * 1 3 5 2 4 6 7
 *
 * Sample Output 2
 * 3
 *
 * Explanation 2
 * Given array [1, 3, 5, 2, 4, 6, 7]
 * After swapping(1, 3)  we get [1, 2, 5, 3, 4, 6, 7]
 * After swapping(2, 3)  we get [1, 2, 3, 5, 4, 6, 7]
 * After swapping(3, 4)  we get [1, 2, 3, 4, 5, 6, 7]
 * So, we need a minimum of  swaps to sort the array in ascending order.
 */
public class MinimumSwap {

  public static void main(String[] args) {
    int[] arr = {7, 1, 3, 2, 4, 5, 6};
    System.out.println(Solution.minimumSwaps(arr));
  }

  static public class Solution {

    static int minimumSwaps(int[] arr) {
      int swapCount = 0;
      for (int i = 0; i < arr.length; i++) {
        if (i + 1 != arr[i]) {
          int idx = findIndex(arr, i + 1);
          swap(arr, i, idx);
          swapCount++;
          System.out.println(String.format("swap(%d, %d)=%s", i, idx, Arrays.toString(arr)));
          // 문제의 예제와 순서가 다름
          // swap(0, 1)=[1, 7, 3, 2, 4, 5, 6]
          // swap(1, 3)=[1, 2, 3, 7, 4, 5, 6]
          // swap(3, 4)=[1, 2, 3, 4, 7, 5, 6]
          // swap(4, 5)=[1, 2, 3, 4, 5, 7, 6]
          // swap(5, 6)=[1, 2, 3, 4, 5, 6, 7]
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
}
