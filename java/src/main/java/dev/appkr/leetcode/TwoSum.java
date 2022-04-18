package dev.appkr.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to
 * target. You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Input: nums = [3,2,4], target = 6 Output: [1,2]
 * <p>
 * Input: nums = [3,3], target = 6 Output: [0,1]
 * <p>
 * Constraints: 2 <= nums.length <= 104 -109 <= nums[i] <= 109 -109 <= target <= 109 Only one valid answer exists.
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    final int[] result = new Solution().twoSum(nums, 9);
    System.out.println(Arrays.toString(result));
  }

  static class Solution {

    public int[] twoSum(int[] nums, int target) {
      // 2+7=9 -> 2=9-7
      //       -> 7=9-2
      int[] res = new int[2];
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        int diff = target - nums[i];      // 빼서 남은 값을 구한다; 9-2=7, 9-7=2, 9-11=-2, 9-15=-6
        if (map.containsKey(diff)) { // map에서 7을 찾는다
          res[0] = i;                     // 현재 인덱스
          res[1] = map.get(diff);         // 7의 인덱스
          break;
        }
        map.put(nums[i], i);              // (2, 0), (7, 1), (-2, 2), (-6, 3)
      }

      return res;

// SOLUTION: Brute force
//  2+7=9, 2+11=13, 2+15=17
//  7+11=18, 7+15=22
//  11+15=26
//
// NOTE: Time Limit Exceeded
//    int[] res = new int[2];
//      for (int i = 0; i < nums.length; i++) {
//        for (int j = i + 1; j < nums.length; j++) {
//          System.out.println(String.format("[%d,%d]=%d, %d", i, j, nums[i], nums[j]));
//          int sum = nums[i] + nums[j];
//          if (sum == target) {
//            res[0] = i;
//            res[1] = j;
//            break;
//          }
//        }
//      }
//
//      return res;
    }
  }
}