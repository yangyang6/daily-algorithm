package com.cwnu.base;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(()->{
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            return "world";
        }),(s1,s2) -> s1 + " " + s2).join();
        System.out.println(result);
    }
}
