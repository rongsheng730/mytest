package com.rs.jvm;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * TODO
 *
 * @author rongsheng
 * @date 2018/4/12下午6:24
 */
public class TestUnsafeMemo {

  public static void main(String[] args) throws Exception {
    Field f = null;
    Unsafe unsafe = null;
    try {
      f = Unsafe.class.getDeclaredField("theUnsafe");
      f.setAccessible(true);
      unsafe = (Unsafe) f.get(null);
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    int size = Integer.MAX_VALUE >> 2;
    long allocatedAddress = unsafe.allocateMemory(size);
    for (int i = 0; i < size; i++) {
      unsafe.putByte(allocatedAddress + i, (byte) 100);
      byte shortValue = unsafe.getByte(allocatedAddress);
      if (shortValue != 100) {
        System.out.println(
            new StringBuilder().append("Address:").append(allocatedAddress).append(" Value:")
                .append(shortValue));
      }
    }
    Thread.sleep(1000 * 60 * 20);
  }
}
