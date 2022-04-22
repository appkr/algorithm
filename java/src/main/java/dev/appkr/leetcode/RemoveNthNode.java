package dev.appkr.leetcode;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1: ![](https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg)
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 * Constraints:
 * - The number of nodes in the list is sz.
 * - 1 <= sz <= 30
 * - 0 <= Node.val <= 100
 * - 1 <= n <= sz
 */
public class RemoveNthNode {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    ListNodeUtils.print(head);

    final ListNode result = new Solution().removeNthFromEnd(head, 2);
    ListNodeUtils.print(result);
  }

  static class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
      // 리스트의 길이를 구한다; count = 5
      int count = 0;
      ListNode tmp = head;
      while (tmp != null) {
        count++;
        tmp = tmp.next;
      }

      // 삭제할 노드의 인덱스를 구한다; count = 3
      count = count - n;

      // 노드를 순회할 준비를 한다
      ListNode prev = null;
      tmp = head;

      // prev 노드를 기억하면서, 리스트를 순회하고, 삭제할 노드를 찾는다
      while (count != 0) {
        prev = tmp;
        tmp = tmp.next;
        count--; // 2 -> 1 -> 0 순으로 세 번 순회
        System.out.println(String.format("prev=%d, tmp=%d, count=%d", prev.val, tmp.val, count));
      }

      // tmp는 삭제할 노드
      if (prev == null) {             // tmp가 첫번째 노드 -> 다음 노드를 head로 바꾼다
        head = tmp.next;
        return head;
      } else if (tmp.next == null) {  // tmp가 마지막 노드 -> prev.next, 즉 tmp 노드를 null로 바꾼다
        prev.next = null;
        return head;
      } else {                        // tmp가 가운데 노드이면 -> prev와 tmp의 다음 노드를 연결한다; tmp와 다른 노드간의 연결을 끊는다
        prev.next = tmp.next;
        tmp.next = null;
        return head;
      }
    }
  }
}
