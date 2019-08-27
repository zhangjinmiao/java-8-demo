package com.jimzhang.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

/**
 * 〈一句话功能简述〉<br> 〈过滤一个 Map 示例〉
 *
 * @author zhangjinmiao
 * @create 2019/8/26 15:37
 */
public class MapTest {

  public static void main(String[] args) {


//    beforeJava8();
//    java8();

//    one();

//    two();

    three();
  }

  // 提取公共校验为谓语
  public static <K, V> Map<K, V> filterByValue(Map<K, V> map, Predicate<V> predicate) {
    return map.entrySet().stream()
        .filter(x->predicate.test(x.getValue()))
        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

  }
  private static void three() {

    Map<Integer, String> HOSTING = new HashMap<>();
    HOSTING.put(1, "linode.com");
    HOSTING.put(2, "heroku.com");
    HOSTING.put(3, "digitalocean.com");
    HOSTING.put(4, "aws.amazon.com");
    HOSTING.put(5, "aws2.amazon.com");

    //  {1=linode.com}
    Map<Integer, String> filteredMap = filterByValue(HOSTING, x->x.contains("linode"));
    System.out.println(filteredMap);

    // {1=linode.com, 4=aws.amazon.com, 5=aws2.amazon.com}
    Map<Integer, String> filteredMap2 = filterByValue(HOSTING, x -> (x.contains("aws") || x.contains("linode")));
    System.out.println(filteredMap2);

    // {4=aws.amazon.com}
    Map<Integer, String> filteredMap3 = filterByValue(HOSTING, x -> (x.contains("aws") && !x.contains("aws2")));
    System.out.println(filteredMap3);

    // {1=linode.com, 2=heroku.com}
    Map<Integer, String> filteredMap4 = filterByValue(HOSTING, x -> (x.length() <= 10));
    System.out.println(filteredMap4);
  }

  private static void two() {
    Map<Integer, String> HOSTING = new HashMap<>();
    HOSTING.put(1, "linode.com");
    HOSTING.put(2, "heroku.com");
    HOSTING.put(3, "digitalocean.com");
    HOSTING.put(4, "aws.amazon.com");

    //Map -> Stream -> Filter -> Map
    Map<Integer, String> collect = HOSTING.entrySet().stream().filter(map -> map.getKey() == 2)
        .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

    System.out.println(collect);

    Map<Integer, String> collect1 = HOSTING.entrySet().stream().filter(map -> map.getKey() <= 3)
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

    System.out.println(collect1);
  }

  private static void one() {
    Map<Integer, String> HOSTING = new HashMap<>();
    HOSTING.put(1, "linode.com");
    HOSTING.put(2, "heroku.com");
    HOSTING.put(3, "digitalocean.com");
    HOSTING.put(4, "aws.amazon.com");

    // Before Java 8
    String result = "";
    for (Map.Entry<Integer, String> entry : HOSTING.entrySet()) {
      if ("aws.amazon.com".equals(entry.getValue())) {
        result = entry.getValue();
      }
    }
    System.out.println("Before Java 8 : " + result);


    //Map -> Stream -> Filter -> String
    result = HOSTING.entrySet().stream()
        .filter(map -> "aws.amazon.com".equals(map.getValue()))
        .map(map -> map.getValue())
        .collect(Collectors.joining());

    System.out.println("With Java 8 : " + result);


    // filter more values
    result = HOSTING.entrySet().stream().filter(x -> {
      if(!x.getValue().contains("amazon") && !x.getValue().contains("digital")) {
        return true;
      }
      return false;
    }).map(map -> map.getValue()).collect(Collectors.joining(","));

    System.out.println("With Java 8 : " + result);
  }



  private static void java8() {
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "linode.com");
    map.put(2, "heroku.com");

    //Map -> Stream -> Filter -> String
    String result = map.entrySet().stream().filter(x -> "something".equals(x.getValue()))
        .map(x -> x.getValue()).collect(Collectors.joining());

    //Map -> Stream -> Filter -> MAP
    Map<Integer, String> collect = map.entrySet().stream().filter(x -> x.getKey() == 2)
        .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

    // or like this
    Map<Integer, String> collect1 = map.entrySet().stream().filter(x -> x.getKey() == 3)
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

  }

  private static void beforeJava8() {
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "linode.com");
    map.put(2, "heroku.com");

    String result = "";
    for (Map.Entry<Integer, String> entry : map.entrySet()) {
      if("something".equals(entry.getValue())){
        result = entry.getValue();
      }
    }
  }

}
