package dev.appkr.algorithm.list2;

public class LinkedListKata {

  public static void main(String[] args) {
    final LinkedList list = new LinkedList();
    list.add(new Node(1));
    list.add(new Node(2));
    list.add(new Node(3));
    list.add(new Node(4));
//    list.remove(7);
    list.reverse();
    list.print();
  }

  static class LinkedList {

    Node head;
    Node last;

    public LinkedList() {
    }

    public void add(Node node) {
      if (head == null) {
        head = node;
      } else {
        last.next = node;
      }
      last = node;
    }

    public int remove(int n) {
      Node prev = null;
      Node el = head;
      for (int i = 0; i < n; i++) {
        if (el == null) {
          throw new IndexOutOfBoundsException(String.format("%d is bigger than list size %d", n, i));
        }
        prev = el;
        el = el.next;
      }

      Node next = el.next;

      if (prev == null) { // el이 처음인 경우
        head = next;
      } else {
        prev.next = next;
      }

      if (next == null) { // el이 마지막인 경우
      } else {
        last = prev;
      }

      return el.value;
    }

    public void reverse() {
      Node reversed = null;
      Node cur = head;
      Node originalNext = null;
      while (cur != null) {
        originalNext = cur.next;  // 임시 변수 할당
        cur.next = reversed;      // next로 가던 화살표를 reversed로 가도록 바꾼다
        reversed = cur;           // (증감식) reserved
        cur = originalNext;       // (증감식) 임시 변수에 담았던 값을 cur에 할당
      }

      head = reversed;
    }

    public void print() {
      final StringBuilder builder = new StringBuilder();
      for (Node cur = head; cur != null; cur = cur.next) {
        builder.append(cur.value);
        if (cur.next != null) {
          builder.append("->");
        }
      }
      System.out.println(builder);
    }
  }

  static class Node {

    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
