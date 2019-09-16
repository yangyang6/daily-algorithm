package com.cwnu.book.java8.part1.base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by rey on 2019-09-13.
 */
public class BeginLambda {
    public static void main(String[] args) {
        List<Inventory> list = new ArrayList<>();
        Inventory apple1 = new Inventory();
        apple1.setName("apple1");
        apple1.setWeight(20);
        list.add(apple1);

        Inventory apple2 = new Inventory();
        apple2.setName("apple2");
        apple2.setWeight(10);
        list.add(apple2);

        System.out.println("before no sort:" + list);
        //按重量由小到大进行排序
        list.sort(Comparator.comparing(Inventory::getWeight));
        System.out.println("end sort:" + list);


        //方法的传递调用函数
        List<Apple> apples = new ArrayList<>();
        Apple greenApple1 = new Apple();
        greenApple1.setColor("green1");
        greenApple1.setWeight(5);
        Apple redApple1 = new Apple();
        redApple1.setWeight(6);
        redApple1.setColor("red1");
        Apple redApple2 = new Apple();
        redApple2.setColor("red2");
        redApple2.setWeight(2);
        Apple redApple3 = new Apple();
        redApple3.setColor("red3");
        redApple3.setWeight(7);
        Apple greenApple2 = new Apple();
        greenApple2.setColor("green2");
        greenApple2.setWeight(2);
        apples.add(redApple1);
        apples.add(redApple2);
        apples.add(redApple3);
        apples.add(greenApple1);
        apples.add(greenApple2);


        //List<Apple> newResult =  filterApples(apples,Apple::isGreenApple);
        //System.out.println("filterGreen apple:" + newResult);

        //比较器链
        //apples.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        //System.out.println("two method sorted apples:" + apples);

        //打印出filter和map具体的过程
        List<String> colors = apples.stream().filter(d -> {
            System.out.println("filtering " + d.getColor());
            return d.getWeight() > 5;
        }).map(d -> {
            System.out.println("mapping " + d.getColor());
            return d.getColor();
        }).limit(3)
                //跳过1个元素
                .skip(1).collect(toList());
        System.out.println(colors);


    }


    private static List<Apple> filterApples(List<Apple> list, SelfPredicate<Apple> selfPredicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (selfPredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}

class Apple {
    private String color;
    private int weight;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }


    public static boolean isRedApple(Apple apple) {
        return "red".equals(apple.getColor());
    }
}


class Inventory {
    private String name;
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
