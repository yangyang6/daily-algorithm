package com.cwnu.book.java8.part2.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rey on 2019-10-15.
 */
public class GroupTest {
    public static void main(String[] args) {
        //第一种分组写法可以避免空指针
        Map<Boolean, List<Object>> map = Stream.empty().collect(Collectors.partitioningBy(a -> false));
        System.out.println(map.get(true));
        System.out.println(Stream.empty().collect(Collectors.groupingBy(a -> false)));
    }
}
