package com.cwnu.book.java8.part1.base;

import java.util.function.Predicate;

/**
 * Created by rey on 2019-09-15.
 */
public class PredicateTest {
    public static void main(String[] args) {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        //这段代码没有进行拆箱 or 装箱操作
        System.out.println(evenNumbers.test(1000));
    }
}
