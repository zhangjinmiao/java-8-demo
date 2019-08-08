package com.jimzhang.convert;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉<br> 〈如何将 Array 转换为 Stream〉
 *
 * @author zhangjinmiao
 * @create 2019/8/8 07:52
 */
public class ArrayToStream {

  public static void main(String[] args) {

//    ObjectArrays();

    PrimitiveArrays();
  }


  private static void ObjectArrays() {
    String[] array = {"a", "b", "c", "d", "e"};
    //Arrays.stream
    Stream<String> stream = Arrays.stream(array);
    stream.forEach(x-> System.out.println(x));

    System.out.println("======");

    //Stream.of
    Stream<String> stream1 = Stream.of(array);
    stream1.forEach(x-> System.out.println(x));
  }

  private static void PrimitiveArrays() {
    int[] intArray = {1, 2, 3, 4, 5};

    // 1. Arrays.stream -> IntStream
    IntStream stream = Arrays.stream(intArray);
    stream.forEach(x->System.out.println(x));

    System.out.println("======");

    // 2. Stream.of -> Stream<int[]>
    Stream<int[]> temp = Stream.of(intArray);

    // 不能直接输出，需要先转换为 IntStream
    IntStream intStream = temp.flatMapToInt(x -> Arrays.stream(x));
    intStream.forEach(x-> System.out.println(x));

  }
}
