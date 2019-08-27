package com.jimzhang.flatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉<br> 〈flatMap 示例〉
 *
 * @author zhangjinmiao
 * @create 2019/8/26 16:28
 */
public class Test {

  public static void main(String[] args) {
//      one();

//      two();

      three();
  }

  private static void three() {
    int[] intArray = {1, 2, 3, 4, 5, 6};

    //1. Stream<int[]>
    Stream<int[]> streamArray = Stream.of(intArray);

    //2. Stream<int[]> -> flatMap -> IntStream
    IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));

    intStream.forEach(x -> System.out.println(x));
  }

  private static void two() {
    Student obj1 = new Student();
    obj1.setName("mkyong");
    obj1.addBook("Java 8 in Action");
    obj1.addBook("Spring Boot in Action");
    obj1.addBook("Effective Java (2nd Edition)");

    Student obj2 = new Student();
    obj2.setName("zilap");
    obj2.addBook("Learning Python, 5th Edition");
    obj2.addBook("Effective Java (2nd Edition)");

    List<Student> list = new ArrayList<>();
    list.add(obj1);
    list.add(obj2);

    List<String> collect = list.stream().map(x -> x.getBook()) //Stream<Set<String>>
        .flatMap(x -> x.stream()) //Stream<String>
        .distinct()
        .collect(Collectors.toList());
    collect.forEach(x-> System.out.println(x));
  }

  private static void one() {
    String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

    //Stream<String[]>
    Stream<String[]> temp = Arrays.stream(data);

    //filter a stream of string[], and return a string[]?
//    Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));
//    stream.forEach(System.out::println);


    // Stream<String>, GOOD!
    Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));
    Stream<String> stream1 = stringStream.filter(x -> "a".equals(x.toString()));
    stream1.forEach(System.out::println);
  }


}
