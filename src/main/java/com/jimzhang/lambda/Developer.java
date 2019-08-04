package com.jimzhang.lambda;

import java.math.BigDecimal;

/**
 * 〈一句话功能简述〉<br> 〈〉
 *
 * @author zhangjinmiao
 * @create 2019/8/4 10:15
 */
public class Developer {


  private String name;

  private BigDecimal salary;

  private Integer age;

  public Developer(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public Developer(String name, BigDecimal salary, Integer age) {
    this.name = name;
    this.salary = salary;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Developer{" + "name='" + name + '\'' + ", salary=" + salary + ", age=" + age + '}';
  }
}
