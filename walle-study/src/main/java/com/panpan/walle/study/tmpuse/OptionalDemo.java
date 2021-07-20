package com.panpan.walle.study.tmpuse;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Integer i = 2;
        int a = Optional.ofNullable(i)
                .orElse(-1);
        System.out.println(a);
    }
}
