package dev.appkr.leetcode;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 *
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 *
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicateLink {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(3);

    new Solution().deleteDuplicates(head);
    ListNodeUtils.print(head);
  }

  static class Solution {

    public ListNode deleteDuplicates(ListNode head) {
      ListNode current = head;
      while (current != null && current.next != null) {
        if (current.val == current.next.val) {
          current.next = current.next.next;
        } else {
          current = current.next;
        }
      }

      return head;
    }
  }
}
