package com.rs.test.patterns.creational;

import org.junit.Test;

/**
 * <pre>
 * Factory Method（工厂方法）
 *     定义一个用于创建对象的接口，让子类决定实例化哪一个类。Factory Method使一个类的实例化延迟到其子类。
 * 适用性：
 *     一个类不知道它所必须创建的对象的类。
 *     一个类希望由它的子类来指定它创建的对象。
 *     类将创建对象的职责委托给多个帮助子类中的一个，并且希望将某一个帮助子类是代理者这一信息局部化。
 * 效果（优点和缺点）：
 *     为子类提供挂钩（hook）
 *     连接平行的类层次
 * 相关模式：
 *     Abstract Factory 经常用工厂方法来实现。
 *     工厂方法通常在Template Methods中被调用。
 *     Prototypes不需要创建Creator的子类。但是，它们通常要求一个针对Product类的Initialize操作。Creator使用Initialize来初始化对象。而Factory Method不需要这样的操作。
 * </pre>
 */
public class FactoryMethod {

  @Test
  public void test() {
    LeifengFactory factory = new UndergraduateFactory();
    Leifeng leifeng = factory.createLeifeng();
    leifeng.buyRice();
    leifeng.sweep();
    leifeng.wash();
  }
}

// product
class Leifeng {
  public void sweep() {
  } // 扫地

  public void wash() {
  } // 洗衣

  public void buyRice() {
  } // 买米
}


class Volunteer extends Leifeng {
  // 志愿者
}

class Undergraduate extends Leifeng {
  // 学雷锋的大学生
}

// factory
interface LeifengFactory {
  Leifeng createLeifeng();
}

class UndergraduateFactory implements LeifengFactory {
  public Leifeng createLeifeng() {
    return new Undergraduate();
  }
}

class VolunteerFactory implements LeifengFactory {
  public Leifeng createLeifeng() {
    return new Volunteer();
  }
}