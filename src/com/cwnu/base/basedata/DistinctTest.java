package com.cwnu.base.basedata;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DistinctTest {
    public static void main(String[] args) {
        Obk obk1 = new Obk("111",111L);
        Obk obk2 = new Obk("111",111L);
        List<Obk> list = new ArrayList<>();
        list.add(obk1);
        list.add(obk2);

        System.out.println(list.stream().distinct().collect(Collectors.toList()));
        System.out.println((short)4);


        Map<String,Boolean> zeroInfo = new HashMap<>();
        zeroInfo.put("zeroFlag",true);
        System.out.println(JSON.toJSONString(zeroInfo));
    }

}
