package com.cwnu.book.java8.part2.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by rey on 2019-09-15.
 */
public class MapStream {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");
        //no
        //words.stream().map(word -> word.split(",")).distinct().collect(toList());

        //yes ?
        //flatmap方法让你把一个流中的每一个值都换成另一个流，然后把所有的流连接起来成一个流
        List<String> uniqueCharacters = words.stream()
                .map(w -> w.split(","))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(uniqueCharacters);


    }
}
