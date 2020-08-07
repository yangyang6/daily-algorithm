package com.cwnu.book.java8.func;

import java.util.function.Function;

/**
 * Created by rey on 2019-10-15.
 */
public class TransformFunction {

    static Function<I, O> transForm(Function<I, O> in) {
        return in.andThen(o -> {
            System.out.println(o);
            return o;
        });
    }

    public static void main(String[] args) {
        Function<I, O> f2 = transForm(i -> {
            System.out.println(i);
            return new O();
        });

        O o2 = f2.apply(new I());
    }

}
