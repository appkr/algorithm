package dev.appkr.algorithm.list;

public class SumOfLinkedList {

  public static void main(String[] args) {
    // list1을 만든다
    final MyLinkedList l1 = new MyLinkedList();
    l1.add(new Node(1));
    l1.add(new Node(2));
    l1.add(new Node(3));

    // list2를 만든다
    final MyLinkedList l2 = new MyLinkedList();
    l2.add(new Node(6));
    l2.add(new Node(7));
    l2.add(new Node(8));

    final MyLinkedList result = l1.add(l2);
    System.out.println(result);
  }
}

class MyLinkedList {

  Node head;
  Node last;

  public void add(Node aNode) {
    if (this.head == null) {
      this.head = aNode;
    } else {
      this.last.next = aNode;
    }
    this.last = aNode;
  }

  public MyLinkedList reverse() {
    Node  prev = null, cur = head, next = null;
    while (cur != null) {
      next = cur.next; // (초기값) next 할당
      cur.next = prev; // next로 가던 화살표를 prev로 가도록 바꾼다
      prev = cur;      // (증감식) prev 전진
      cur = next;      // (증감식) current 전진
    }

    final MyLinkedList result = new MyLinkedList();
    result.add(prev);

    return result;
  }

  public MyLinkedList add(MyLinkedList other) {
    final MyLinkedList result = new MyLinkedList();
    int carry = 0;

    // 뒤집는다
    Node thisHead = reverse().head, otherHead = other.reverse().head;
    while (thisHead != null || otherHead != null) {
      int v1 = (thisHead == null) ? 0 : thisHead.value;
      int v2 = (otherHead == null) ? 0 : otherHead.value;

      int sum = (v1 + v2 + carry) % 10; // 5 % 10 = 5, 15 % 10 = 5
      carry = (v1 + v2 + carry) / 10;   // 5 / 10 = 0, 15 % 10 = 1
      
      result.add(new Node(sum));

      // 증감식
      thisHead = (thisHead == null) ? null : thisHead.next;
      otherHead = (otherHead == null) ? null : otherHead.next;
    }

    return result.reverse();
  }

  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();
    for (Node cur = head; cur != null ; cur = cur.next) {
      builder.append(cur.value);
      if (cur.next != null) {
        builder.append("->");
      }
    }

    return builder.toString();
  }
}

class Node {

  public int value;
  public Node next;

  public Node(int value) {
    this.value = value;
  }
}
