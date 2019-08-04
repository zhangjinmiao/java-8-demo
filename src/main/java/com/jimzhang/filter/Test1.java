package com.jimzhang.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 〈filter() and collect()〉
 *
 * @author zhangjinmiao
 * @create 2019/8/4 14:42
 */
public class Test1 {




  public static void main(String[] args) {
//    beforeJava8();

    afterJava8();
  }

  private static void afterJava8() {
    List<String> lines = Arrays.asList("spring", "node", "php");

    List<String> result = lines.stream()          // convert list to stream
        .filter(line -> !"php".equals(line))      // we dont like php
        .collect(Collectors.toList());            // collect the output and convert streams to a List

    result.forEach(System.out::println);          //output : spring, node
  }

  private static void beforeJava8() {
    List<String> lines = Arrays.asList("spring", "node", "php");

    List<String> result = getFilterOutput(lines, "php");
    for (String temp : result) {
      System.out.println(temp);    //output : spring, node
    }
  }

  private static List<String> getFilterOutput(List<String> lines, String filter) {
    List<String> result = new ArrayList<>();
    for (String line : lines) {
      if (!"php".equals(line)) { // we dont like php
        result.add(line);
      }
    }
    return result;
  }
}
