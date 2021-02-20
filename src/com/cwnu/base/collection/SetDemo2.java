package com.cwnu.base.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class SetDemo2 {
    public static void main(String[] args) {
        //创建集合对象
        HashSet<Student> hs = new HashSet<Student>();
        HashMap<Student,String> map  = new HashMap<>();
        //创建学生对象
        Student stu1 = new Student("张三",10);
        Student stu2 = new Student("李四",11);
        Student stu3 = new Student("李四",11);
        //添加学生对象到集合中,stu2与stu3的地址不一样，hash值不一样，不会重复.
        hs.add(stu1);
        hs.add(stu2);
        hs.add(stu3);

        map.put(stu1,"111");
        map.put(stu2,"222");
        map.put(stu3,"333");
        //遍历集合
        for (Student student : hs) {
            System.out.println(student);
        }

        System.out.println(map);
    }
}

class Student {
    String name;
    int age;

    public Student() {

    }

    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }

    //重写toString方法，不然输出的是地址值
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
