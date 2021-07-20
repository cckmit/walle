package com.panpan.walle.study.tmpuse;

import java.util.function.Consumer;

public class FunctionalDemo2 {
    public static void main(String[] args) {
        Consumer consumer = System.out::println;
        consumer.accept("hello function");
    }
}
