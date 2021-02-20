package com.cwnu.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestBrackets {
    public static void main(String[] args) {
        String name = "aaa";
        Map<String, String> map = new HashMap() {{
            put("map1", "value1");
            put("map2", "value2");
            put("map3", "value3");
            put(name,name);
        }};

        List<String> list = Stream.of("Java", "Redis").collect(Collectors.toList());
        System.out.println(list);

        //java9
        //Map map = Map.of("map1", "Java", "map2", "Redis");
        //System.out.println(map);

    }
}
