package com.panpan.walle.study.stream;

import java.util.stream.IntStream;

public class StreamDemo {
    public static void main(String[] args) {
        IntStream
                .rangeClosed(1,100)
                .filter(x->x%2 == 0)
                .forEach(System.out::println);
    }
}
