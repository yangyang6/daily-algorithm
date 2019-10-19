package com.cwnu.book.java8.part2.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by rey on 2019-10-19.
 * 当我们从一个List<Object>构造一个Map<String,Stirng>的时候，如果value值出现空值，就会报空指针异常
 */
public class StreamMapTest {

    public static void main(String[] args) {
        Role role1 = new Role();
        role1.setId("11");
        role1.setName("11name");

        Role role2 = new Role();
        role2.setId("22");
        role2.setName("22name");


        //造出现空指针异常的数据
        Role role3 = new Role();
        role3.setId("33");
        role3.setName(null);

        List<Role> roleList = new ArrayList<>();
        roleList.add(role1);
        roleList.add(role2);
        roleList.add(role3);

        //try catch NullPointerException
//        Map<String,String> map = roleList.stream().collect(Collectors.toMap(Role::getId,Role::getName));
//        System.out.println(map);


        //避免空指针异常
        Map<String,String> map = roleList.stream().collect(HashMap::new,(m,v) -> m.put(v.getId(),v.getName()),HashMap::putAll);
        System.out.println(map);


    }
}
