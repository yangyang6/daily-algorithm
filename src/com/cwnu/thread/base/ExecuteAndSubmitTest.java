package com.cwnu.thread.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ExecuteAndSubmitTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final ExecutorService pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null);

        //1.使用submit
        pool.submit(() -> {
            list.parallelStream().map(a -> a.toString()).collect(Collectors.toList());
        });
        TimeUnit.SECONDS.sleep(3);
        //2.使用 execute
        pool.execute(() -> {
            list.parallelStream().map(a -> a.toString()).collect(Collectors.toList());
        });
        //3.使用submit，调用get()
        pool.submit(() -> {
            list.parallelStream().map(a -> a.toString()).collect(Collectors.toList());
        }).get();
        TimeUnit.SECONDS.sleep(3);
    }
}
