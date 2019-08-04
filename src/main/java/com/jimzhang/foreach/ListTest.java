package com.jimzhang.foreach;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 〈遍历 list〉
 *
 * @author zhangjinmiao
 * @create 2019/8/4 11:53
 */
public class ListTest {

  public static void main(String[] args) {
    List<String> items = new ArrayList<>();
    items.add("A");
    items.add("B");
    items.add("C");
    items.add("D");
    items.add("E");

    // before
    for(String item : items){
      System.out.println(item);
    }

    System.out.println("===after java 8===");

    // java 8
    //Output : A,B,C,D,E
    items.forEach(item-> System.out.println(item));

    System.out.println("======");
    //Output : C
    items.forEach(item->{
      if ("C".equals(item)) {
        System.out.println("Hello C");
      }
    });

    System.out.println("======");

    //method reference
    //Output : A,B,C,D,E
    items.forEach(System.out::println);

    System.out.println("======");

    //Stream and filter
    //Output : B
    items.stream()
        .filter(s->s.contains("B"))
        .forEach(System.out::println);

  }
}
