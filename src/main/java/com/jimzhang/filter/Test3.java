package com.jimzhang.filter;

import com.jimzhang.lambda.Developer;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 〈多条件查询〉
 *
 * @author zhangjinmiao
 * @create 2019/8/4 15:20
 */
public class Test3 {

  public static void main(String[] args) {
    List<Developer> persons = Arrays.asList(
        new Developer("zhangsan", 20),
        new Developer("lisi",21),
        new Developer("wangwu",22));

    Developer result1 = persons.stream()
        .filter(p -> "lisi".equals(p.getName()) && p.getAge() == 21).findAny().orElse(null);

    System.out.println(result1);

    Developer result2 = persons.stream().filter(p -> {
      if ("lisi".equals(p.getName()) && p.getAge() == 21) {
        return true;
      }
      return false;
    }).findAny().orElse(null);

    System.out.println(result2);

  }
}
