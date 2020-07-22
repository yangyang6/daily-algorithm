package com.cwnu.base.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * List底层是数组，由于此数据结构，查询效率是比较快的，但是新增和删除是比较慢的
 */
public class ArrayAndLinkedList {
    public static void main(String[] args) {
        List<String> array = new ArrayList<>();
        array.add("111");
        array.add("111");
        System.out.println(array);
        List<String> linkedList = new LinkedList<>();
        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("111");
//        System.out.println(linkedList);
    }
}
