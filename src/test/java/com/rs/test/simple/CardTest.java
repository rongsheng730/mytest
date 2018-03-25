package com.rs.test.simple;

import com.rs.test.Base;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 头条面试题：翻牌游戏
 */
public class CardTest extends Base {

  /**
   * 1234567 -> 1357426 -> 1546732 -> 1(1-1)5(2-3)4(3-5)6(4-7)7(5-4)3(6-2)2(7-6)
   */
  @Test
  public void test() throws InterruptedException {
    int[] s = new int[]{1, 2, 3, 4, 5, 6, 7}; // 原始顺序：1234567
    Queue<Integer> queue = new LinkedList<Integer>();
    for (int i : s) {
      queue.add(i);
    }

    boolean odd = true;
    StringBuilder sb = new StringBuilder();
    while (queue.size() > 0) {
      int v = queue.poll();
      if (odd) {
        sb.append(v);
        odd = !odd;
      } else {
        queue.add(v);
        odd = !odd;
      }
      //println(queue + " -> " + sb);
      Thread.sleep(100);
    }

    println(sb); // 翻出顺序：1357426
  }

  /**
   * 根据翻出顺序，进行顺序还原
   */
  @Test
  public void test2() {
    int[] s = new int[]{1, 3, 5, 7, 4, 2, 6};
    Queue<Node> queue = new LinkedList<Node>();
    for (int i = 0; i < s.length; i++) {
      queue.add(new Node(s[i], i));
    }

    boolean odd = true;
    List<Node> list = new ArrayList<Node>(s.length);
    while (queue.size() > 0) {
      Node node = queue.poll();
      if (odd) {
        node.newIndex = list.size();
        list.add(node);
        odd = !odd;
      } else {
        queue.add(node);
        odd = !odd;
      }
    }

    int[] newArr = new int[s.length];
    for (Node node : list) {
      newArr[node.oldIndex] = s[node.newIndex]; // 该行为重点实现思路
    }
    println(newArr);
  }

  class Node {
    int value;
    int oldIndex;
    int newIndex;

    public Node(int value, int oldIndex) {
      this.value = value;
      this.oldIndex = oldIndex;
    }

  }

}
