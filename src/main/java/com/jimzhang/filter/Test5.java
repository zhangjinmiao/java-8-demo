package com.jimzhang.filter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉<br> 〈过滤一个来自流的空值〉
 *
 * @author zhangjinmiao
 * @create 2019/8/8 07:25
 */
public class Test5 {

  public static void main(String[] args) {
    Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");

//    List<String> collect = language.collect(Collectors.toList());
//    collect.forEach(System.out::println);

    System.out.println("===过滤null===");

//    List<String> result = language.filter(x -> x!= null).collect(Collectors.toList());

    // 或
    List<String> result = language.filter(Objects::nonNull).collect(Collectors.toList());

    result.forEach(System.out::println);
  }

}
