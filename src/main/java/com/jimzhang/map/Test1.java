package com.jimzhang.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 〈A List of Strings to Uppercase〉
 *
 * @author zhangjinmiao
 * @create 2019/8/5 20:57
 */
public class Test1 {

  public static void main(String[] args) {
    List<String> alpha = Arrays.asList("a", "b", "c", "d");

    //Before Java8
    List<String> alphaUpper = new ArrayList<>();
    for (String s : alpha) {
      alphaUpper.add(s.toUpperCase());
    }

    System.out.println(alpha); //[a, b, c, d]
    System.out.println(alphaUpper); //[A, B, C, D]

    // Java 8
    List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
    System.out.println(collect); //[A, B, C, D]

    // Extra, streams apply to any data type.
    List<Integer> num = Arrays.asList(1,2,3,4,5);
    List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
    System.out.println(collect1); //[2, 4, 6, 8, 10]
  }
}
