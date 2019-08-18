package com.jimzhang.map.sort;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 〈Map<Object,Object>〉
 *
 * @author zhangjinmiao
 * @create 2019/8/16 17:57
 */
public class ObjectTest {

  public static void main(String[] args) {
    Properties properties = System.getProperties();
    Set<Entry<Object, Object>> entries = properties.entrySet();

    LinkedHashMap<String, String> collect = entries.stream()
        .collect(Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue()))
        .entrySet()
        .stream().sorted(Entry.comparingByKey())
        .collect(Collectors
            .toMap(Entry::getKey, Entry::getValue, (oldValue, newValue) -> oldValue,
                LinkedHashMap::new));

    collect.forEach((k,v)->System.out.println(k + ":" + v));
  }
}
