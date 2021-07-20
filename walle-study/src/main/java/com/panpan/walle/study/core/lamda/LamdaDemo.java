package com.panpan.walle.study.core.lamda;

import java.util.function.Consumer;

public class LamdaDemo {

    public static void main(String[] args) {
        LamdaDemo demo  =new LamdaDemo();
        demo.test(System.out::println, "hello");
    }

    public <T> void test(Consumer<T> consumer, T t){
        consumer.accept(t);
    }
}
