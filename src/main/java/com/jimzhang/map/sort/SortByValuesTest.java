package com.jimzhang.map.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 〈Sort by Values〉
 *
 * @author zhangjinmiao
 * @create 2019/8/16 17:47
 */
public class SortByValuesTest {

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

    //sort by values, and reserve it, 10,9,8,7,6...
    LinkedHashMap<String, Integer> result = unsortMap.entrySet().stream()
        .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (oldValue, newValue) -> oldValue,
                LinkedHashMap::new));

    // 替代方式
    Map<String, Integer> result2 = new LinkedHashMap<>();
    unsortMap.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

    System.out.println("Sorted...");
    System.out.println(result);
    System.out.println(result2);
  }
}
