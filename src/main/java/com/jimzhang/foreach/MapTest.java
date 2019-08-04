package com.jimzhang.foreach;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 〈循环 map〉
 *
 * @author zhangjinmiao
 * @create 2019/8/4 11:46
 */
public class MapTest {

  public static void main(String[] args) {
    Map<String, Integer> items = new HashMap<>();
    items.put("A", 10);
    items.put("B", 20);
    items.put("C", 30);
    items.put("D", 40);
    items.put("E", 50);
    items.put("F", 60);

    // before
    for (Map.Entry<String,Integer> entry : items.entrySet()) {
      System.out.println("Item：" + entry.getKey() + "，Count：" + entry.getValue());
    }

    System.out.println("===after java 8===");
    // java 8
    items.forEach((k, v)-> System.out.println("Item：" + k + "，Count：" + v));

    System.out.println("=======");

    items.forEach((k, v) -> {
      System.out.println("Item：" + k + "，Count：" + v);
      if (k.equals("E")) {
        System.out.println("Hello E");
      }
    });
  }
}
