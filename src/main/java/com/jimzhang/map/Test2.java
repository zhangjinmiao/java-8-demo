package com.jimzhang.map;

import com.jimzhang.lambda.Developer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 〈List of objects -> List of String 〉
 *
 * @author zhangjinmiao
 * @create 2019/8/5 20:59
 */
public class Test2 {

  public static void main(String[] args) {
    List<Developer> persons = Arrays.asList(
        new Developer("zhangsan", 20),
        new Developer("lisi",21),
        new Developer("wangwu",22));

    //Before Java 8
    List<String> result = new ArrayList<>();
    for (Developer developer : persons) {
      result.add(developer.getName());
    }

    System.out.println(result); // [zhangsan, lisi, wangwu]

    //Java 8
    List<String> collect = persons.stream().map(x -> x.getName()).collect(Collectors.toList());
    System.out.println(collect); // [zhangsan, lisi, wangwu]
  }
}
