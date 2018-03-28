package com.rs.test.patterns.creational;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * builder(建造者模式)
 *     将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * 适用性：
 *     创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式。
 *     构造过程必须允许被构造的对象有不同的表示。
 * 效果：
 *     可以改变一个产品的内部表示
 *     将构造代码和表示代码分开
 *     对构造过程进行更精细的控制
 * 相关模式：
 *     AbstractFactory与Builder相似，因为它也可以创建复杂对象。
 *         Builder模式着重于一步步构造一个复杂对象，在最后一步返回产品；
 *         AbstractFactory着重于多个系列的产品对象（简单的或是复杂的），产品是立即返回的。
 *     Composite通常是用Builder生成的。
 * </pre>
 */
public class Builder {

  @Test
  public void test() {
    Director director = new Director();

    ProductBuilder builder = new ConcreteBuilder1();
    director.construct(builder);
    Product product = builder.getProduct();
    product.show();

    builder = new ConcreteBuilder2();
    director.construct(builder);
    product = builder.getProduct();
    product.show();
  }
}

// product
class Product {
  List<String> parts = new ArrayList<String>();

  public void addPart(String part) {
    parts.add(part);
  }

  public void show() {
    for (String part : parts) {
      System.out.println(part);
    }
  }
}

// builder
abstract class ProductBuilder {
  public abstract void builderPartA();

  public abstract void builderPartB();

  public abstract Product getProduct();
}

class ConcreteBuilder1 extends ProductBuilder {
  Product product = new Product();

  public void builderPartA() {
    product.addPart("部件A");
  }

  public void builderPartB() {
    product.addPart("部件B");
  }

  public Product getProduct() {
    return product;
  }
}

class ConcreteBuilder2 extends ProductBuilder {
  Product product = new Product();

  public void builderPartA() {
    product.addPart("部件X");
  }

  public void builderPartB() {
    product.addPart("部件Y");
  }

  public Product getProduct() {
    return product;
  }
}

// director
/*
 * 指挥者类
 */
class Director {
  public void construct(ProductBuilder builder) {
    builder.builderPartA();
    builder.builderPartB();
  }
}