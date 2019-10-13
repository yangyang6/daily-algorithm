package com.cwnu.annotation;

import java.lang.reflect.Method;

/**
 * Created by rey on 2019-10-13.
 */
public class TestAnnotation {
    public static void main(String[] args) {
        try {
            Class stuClass = Class.forName("com.cwnu.annotation.Student");


            Method stuMethod = stuClass.getMethod("study", int.class);

            if (stuMethod.isAnnotationPresent(ReyAnnotation.class)) {
                System.out.println("在Student类上配置了ReyAnnotation注解");

                ReyAnnotation reyAnnotation = stuMethod.getAnnotation(ReyAnnotation.class);
                System.out.println("name:" + reyAnnotation.name() + " == age:" + reyAnnotation.age() + " == score:" + reyAnnotation.score()[0]);
            } else {
                System.out.println("Student类上没有配ReyAnnotation注解");
            }
        } catch (Exception e) {

        }
    }
}

