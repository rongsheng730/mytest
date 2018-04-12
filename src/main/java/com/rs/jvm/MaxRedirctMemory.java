package com.rs.jvm;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO
 *
 * @author rongsheng
 * @date 2018/4/12下午5:50
 */
public class MaxRedirctMemory {

  public static void main(String[] args) {
    try {
      Class c = Class.forName("java.nio.Bits");
      Field maxMemory = c.getDeclaredField("maxMemory");
      maxMemory.setAccessible(true);
      Field reservedMemory = c.getDeclaredField("reservedMemory");
      reservedMemory.setAccessible(true);
      synchronized (c) {
        Long maxMemoryValue = (Long) maxMemory.get(null); // 3817865216 = 3G
        Long reservedMemoryValue = ((AtomicLong) reservedMemory.get(null)).get();
        System.out.println(maxMemoryValue + " " + reservedMemoryValue);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
