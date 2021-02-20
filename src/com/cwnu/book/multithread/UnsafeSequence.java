package com.cwnu.book.multithread;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

//@NotThreadSafe
public class UnsafeSequence {
    private int value;
    private final AtomicLong count = new AtomicLong(0);



    public int getNext() {
        return value++;
    }

    public long getCount(){
        return count.incrementAndGet();
    }

    public static void main(String[] args) {
        UnsafeSequence unsafeSequence = new UnsafeSequence();
        System.out.println(unsafeSequence.getCount());
    }
}
