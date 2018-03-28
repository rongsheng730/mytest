package com.rs.test.patterns.creational;

import org.junit.Test;

/**
 * <pre>
 * prototype(原型)
 *     用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 * 适用性：
 *
 * 效果（优点和缺点）：
 *
 * 相关模式：
 *     Prototype和Abstract Facotry模式在某种方面是相互单键的。但是它们也可以一起使用。Abstract Facotry可以存储一个被克隆的原型的集合，并且返回产品对象。
 *     大量使用Composite和Decorator模式的设计通常也可以从Prototype模式处获益。
 * </pre>
 */
public class Prototype {

  @Test
  public void test() throws CloneNotSupportedException {
    School school = new School();
    school.name = "ali";

    Student student = new Student();
    student.name = "张三";
    student.school = school;

    System.out.println(student);

    Student copy = (Student) student.clone();
    System.out.println(copy);

    school.name = "mt";
    System.out.println(copy);
  }
}

class Student implements Cloneable {
  String name;
  School school;

  @Override
  public String toString() {
    return "student name : " + name + ", " + school;
  }

  @Override
  protected Student clone() throws CloneNotSupportedException {
    // 浅复制
    //return super.clone();

    // 深复制
    Student s = (Student) super.clone();
    s.school = (School) s.school.clone();
    return s;
  }
}

class School implements Cloneable {
  String name;

  @Override
  public String toString() {
    return "school name : " + name;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
