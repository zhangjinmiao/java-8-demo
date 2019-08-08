package com.jimzhang.convert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉<br> 〈将数据流转换为列表〉
 *
 * @author zhangjinmiao
 * @create 2019/8/8 07:46
 */
public class StreamToList {

  public static void main(String[] args) {

    Stream<String> language = Stream.of("java", "python", "node");

    //Convert a Stream to List
    List<String> list = language.collect(Collectors.toList());
    list.forEach(System.out::println);

    System.out.println("======");

    Stream<Integer> number = Stream.of(1, 2, 3, 4, 5);
    List<Integer> collect = number.filter(x -> x != 3).collect(Collectors.toList());
    collect.forEach(System.out::println);
  }
}
