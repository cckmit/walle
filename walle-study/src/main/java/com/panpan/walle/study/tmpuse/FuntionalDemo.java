package com.panpan.walle.study.tmpuse;

public class FuntionalDemo {
    public static void main(String[] args) {
        func(() -> System.out.println("hello"));
    }

    public static void func(Callback cb) {
        cb.doo();
    }
}
