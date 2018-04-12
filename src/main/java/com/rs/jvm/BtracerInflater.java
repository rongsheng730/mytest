package com.rs.jvm;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;

/**
 * TODO
 *
 * @author rongsheng
 * @date 2018/4/12下午6:31
 */
@BTrace
public class BtracerInflater {

  @OnMethod(
      clazz = "java.util.zip.Inflater",
      method = "/.*/"
  )
  public static void traceCacheBlock() {
    System.out.println("Who call java.util.zip.Inflater's methods :");
    BTraceUtils.jstack();
  }
}