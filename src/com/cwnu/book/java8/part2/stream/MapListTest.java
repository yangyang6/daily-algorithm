package com.cwnu.book.java8.part2.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rey on 2019-12-22.
 */
public class MapListTest {

    public static void main(String[] args) {
        TestEntity testEntity1 = new TestEntity();
        testEntity1.setCategory(null);
        testEntity1.setName("1test");

        TestEntity testEntity2 = new TestEntity();
        testEntity2.setCategory(null);
        testEntity2.setName("1test");

        TestEntity testEntity3 = new TestEntity();
        testEntity3.setCategory("categoty");
        testEntity3.setName("3test");


        TestEntity testEntity4 = new TestEntity();
        testEntity4.setCategory("categoty");
        testEntity4.setName("4test");


        TestEntity testEntity5 = new TestEntity();
        testEntity5.setCategory("categoty-bak");
        testEntity5.setName("5test");

        List<TestEntity> list = new ArrayList<>();
        list.add(testEntity1);
        list.add(testEntity2);
        list.add(testEntity3);
        list.add(testEntity4);
        list.add(testEntity5);

//        System.out.println(list.stream().collect(Collectors.groupingBy(e -> e.getCategory())));
        System.out.println(list.stream().collect(Collectors.groupingBy(e -> e.getCategory() != null)));
    }



}


class TestEntity {
    private String category;
    private String name;
    private String value;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
