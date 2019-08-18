package com.jimzhang.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉<br> 〈流关闭〉
 *
 * @author zhangjinmiao
 * @create 2019/8/8 10:22
 */
public class ClosedTest {

  public static void main(String[] args) {
    String[] array = {"a", "b", "c", "d", "e"};
    Stream<String> stream = Arrays.stream(array);

    // loop a stream
    stream.forEach(x-> System.out.println(x));

    // 拒绝过滤，抛出 throws IllegalStateException
    long count = stream.filter(x -> "b".equals(x)).count();
    System.out.println(count);
  }
}
