package com.rs.test.concurrent;

import com.rs.test.Base;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorTest extends Base {

  /**
   * 线程池有界队列
   */
  @Test
  public void testExceed() {
    // 有界队列
    BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(3);

    // 定义线程名字
    final ThreadFactory threadFactory = new DefaultThreadFactory();

    // 有界超限的拒绝方案
    RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 1, TimeUnit.SECONDS, queue, threadFactory, handler);

    List<Future> list = new ArrayList<Future>();
    for (int i = 1; i <= 10; i++) {
      println("add " + i);
      Runnable run = newRunnable(i + "");
      while (true) {
        try {
          Future<?> submit = threadPoolExecutor.submit(run);
          list.add(submit);
          break;
        } catch (Exception e) {
          println("exceed " + i + ", wait...");
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e2) {
            e2.printStackTrace();
          }
        }
      }
    }

    for (Future fo : list) {
      try {
        fo.get();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    println("end.");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  Runnable newRunnable(final String name) {
    return new Runnable() {
      public void run() {
        try {
          println(name + " start...");
          Thread.sleep(1 * 1000);
          println(name + " finish!");
        } catch (Exception e) {
          e.printStackTrace();
        }

      }

      @Override
      public String toString() {
        return name;
      }
    };
  }

  class DefaultThreadFactory implements ThreadFactory {
    private final AtomicInteger poolNum = new AtomicInteger(1);
    private final AtomicInteger threadNum = new AtomicInteger(1);
    ThreadGroup group;
    String namePrefix;

    public DefaultThreadFactory() {
      group = new ThreadGroup("testGroup");
      namePrefix = "pool-" + poolNum.getAndIncrement() + "-thread-";
    }

    public Thread newThread(Runnable r) {
      String name = namePrefix + threadNum.getAndIncrement();
      Thread t = new Thread(group, r, name, 0);

      if (t.isDaemon())
        t.setDaemon(false);
      if (t.getPriority() != Thread.NORM_PRIORITY)
        t.setPriority(Thread.NORM_PRIORITY);

      return t;
    }

  }


}
