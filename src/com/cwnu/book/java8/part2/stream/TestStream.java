package com.cwnu.book.java8.part2.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by rey on 2019-09-15.
 */
public class TestStream {
    public static void main(String[] args) {

        //流只能遍历一次
        List<String> title = Arrays.asList("java8", "in", "action");
        Stream stream = title.stream();
        stream.forEach(System.out::println);
        //下面的代码会报错，只能消费一次
        stream.forEach(System.out::println);
    }
}
