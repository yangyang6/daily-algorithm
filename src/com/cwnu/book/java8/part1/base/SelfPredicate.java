package com.cwnu.book.java8.part1.base;

/**
 * Created by rey on 2019-09-15.
 * 方法的传递
 */
public interface SelfPredicate<T> {
    boolean test(T t);
}
