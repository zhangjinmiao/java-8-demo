package com.jimzhang.map;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.jimzhang.lambda.Developer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 〈 List of objects -> List of other objects〉
 *
 * @author zhangjinmiao
 * @create 2019/8/5 21:02
 */
public class Test3 {

  public static void main(String[] args) {

    List<Developer> developers = Arrays.asList(
        new Developer("zhangsan", 20),
        new Developer("lisi",21),
        new Developer("wangwu",22));


    beforeJava8(developers);

    System.out.println("=======");

    afterJava8(developers);
  }

  private static void afterJava8(List<Developer> developers) {

    List<Person> result = developers.stream().map(temp -> {
      Person person = new Person();
      person.setName(temp.getName());
      person.setAge(temp.getAge());

      if ("lisi".equals(temp.getName())) {
        person.setExtra("i am lisi");
      }
      return person;
    }).collect(Collectors.toList());

    System.out.println(JSONUtil.toJsonStr(result));
  }

  private static void beforeJava8(List<Developer> developers) {

    List<Person> result = new ArrayList<>();

    for (Developer developer : developers) {
      Person person = new Person();
      person.setName(developer.getName());
      person.setAge(developer.getAge());

      if ("lisi".equals(developer.getName())) {
        person.setExtra("i am lisi");
      }

      result.add(person);
    }

    System.out.println(JSONUtil.toJsonStr(result));
  }
}
