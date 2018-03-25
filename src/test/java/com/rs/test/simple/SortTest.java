package com.rs.test.simple;

import com.rs.test.Base;
import org.junit.Test;

import java.util.Arrays;

public class SortTest extends Base {

  /**
   * 冒泡排序
   */
  @Test
  public void testBubbleSort() {
    println(bubbleSort(_getRandom()));
  }

  int[] bubbleSort(int[] t) {
    boolean exchange = true;
    for (int i = 1; i < t.length && exchange; i++) {
      exchange = false;

      for (int j = 0; j < t.length - i; j++) {
        if (t[j] > t[j + 1]) {
          int temp = t[j + 1];
          t[j + 1] = t[j];
          t[j] = temp;

          exchange = true;
        }
      }
    }

    return t;
  }

  /**
   * 插入排序
   */
  @Test
  public void insertSort() {
    int[] t = _getRandom(7);
    println(insertSort(t));
  }

  private int[] insertSort(int[] t) {
    for (int i = 1; i < t.length; i++) {
      int temp = t[i], j;
      for (j = i - 1; j >= 0 && t[j] > temp; j--) {
        t[j + 1] = t[j];
      }
      t[j + 1] = temp;
    }
    return t;
  }

  /**
   * 快速排序
   */
  @Test
  public void testQuickSort() {
    int[] t = _getRandom();
    println(quickSort(t, 0, t.length - 1));
  }

  int[] quickSort(int[] t, int low, int high) {
    if (low >= high) {
      return t;
    }

    int i = low, j = high;
    int vot = t[i]; // 基准数, i空出
    while (i < j) {
      while (t[j] >= vot && i < j) {
        j--;
      }
      if (i < j) {
        t[i] = t[j]; // i赋值, j空出
        i++;
      }

      while (t[i] <= vot && i < j) {
        i++;
      }
      if (i < j) {
        t[j] = t[i]; // j赋值, i空出
        j--;
      }
    }

    // i == j
    t[i] = vot;

    quickSort(t, low, i - 1);
    quickSort(t, i + 1, high);

    return t;
  }

  /**
   * 归并排序
   */
  @Test
  public void testMergeSort() {
    int[] x = _getRandom(9);
    int[] y = new int[x.length];

    for (int n = 1; n < x.length; n *= 2) {
      mergeSort(x, y, n);
    }

    println(x);
  }

  private void mergeSort(int[] x, int[] y, int n) {
    int i = 0;
    while ((i + n) < x.length) {
      mergeSort(x, y, i, i + n, n);
      i += 2 * n;
    }

    while (i < x.length) {
      y[i] = x[i++];
    }

    for (i = 0; i < x.length; i++) {
      x[i] = y[i];
    }
    println(n + " = " + Arrays.toString(x));
  }

  private void mergeSort(int[] x, int[] y, int m, int r, int n) {
    int i = m, j = r, k = m;
    while (i < r && j < r + n && j < x.length) {
      if (x[i] <= x[j]) {
        y[k++] = x[i++];
      } else {
        y[k++] = x[j++];
      }
    }

    while (i < r) {
      y[k++] = x[i++];
    }
    while (j < r + n && j < x.length) {
      y[k++] = x[j++];
    }
  }

  private int[] _getRandom() {
    return _getRandom(8);
  }

  private int[] _getRandom(int n) {
    if (n < 6) {
      n = 6;
    }

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = (int) (Math.random() * 100 + 1);
    }

    println(Arrays.toString(arr));
    return arr;
  }


}
