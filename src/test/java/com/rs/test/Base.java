package com.rs.test;

import java.util.Arrays;

public class Base {

  protected void println(int[] arr) {
    println(Arrays.toString(arr));
  }

  protected void println(Object object) {
    System.out.println(object);
  }

}
