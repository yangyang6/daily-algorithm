package com.cwnu.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestBrackets2 {
    public static void main(String[] args) {
        /**
         * TestBrackets2.class
         * TestBrackets2$1.class
         */

        /*
        List<String> list = new ArrayList<String>(){{
            add("aa");
        }};
        */

        List<String> list = new ArrayList<>();
        list.add("aa");

        Map<String,String> aaa = new HashMap<>();
        aaa.put("aaaa","aaaa");
        aaa.put("bbbb","bbbb");
        List<String> result = aaa.values().stream().distinct().collect(Collectors.toList());
        System.out.println(result);

        System.out.println(aaa.containsKey("aaaa"));

        List<String> aa = new ArrayList<>(5);
        System.out.println(aa.size());

        //System.out.println(new BigDecimal(13).divide(new BigDecimal(3),2,BigDecimal.ROUND_HALF_UP));

        System.out.println((int) ((Math.random() * 9 + 1) * 1000));
    }
}
