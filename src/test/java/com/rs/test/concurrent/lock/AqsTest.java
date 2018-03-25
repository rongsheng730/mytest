package com.rs.test.concurrent.lock;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AqsTest {

  /**
   * debug 查看源码
   */
  @Test
  public void testSource() {
    CountDownLatch latch = new CountDownLatch(10);
    latch.countDown();
    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test() throws InterruptedException {
    ExecutorService exec = Executors.newFixedThreadPool(10);

    CountDownLatch latch = new CountDownLatch(10);
    for (int i = 1; i <= 10; i++) {
      exec.execute(new Car(i, latch));
    }
    Thread.sleep(5000);
  }

  class Car implements Runnable {
    private int num;
    private CountDownLatch latch;

    Car(int num, CountDownLatch latch) {
      this.num = num;
      this.latch = latch;
    }

    public void run() {
      try {
        latch.countDown();
        latch.await();
        startRun();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    private void startRun() {
      System.out.println(String.format("Car num: %s, running...", num));

      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(String.format("Car num:%s, finish!", num));
    }
  }




}
