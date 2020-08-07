package com.cwnu.annotation;

import java.lang.annotation.*;

/**
 * Created by rey on 2019-10-13.
 */

//@Target注解 是专门用来限定某个自定义注解能够被应用在哪些Java元素上面的
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface ReyAnnotation {
    String name();

    //既有属性的特征(可以赋值)，又有方法的特征(打了一对括号)
    int age() default 18;

    int[] score();
}
