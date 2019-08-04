package com.jimzhang.filter;

import com.jimzhang.lambda.Developer;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 〈查询符合条件的〉
 *
 * @author zhangjinmiao
 * @create 2019/8/4 15:08
 */
public class Test2 {

  public static void main(String[] args) {
    List<Developer> persons = Arrays.asList(
        new Developer("zhangsan", 20),
        new Developer("lisi",21),
        new Developer("wangwu",22));

//    Developer developer = getByNameBefore(persons,"lisi");
    Developer developer = getByNameAfter(persons,"lisi");

    System.out.println(developer == null ? "不存在" : developer.toString());
  }

  private static Developer getByNameAfter(List<Developer> persons, String lisi) {
    Developer developer = persons.stream().filter(x -> lisi.equals(x.getName())).findAny()
        .orElse(null);
    System.out.println(developer);
    // 不存在的
    Developer developer1 = persons.stream().filter(x -> "asan".equals(x.getName())).findAny()
        .orElse(null);

    System.out.println(developer1);
//    return developer;
    return developer1;
  }

  private static Developer getByNameBefore(List<Developer> persons, String lisi) {
    Developer result = null;
    for (Developer developer : persons) {
      if (developer.getName().equals(lisi)) {
        result = developer;
      }
    }

    return result;
  }


}
