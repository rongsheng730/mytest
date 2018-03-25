package com.rs.test.simple;

import com.rs.test.Base;
import org.junit.Test;

public class MapTest extends Base {

  /**
   * hash方式：前16位与后16位异或后，与table.length进行与运算，获得K.hashCode对应的table下标
   */
  @Test
  public void testHash() {
    int[] a = new int[8];
    for (int i = 0; i < 100000; i++) {
      int num = (int) (Math.random() * Integer.MAX_VALUE);
      a[(num ^ (num >>> 16)) & (a.length - 1)] += 1;
    }
    println(a);
  }

}
