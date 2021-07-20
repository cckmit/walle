package com.panpan.walle.study.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamTest {

    @Test
    public void testMapToObj(){
        IntStream
                .rangeClosed(1,100)
                .filter(x -> x % 2 == 0)
                .mapToObj( x -> new int[]{x, x*x})
                .forEach(x -> System.out.println(Arrays.toString(x)));
    }
}
