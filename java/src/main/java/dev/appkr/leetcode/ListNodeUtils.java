package dev.appkr.leetcode;

public class ListNodeUtils {

  static void print(ListNode head) {
    final StringBuilder builder = new StringBuilder();
    for (ListNode cur = head; cur != null ; cur = cur.next) {
      builder.append(cur.val);
      if (cur.next != null) {
        builder.append("->");
      }
    }

    System.out.println(builder);
  }
}
