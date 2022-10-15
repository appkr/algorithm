package dev.appkr.leetcode;

import java.util.Arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n))
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfArray {

  public static void main(String[] args) {
    int[] nums1 = {1, 3};
    int[] nums2 = {2};
    final double result = new Solution().findMedianSortedArrays(nums1, nums2);
    System.out.println(result);
  }

  static class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int m = nums1.length,  n = nums2.length;

      // 새 배열을 만들고, nums1, nums2의 원소를 복사한다
      int[] merged = new int[m + n];
      System.arraycopy(nums1, 0, merged, 0, m);
      System.arraycopy(nums2, 0, merged, m, n);

      // 새로 만든 배열을 정렬한다
      Arrays.sort(merged);
      System.out.println(Arrays.toString(merged));

      boolean isEven = (merged.length % 2 == 0);
      double res;
      if (isEven) {
        System.out.println("even");
        int first = merged.length / 2 - 1; // if length = 4, first = 1
        int second = first + 1;            // second = 2
        System.out.println(String.format("first=%d, second=%d", first, second));
        res = ((double)merged[first] + merged[second]) / 2;
      } else {
        System.out.println("odd");
        int mid = merged.length / 2;       // if length = 3, 3 / 2 = 1
        System.out.println(mid);
        res = merged[mid] * 1.0;
      }

      return res;
    }
  }
}
