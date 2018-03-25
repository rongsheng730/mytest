package com.rs.test.simple;

import com.rs.test.Base;
import org.junit.Before;
import org.junit.Test;


public class LinkTest extends Base {
  Node root;

  /**
   * 单链表倒排序
   */
  @Test
  public void testReverse() {
    println(root);
    println(reverse(root));
  }


  Node reverse(Node node) {
    Node head = null;
    while (null != node) {
      Node cur = node;
      Node next = node.next;

      cur.next = head;
      head = cur;

      node = next;
    }
    return head;
  }

  @Before
  public void before() {
    Node _1 = new Node(1);
    Node _2 = new Node(2);
    Node _3 = new Node(3);
    Node _4 = new Node(4);
    Node _5 = new Node(5);
    _1.next = _2;
    _2.next = _3;
    _3.next = _4;
    _4.next = _5;

    root = _1;
  }

  class Node {
    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append(value);

      if (null != next) {
        sb.append(" -> ").append(next);
      }

      return sb.toString();
    }
  }
}
