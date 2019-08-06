package com.jimzhang.collectors;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 〈 Group by the name + Count or Sum the Qty.〉
 *
 * @author zhangjinmiao
 * @create 2019/8/6 22:01
 */
public class Test2 {

  public static void main(String[] args) {
    List<Item> items = Arrays.asList(
        new Item("apple", 10, new BigDecimal("9.99")),
        new Item("banana", 20, new BigDecimal("19.99")),
        new Item("orang", 10, new BigDecimal("29.99")),
        new Item("watermelon", 10, new BigDecimal("29.99")),
        new Item("papaya", 20, new BigDecimal("9.99")),
        new Item("apple", 10, new BigDecimal("9.99")),
        new Item("banana", 10, new BigDecimal("19.99")),
        new Item("apple", 20, new BigDecimal("9.99"))
    );

    Map<String, Long> couting = items.stream()
        .collect(Collectors.groupingBy(Item::getName, Collectors.counting()));

    System.out.println(couting);

    System.out.println("======");

    Map<String, Integer> sum = items.stream()
        .collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

    System.out.println(sum);

    System.out.println("=====>group by price:");
    // group by price
    Map<BigDecimal, List<Item>> groupByPriceMap = items.stream()
        .collect(Collectors.groupingBy(Item::getPrice));

    System.out.println(groupByPriceMap);

    Map<BigDecimal, Set<String>> collect = items.stream().collect(Collectors
        .groupingBy(Item::getPrice, Collectors.mapping(Item::getName, Collectors.toSet())));

    System.out.println("=====>group by + mapping to Set:");
    System.out.println(collect);

  }
}
