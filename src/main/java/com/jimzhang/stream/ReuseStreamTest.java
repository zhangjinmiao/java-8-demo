package com.jimzhang.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉<br> 〈重用流〉
 *
 * @author zhangjinmiao
 * @create 2019/8/8 10:27
 */
public class ReuseStreamTest {

  public static void main(String[] args) {

    String[] array = {"a", "b", "c", "d", "e"};
    Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);

    //get new stream
    streamSupplier.get().forEach(x-> System.out.println(x));

    //get another new stream

    long count = streamSupplier.get().filter(x -> "b".equals(x)).count();
    System.out.println(count);
  }
}
