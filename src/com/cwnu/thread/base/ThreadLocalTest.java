package com.cwnu.thread.base;

/**
 * 要及时清理掉ThreadLocal的强引用，如TL_INT
 * 如果不及时清理则会导致内存泄漏
 */
public class ThreadLocalTest {
    private static final ThreadLocal<Integer> TL_INT = ThreadLocal.withInitial(()->6);
    private static final ThreadLocal<String> TL_STRING = ThreadLocal.withInitial(()->"sss");

    public static void main(String[] args) {
        System.out.println(TL_INT.get());
        TL_INT.set(TL_INT.get() + 1);

        System.out.println(TL_INT.get());
        TL_INT.remove();

        System.out.println(TL_INT.get());
    }
}
