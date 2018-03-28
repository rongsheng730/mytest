package com.rs.test.patterns.creational;

import org.junit.Test;

/**
 * <pre>
 * Singleton（单例模式）：
 *     保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 适用性：
 *     类只能有一个实例而且客户可以从一个众所周知的访问点访问它。
 *     这个唯一实例应该是通过子类化可扩展的，并且客户应该无需更改代码就能使用一个扩展的实例。
 * 效果（优点和缺点）：
 *     对唯一实例的受控访问
 *     缩小名空间
 *     允许对操作和表示的变化
 *     允许可变数目的实例
 *     比类操作更灵活
 * 相关模式：
 *
 * </pre>
 */
public class Singleton {

  @Test
  public void test() {

  }
}

/*
 * 1. 懒汉式
 */
class LazySingleton {
  private static LazySingleton instance;

  private LazySingleton() {
  }

  public static synchronized LazySingleton getInstance() {
    if (instance == null) {
      instance = new LazySingleton();
    }
    return instance;
  }
}

/*
 * 2. 饿汉式
 */
class HungrySingleton {
  private static HungrySingleton instance = new HungrySingleton();

  private HungrySingleton() {
  }

  public static HungrySingleton getInstance() {
    return instance;
  }
}

/*
 * 3. 静态内部类
 */
class InnerClassSingleton {
  private InnerClassSingleton() {
  }

  public static InnerClassSingleton getInstance() {
    return SingletonHolder.instance;
  }

  private static class SingletonHolder {
    private static InnerClassSingleton instance = new InnerClassSingleton();
  }
}

/*
 * 4. 枚举
 */
enum EnumSingleton {
  INSTANCE;
}


/*
 * 5. 双重校验
 */
class DoubleCheckSingleton {
  private volatile static DoubleCheckSingleton instance;

  private DoubleCheckSingleton() {
  }

  public static DoubleCheckSingleton getInstance() {
    if (instance == null) {
      synchronized (DoubleCheckSingleton.class) {
        if (instance == null) {
          instance = new DoubleCheckSingleton();
        }
      }
    }
    return instance;
  }
}