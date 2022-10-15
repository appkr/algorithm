package dev.appkr.algorithm.list3;

public class SumOfLinkedListKata {

  public static void main(String[] args) {
    final LinkedList list1 = new LinkedList();
    list1.add(new Node(1));
    list1.add(new Node(2));
    list1.add(new Node(3));

    final LinkedList list2 = new LinkedList();
    list2.add(new Node(6));
    list2.add(new Node(7));
    list2.add(new Node(8));

    System.out.println("Original lists:");
    list1.print();
    list2.print();

    LinkedList list3 = list1.sum(list2);
    System.out.println("Sum of the two lists:");
    list3.print();
  }

  static class LinkedList {
    Node first;
    Node last;

    public void add(Node node) {
      if (first == null) {
        first = node;
      } else {
        last.next = node;
      }

      last = node;
    }

    public LinkedList sum(LinkedList that) {
      // (reverse) 3 2 1
      // (reverse) 8 7 6
      // 1 0 8 => (reverse) 8 0 1

      this.reverse();
      that.reverse();

      final LinkedList product = new LinkedList();

      int carry = 0;
      Node nodeA = this.first, nodeB = that.first;
      for (; nodeA != null; nodeA = nodeA.next) {
        // 합을 구한다
        int tmp = nodeA.value + nodeB.value + carry;

        // carry 초기화
        carry = 0;
        if (tmp >= 10) {
          carry++;
          tmp %= 10;
        }

        // 10이하 자연수로 새 노드 생성
        product.add(new Node(tmp));

        // nodeA, nodeB 증가
        nodeB = nodeB.next;
      }

      product.reverse();

      return product;
    }

    public void reverse() {
      Node reversed = null;
      Node cur = first;
      Node originalNext = null;
      while (cur != null) {
        originalNext = cur.next;  // cur의 next를 임시 변수에 담아둔다
        cur.next = reversed;      // cur의 next가 reversed를 가리키도록 한다
        reversed = cur;           // reversed에 cur을 할당
        cur = originalNext;       // cur에 임시 변수에 담았던 값을 할당
      }

      first = reversed;
    }

    public void print() {
      final StringBuilder builder = new StringBuilder();
      for (Node cur = first; cur != null; cur = cur.next) {
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
