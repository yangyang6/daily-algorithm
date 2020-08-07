package com.cwnu.base.load;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        System.out.println(loader);
//        System.out.println(loader.getParent());
//        System.out.println(loader.getParent().getParent());


        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        System.out.println(loader);

        //Test2的静态块没被执行
        //System.out.println(loader.loadClass("com.cwnu.base.load.Test2"));

        //Test2的静态块被执行了
        //Class.forName("com.cwnu.base.load.Test2");

        //指定初始化时不执行静态块
        Class.forName("com.cwnu.base.load.Test2", false, loader);
    }
}
