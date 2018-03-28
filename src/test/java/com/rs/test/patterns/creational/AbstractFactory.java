package com.rs.test.patterns.creational;

import org.junit.Test;

/**
 * <pre>
 * abstract factory(抽象工厂)：
 *     提供一个创建一系列相关或互相依赖对象的接口，而无需指定它们具体的类。
 * 适用性：
 *     一个系统要独立于它的产品的创建、组合和表示。
 *     一个系统要由多个产品系列中的一个来配置。
 *     要强调一系列相关的产品对象的设计以便进行联合使用。
 *     提供一个产品类库，而只想显示它们的接口而不是实现。
 * 效果（优点和缺点）：
 *     分享了具体的类
 *     使得易于交换产品系统
 *     有利于产品的一致性
 *     难以支持新种类的产品：支持新各类的产品就需要扩展该工厂接口，这将涉及abstract factory及其所有子类的改变。
 * 相关模式：
 *     AbstractFactory类通常用工厂方法(Facotry Method)实现，但它们也可以用Prototype实现。
 *     一个具体的工厂通常是一个单例(Singleton)
 * </pre>
 */
public class AbstractFactory {

  @Test
  public void test() {
    Factory factory = new MysqlFactory();
    //Factory factory = new OracleFactory();

    IUser user = factory.createUser();
    user.insert(new User());
    user.get(1L);

    IDept dept = factory.createDept();
    dept.insert(new Dept());
    dept.get(1L);
  }
}

// factory
interface Factory {
  IUser createUser();

  IDept createDept();
}

class MysqlFactory implements Factory {
  public IUser createUser() {
    return new MysqlUser();
  }

  public IDept createDept() {
    return new MysqlDept();
  }
}

class OracleFactory implements Factory {
  public IUser createUser() {
    return new OracleUser();
  }

  public IDept createDept() {
    return new OracleDept();
  }
}

// User
class User {
}

interface IUser {
  void insert(User user);

  User get(long id);
}

class MysqlUser implements IUser {
  public void insert(User user) {
  }

  public User get(long id) {
    return null;
  }
}

class OracleUser implements IUser {
  public void insert(User user) {
  }

  public User get(long id) {
    return null;
  }
}

// Dept
class Dept {
}

interface IDept {
  void insert(Dept dept);

  Dept get(long id);
}

class MysqlDept implements IDept {
  public void insert(Dept dept) {
  }

  public Dept get(long id) {
    return null;
  }
}

class OracleDept implements IDept {
  public void insert(Dept dept) {
  }

  public Dept get(long id) {
    return null;
  }
}