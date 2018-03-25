package com.rs.test.concurrent;

import com.rs.test.Base;
import org.junit.Test;

import java.util.concurrent.*;

public class ExecutorTest extends Base {

  /**
   * 测试超过线程池大小
   */
  @Test
  public void testOver() throws Exception {
    //ExecutorService executorService = Executors.newFixedThreadPool(3);
    ExecutorService executorService = new ThreadPoolExecutor(3, 3,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>()) {
      @Override
      public Future<?> submit(Runnable task) {
        println("___添加新的线程:" + task);
        return super.submit(task);
      }
    };
    for (int i = 0; i < 10000; i++) {
      executorService.submit(newSleep(i + "", 100));
    }
    Thread.sleep(4 * 1000);
  }

  @Test
  public void testException() throws Exception {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    Future<?> future = executorService.submit(newExp());
    future.get();
    Thread.sleep(3 * 1000);
  }

  @Test
  public void testException2() throws Exception {
    try {
      new Thread(newExp()).start();
    } catch (Exception e) {
      println(e.getMessage());
    }
    Thread.sleep(3 * 1000);
  }

  Runnable newSleep(final String name, final int second) {
    return new Runnable() {
      public void run() {
        println("开始执行" + name + "线程...");
        try {
          Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        println("线程" + name + "线执行结束.");
      }

      @Override
      public String toString() {
        return name;
      }
    };
  }

  Runnable newExp() {
    return new Runnable() {
      public void run() {
        int i = 1 / 0;
      }
    };
  }

}
