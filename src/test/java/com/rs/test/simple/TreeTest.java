package com.rs.test.simple;

import com.rs.test.Base;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTest extends Base {

  /**
   * 二叉树按层级打印
   */
  @Test
  public void testSortLevel() {
    Tree left = new Tree(2, 4, 5);
    Tree right = new Tree(3, 6, 7);
    Tree root = new Tree(1, left, right);

    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while (queue.size() > 0) {
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        Node node = queue.poll();
        System.out.print(node.value);

        if (null != node.left) {
          queue.add(node.left);
        }
        if (null != node.right) {
          queue.add(node.right);
        }
      }
      println("");
    }
  }

  class Tree extends Node {

    public Tree(int value) {
      super(value);
    }

    public Tree(int value, int left, int right) {
      this(value);
      this.left = new Tree(left);
      this.right = new Tree(right);
    }

    public Tree(int value, Node left, Node right) {
      this(value);
      this.left = left;
      this.right = right;
    }

  }

  class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value + "";
    }
  }
}
