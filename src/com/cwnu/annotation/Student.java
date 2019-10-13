package com.cwnu.annotation;

/**
 * Created by rey on 2019-10-13.
 */
public class Student {
    @ReyAnnotation(name = "rey-yang", age = 27, score = {100, 120})
    public void study(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Good Good Study , Day Day Up!");
        }
    }
}
