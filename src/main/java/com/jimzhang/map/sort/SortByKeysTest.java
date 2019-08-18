package com.jimzhang.map.sort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 〈Sort by Keys〉
 *
 * @author zhangjinmiao
 * @create 2019/8/8 11:01
 */
public class SortByKeysTest {

  public static void main(String[] args) {
    Map<String, Integer> unsortMap = new HashMap<>();
    unsortMap.put("z", 10);
    unsortMap.put("b", 5);
    unsortMap.put("a", 6);
    unsortMap.put("c", 20);
    unsortMap.put("d", 1);
    unsortMap.put("e", 7);
    unsortMap.put("y", 8);
    unsortMap.put("n", 99);
    unsortMap.put("g", 50);
    unsortMap.put("m", 2);
    unsortMap.put("f", 9);

    System.out.println("Original...");
    System.out.println(unsortMap);

    // sort by keys, a,b,c..., and return a new LinkedHashMap
    // toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.
    LinkedHashMap<String, Integer> result = unsortMap.entrySet().stream()
        .sorted(Entry.comparingByKey())
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (oldValue, newValue) -> oldValue,
                LinkedHashMap::new));

    // 不推荐，但是很有效。

    Map<String, Integer> result2 = new LinkedHashMap<>();
    unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
        .forEachOrdered(x->result2.put(x.getKey(),x.getValue()));

    System.out.println("Sorted...");
    System.out.println(result);
    System.out.println(result2);
  }
}
