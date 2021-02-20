package com.cwnu.base.function;


public class FunctionService {
    public static void main(String[] args) {
        Player player = new Player(18);
        PlayerService func = (player1) -> System.out.println(player1.getAge());
        func.apply(player);
    }
}


@FunctionalInterface
interface PlayerService {
    void apply(Player player);
}


class Player {
    private Integer age;

    public Player(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}