package com.jimzhang.convert;

/**
 * 〈一句话功能简述〉<br> 〈〉
 *
 * @author zhangjinmiao
 * @create 2019/8/19 11:58
 */
public class Hosting {

  private int Id;
  private String name;
  private long websites;


  public Hosting(int id, String name, long websites) {
    Id = id;
    this.name = name;
    this.websites = websites;
  }

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getWebsites() {
    return websites;
  }

  public void setWebsites(long websites) {
    this.websites = websites;
  }
}
