package dev.appkr.algorithm.printBinary;

public class PrintBinary {

  public static void main(String[] args) {
    // 10 -> (10 / 2 = 5) -> (5 / 2 = 2) -> (2 / 2 = 1) -> ( 1 / 2 = 1)
    //                                                     print (1 % 2 = 1)
    //                                      print (2 % 2 = 0)
    //                       print (5 % 2 = 1)
    //       print (10 % 2 = 0)
    printInBinary(10);
  }

  static void printInBinary(int n) {
    if (n < 2) {
      System.out.print(n);
    } else {
      printInBinary(n / 2);
      System.out.print(n % 2);
    }
  }
}
