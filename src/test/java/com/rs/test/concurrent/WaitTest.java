package com.rs.test.concurrent;

import com.rs.test.Base;
import org.junit.Test;

/**
 * 两个线程，顺序打印奇偶数
 */
public class WaitTest extends Base {

  @Test
  public void test() throws InterruptedException {
    Lock lock = new Lock();
    new Thread(new NumRunnable(lock, true)).start();
    new Thread(new NumRunnable(lock, false)).start();
    Thread.sleep(3 * 1000);
  }

  class Lock {
    int num = 1;
    boolean flag;

    public Lock() {
    }
  }


  class NumRunnable implements Runnable {
    Lock lock;
    boolean odd; // 奇数/偶数

    public NumRunnable(Lock lock, boolean odd) {
      this.lock = lock;
      this.odd = odd;
    }

    public void run() {
      synchronized (lock) {
        while (lock.num <= 100) {
          println(odd + "=" + lock.flag + "=" + lock.num);
          if (odd == lock.flag) {
            println(lock.num++);
            lock.flag = !lock.flag;
            lock.notify();
          } else {
            try {
              lock.wait();
            } catch (InterruptedException e) {
            }
          }
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          println(odd + "_" + lock.flag + "_" + lock.num);
        }
      }
    }
  }

}
