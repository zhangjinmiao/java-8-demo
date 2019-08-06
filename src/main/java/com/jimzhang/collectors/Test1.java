package com.jimzhang.collectors;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 〈分组、计数和排序〉
 *
 * @author zhangjinmiao
 * @create 2019/8/6 21:08
 */
public class Test1 {

  public static void main(String[] args) {
    List<String> items = Arrays.asList("apple", "apple", "banana",
        "apple", "orange", "banana", "papaya");
    // 分组
    groupBy(items);

    System.out.println("=======");

    // 分组并排序
    groupByAndSort(items);

  }


  private static void groupBy(List<String> items) {
    Map<String, Long> result = items.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    System.out.println(result);
  }

  private static void groupByAndSort(List<String> items) {

    Map<String, Long> result = items.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    Map<String, Long> finalMap = new LinkedHashMap<>();

    result.entrySet().stream()
        .sorted(Entry.<String,Long>comparingByValue().reversed()).forEachOrdered(e->finalMap.put(e.getKey(),e.getValue()));

    System.out.println(finalMap);
  }

}
