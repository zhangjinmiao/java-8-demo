package com.jimzhang.convert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 〈Java 8 – Convert List to Map〉
 *
 * @author zhangjinmiao
 * @create 2019/8/19 11:58
 */
public class ListToMap {

  public static void main(String[] args) {

//    testOne();

//    testTwo();

    testThree();
  }




  public static void testOne(){
    List<Hosting> list = new ArrayList<>();
    list.add(new Hosting(1, "liquidweb.com", 80000));
    list.add(new Hosting(2, "linode.com", 90000));
    list.add(new Hosting(3, "digitalocean.com", 120000));
    list.add(new Hosting(4, "aws.amazon.com", 200000));
    list.add(new Hosting(5, "mkyong.com", 1));

    // key = id, value - websites
    Map<Integer, String> result1 = list.stream()
        .collect(Collectors.toMap(Hosting::getId, Hosting::getName));

    System.out.println("result1：" + result1);

    // key = name, value - websites
    Map<String, Long> result2 = list.stream()
        .collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites));

    System.out.println("result2：" + result2);

    // key = id, value = name 另一种写法
    Map<Integer, String> result3 = list.stream()
        .collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));

    System.out.println("result3：" + result3);
  }

  private static void testTwo() {

    List<Hosting> list = new ArrayList<>();
    list.add(new Hosting(1, "liquidweb.com", 80000));
    list.add(new Hosting(2, "linode.com", 90000));
    list.add(new Hosting(3, "digitalocean.com", 120000));
    list.add(new Hosting(4, "aws.amazon.com", 200000));
    list.add(new Hosting(5, "mkyong.com", 1));

    list.add(new Hosting(6, "linode.com", 100000)); // new line

//    Map<String, Long> result1 = list.stream()
//        .collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites));

    // use oldValue
//    Map<String, Long> result1 = list.stream().collect(
//        Collectors.toMap(Hosting::getName, Hosting::getWebsites, (oldValue, newValue) -> oldValue));

    // use newValue
    Map<String, Long> result1 = list.stream().collect(
        Collectors.toMap(Hosting::getName, Hosting::getWebsites, (oldValue, newValue) -> newValue));

    System.out.println("result1：" + result1);
  }

  private static void testThree() {
    List<Hosting> list = new ArrayList<>();
    list.add(new Hosting(1, "liquidweb.com", 80000));
    list.add(new Hosting(2, "linode.com", 90000));
    list.add(new Hosting(3, "digitalocean.com", 120000));
    list.add(new Hosting(4, "aws.amazon.com", 200000));
    list.add(new Hosting(5, "mkyong.com", 1));
    list.add(new Hosting(6, "linode.com", 100000));

    Map<String, Long> result1 = list.stream().sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
        .collect(Collectors.toMap(Hosting::getName,Hosting::getWebsites,(oldValue, newValue) -> oldValue,
            LinkedHashMap::new));

    System.out.println("result1：" + result1);
  }
}
