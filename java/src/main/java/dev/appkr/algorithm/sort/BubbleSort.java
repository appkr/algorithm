package dev.appkr.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

  static int counter = 0;

  public static void main(String[] args) {
    int[] in = { 15, 23, 16, 21, 6, 8, 46, 40, 37, 43, 8, 3, 33 };
    sort(in);
    System.out.println(Arrays.toString(in));
    System.out.println("counter=" + counter);
  }

  static void sort(int[] in) {
    boolean swapped = false;
    do {
      swapped = false; // for 루프에서 하나라도 스왑되면 true가 되고, 다음 루프로 넘어감
      for (int i = 1; i < in.length; i++) {
        int left = in[i - 1], right = in[i];
        if (left > right) {
          swap(in, i);
          swapped = true;
          counter++;
        }
      }
    } while (swapped);
  }

  static void swap(int[] in, int i) {
    int tmp = in[i];
    in[i] = in[i - 1];
    in[i - 1] = tmp;
  }
}
