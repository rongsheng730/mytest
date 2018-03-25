package com.rs.test.concurrent.lock;

import com.rs.test.Base;
import org.junit.Test;

public class SyncTest extends Base {

  @Test
  public void test() throws Exception {
    a(1);
    Thread.sleep(1 * 1000);
  }

  synchronized void a(int i) {
    println(i);
    a(i + 1);
  }
}
