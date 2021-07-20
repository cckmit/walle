package com.panpan.walle.study.core.lamda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StreamDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>(){{
            put(1, "hello");
            put(2, "world");
        }};

        Arrays.asList("hello", "world")
                .stream()
                .map(w-> w.toUpperCase())
                .forEach(w-> System.out.println("---" + w + "---"));

        Arrays.asList(1,2,3,4,5,6,7,8,9,10)
                .stream()
                .filter(x->x%2==0)
                .map(x->x*x)
                .forEach(w-> System.out.println("---" + w + "---"));
    }
}
