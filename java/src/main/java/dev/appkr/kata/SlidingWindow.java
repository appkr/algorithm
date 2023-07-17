package dev.appkr.kata;

public class SlidingWindow {

  public static void main(String[] args) {
    int[] arr = {3, 1, 5, 3, 4, 1, 5, 7, 5, 1, 8};
    int n = arr.length;

    // 첫 5개 원소의 합을 구한다
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0; i < 5; i++) {
      sum += arr[i];
    }

    // 슬라이딩하면서 합을 구하고, 최대값을 구한다
    for (int i = 0; i <= n - 5; i++) {
      if (sum > max) {
        max = sum;
      }

      // 마지막 슬라이딩 윈도의 다음 윈도는 없음
      if (i == n-5) {
        break;
      }

      // 다음 슬라이딩 윈도의 합
      sum = sum + arr[i + 5] - arr[i];
    }

    System.out.printf("max=%d", max); // 26
  }
}
