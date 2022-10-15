package dev.appkr.algorithm.sort;

import java.util.Arrays;

public class BubbleSortKata {

  public static void main(String[] args) {
    int[] in = { 15, 23, 16, 21, 6, 8, 46, 40, 37, 43, 8, 3, 33 };
    sort(in);
    System.out.println(Arrays.toString(in));
  }

  static void sort(int[] in) {
    boolean swapped = true;
    while (swapped) {
      swapped = false;
      for (int i = 1; i < in.length; i++) {
        if (i < in.length && in[i-1] > in[i]) {
          swap(in, i);
          swapped = true;
        }
      }
    }
  }

  static void swap(int[] in, int i) {
    int tmp = in[i];
    in[i] = in[i - 1];
    in[i - 1] = tmp;
  }
}
