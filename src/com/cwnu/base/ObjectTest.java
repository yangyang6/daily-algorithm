package com.cwnu.base;

public class ObjectTest {

    private static ObjectTest ot = new ObjectTest();

    public static void main(String[] args) {
        System.out.println(ot);
    }

    @Override
    public String toString() {
        //ObjectTest@511d50c0
        return "The instance is " + super.toString();
    }
}
