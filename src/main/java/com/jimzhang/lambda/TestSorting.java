package com.jimzhang.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 〈排序〉
 *
 * @author zhangjinmiao
 * @create 2019/8/4 10:19
 */
public class TestSorting {

  private static void sortUseAgeBefore(List<Developer> listDevs) {

    //sort by age
    Collections.sort(listDevs, new Comparator<Developer>() {
      @Override
      public int compare(Developer o1, Developer o2) {
        return o1.getAge() - o2.getAge();
      }
    });
  }

  private static void sortUseNameBefore(List<Developer> listDevs) {
    // sort by name
    Collections.sort(listDevs, new Comparator<Developer>() {
      @Override
      public int compare(Developer o1, Developer o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });
  }

  private static void sortUseSalaryBefore(List<Developer> listDevs) {
    Collections.sort(listDevs, new Comparator<Developer>() {
      @Override
      public int compare(Developer o1, Developer o2) {
        return o1.getSalary().compareTo(o2.getSalary());
      }
    });
  }

  //=============after java 8=============

  private static void sortUseAgeAfterJava8(List<Developer> listDevs) {
    // after Java 8
    //    listDevs.sort(new Comparator<Developer>() {
    //      @Override
    //      public int compare(Developer o1, Developer o2) {
    //        return o1.getAge() - o2.getAge();
    //      }
    //    });

    // or lambda
    listDevs.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());
  }

  private static void sortUseNameAfterJava8(List<Developer> listDevs) {
    listDevs.sort((o1,o2) ->o1.getName().compareTo(o2.getName()));
  }

  private static void sortUseSalaryAfterJava8(List<Developer> listDevs) {
    listDevs.sort((o1,o2)->o1.getSalary().compareTo(o2.getSalary()));
  }


  //=========反向排序===========

  private static void sortUseSalaryAfterJava8Reversed(List<Developer> listDevs){
    Comparator<Developer> salaryComparator = (o1, o2)->o1.getSalary().compareTo(o2.getSalary());
    listDevs.sort(salaryComparator.reversed());
  }

  //=========排序规则===========

  private static void sortUseSalary(List<Developer> listDevs) {
    sortUseSalaryBefore(listDevs);

    System.out.println("===after Java 8===");

    sortUseSalaryAfterJava8(listDevs);
  }

  private static void sortUseName(List<Developer> listDevs) {
    sortUseNameBefore(listDevs);

    System.out.println("===after Java 8===");

    sortUseNameAfterJava8(listDevs);
  }

  private static void sortUseAge(List<Developer> listDevs) {

//    sortUseAgeBefore(listDevs);

    System.out.println("===after Java 8===");

    sortUseAgeAfterJava8(listDevs);
  }


  public static List<Developer> getDevelopers() {
    List<Developer> developers = new ArrayList<>();
    developers.add(new Developer("lisi", new BigDecimal("8000"),23));
    developers.add(new Developer("wangwu", new BigDecimal("9000"),24));
    developers.add(new Developer("maliu", new BigDecimal("10000"),25));
    developers.add(new Developer("zhangsan", new BigDecimal("7000"),22));
    return developers;
  }


  public static void main(String[] args) {
    List<Developer> listDevs = getDevelopers();

    System.out.println("Before Sort");
    for (Developer developer : listDevs) {
      System.out.println(developer.toString());
    }

//    sortUseAge(listDevs);
//
//    sortUseName(listDevs);

//    sortUseSalary(listDevs);


    System.out.println("After Sort");
//    sortUseSalaryAfterJava8(listDevs);
    // 反向
    sortUseSalaryAfterJava8Reversed(listDevs);
    // use lambda
    listDevs.forEach((developer -> {System.out.println(developer);}));
  }

}
