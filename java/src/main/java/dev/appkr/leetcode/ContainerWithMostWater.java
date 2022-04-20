package dev.appkr.leetcode;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container. (slant: 기울이다)
 *
 * Example 1:
 * ![](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg)
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 */
public class ContainerWithMostWater {

  public static void main(String[] args) {
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//    int[] height = {1, 1};
    System.out.println(new Solution().maxArea(height));
  }

  static class Solution {

    public int maxArea(int[] height) {
      int max = 0;
      int l = 0, r = height.length - 1;

      while (l < r) {
        int area = (r - l) * Math.min(height[l], height[r]);
        max = Math.max(max, area);

        System.out.println(String.format("area=%d, max=%d, l=%d, r=%d, height[l]=%d, height[r]=%d, action=%s",
            area, max, l, r, height[l], height[r], (height[l] > height[r]) ? "r--" : "l++"));

        // 포인터의 값이 큰 쪽을 기준으로, 값이 작은 쪽의 포인터를 옮긴다
        if (height[l] < height[r]) {
          l++;
        } else {
          r--;
        }
      }

      return max;

// Idea: (min(i, j) * (j - i)) > max
// Brute force: Time Limit Exceeded
//      int max = 0;
//      int n = height.length;
//      for (int i = 0; i < n; i++) {
//        for (int j = i; j < n; j++) {
//          int x = j - i;
//          int y = Math.min(height[j], height[i]);
//          int area = x * y;
//          if (area > max) {
//            max = area;
//          }
//
//          System.out.println(String.format("i=%d, j=%d, x=%d, y=%d, area=%d, max=%d", i, j, x, y, area, max));
//        }
//      }
//
//      return max;
    }
  }
}
