package dev.appkr.leetcode;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 */
public class SearchRange {

  public static void main(String[] args) {
    int[] nums = {5, 7, 7, 8, 8, 10};
    int target = 8;
    final int[] result = new Solution().searchRange(nums, target);
    System.out.println(Arrays.toString(result));
  }

  static class Solution {

    public int[] searchRange(int[] nums, int target) {
      int n = nums.length;
      int l = 0;
      int r = n - 1;

      int[] res = {-1, -1};
      for (int i = 0; i < n; i++) {
        if (nums[l] < target) {
          l++;
        } else if (nums[l] == target) {
          res[0] = l;
        }

        if (nums[r] > target) {
          r--;
        } else if (nums[r] == target) {
          res[1] = r;
        }
      }

      return res;
    }
  }
}
