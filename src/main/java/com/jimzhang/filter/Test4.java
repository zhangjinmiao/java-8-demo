package com.jimzhang.filter;

import com.jimzhang.lambda.Developer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 〈filter() and map()〉
 *
 * @author zhangjinmiao
 * @create 2019/8/4 15:25
 */
public class Test4 {

  public static void main(String[] args) {
    List<Developer> persons = Arrays.asList(
        new Developer("zhangsan", 20),
        new Developer("lisi",21),
        new Developer("wangwu",22));

    String name = persons.stream().filter(x -> "lisi".equals(x.getName()))
        .map(Developer::getName)     //convert stream to String
        .findAny().orElse("");

    System.out.println("name : " + name);

    List<String> collect = persons.stream().filter(x -> "lisi".equals(x.getName()))
        .map(Developer::getName).collect(Collectors.toList());

    collect.forEach(System.out::println);
  }
}
