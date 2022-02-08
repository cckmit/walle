package com.zaqbest.walle.study.hutool;


import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class StopwatchTest {

    @Test
    public void testStopwatch() throws InterruptedException {
        Long start = System.currentTimeMillis();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("处理耗时：" + (System.currentTimeMillis() - start) + "ms");
    }
}
