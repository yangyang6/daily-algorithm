package com.cwnu.base.collection;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("aaa", "aaa");
        hashMap.put("bbb", "bbb");


        hashMap.entrySet().forEach(e->{
            System.out.println(e.getKey()+"===" + e.getValue());
        });

        System.out.println(getString());
    }

    public static String getString(){
        try{
            return "aaa";
        }finally {
            return "success";
        }
    }
}
