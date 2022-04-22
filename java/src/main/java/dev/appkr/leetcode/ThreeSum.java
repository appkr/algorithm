package dev.appkr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 * Input: nums = []
 * Output: []
 *
 * Example 3:
 * Input: nums = [0]
 * Output: []
 *
 * Constraints:
 * - 0 <= nums.length <= 3000
 * - -105 <= nums[i] <= 105
 */
public class ThreeSum {

  public static void main(String[] args) {
    int[] nums = {-1,0,1,2,-1,-4};
//    int[] nums = {};
//    int[] nums = {0};
//    int[] nums = {0, 0, 0, 0};
    System.out.println(new Solution().threeSum(nums));
  }

  static class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      int n = nums.length;
      if (n == 0 || (n == 1 && nums[0] == 0)) {
        return res;
      }

      Arrays.sort(nums);
      System.out.println(Arrays.toString(nums)); // [-4, -1, -1, 0, 1, 2]

      for (int i = 0; i < n; i++) {
        if (i > 0 && nums[i] == nums[i-1]) {
          // 직전 값과 같은 값이면, 다음 루프로
          continue;
        }

        int l = i + 1, r = n - 1;

        // i를 고정한 상태에서, l과 r로 범위를 좁혀가며 합이 0이 되는 조합 찾기
        while (l < r) {
          int threeSum = nums[i] + nums[l] + nums[r];
          System.out.println(String.format("i=%d, l=%d, r=%d, nums[i]=%d, nums[l]=%d, nums[r]=%d, sum=%d",
              i, l, r, nums[i], nums[l], nums[r], threeSum));

          if (threeSum > 0) {
            r -= 1;
          } else if (threeSum < 0) {
            l += 1;
          } else {
            res.add(new ArrayList(Arrays.asList(nums[i], nums[l], nums[r])));
            l += 1;
          }
        }
      }

      return res.stream().distinct().collect(Collectors.toList());
    }
  }
}
