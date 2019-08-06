package com.jimzhang.collectors;

import java.math.BigDecimal;

/**
 * 〈一句话功能简述〉<br> 〈〉
 *
 * @author zhangjinmiao
 * @create 2019/8/6 21:26
 */
public class Item {

  private String name;
  private int qty;
  private BigDecimal price;

  public Item(String name, int qty, BigDecimal price) {
    this.name = name;
    this.qty = qty;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Item{" + "name='" + name + '\'' + ", qty=" + qty + ", price=" + price + '}';
  }
}
