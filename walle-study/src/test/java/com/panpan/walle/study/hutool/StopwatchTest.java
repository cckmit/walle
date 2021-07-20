package com.panpan.walle.study.hutool;

import cn.hutool.core.date.StopWatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class StopwatchTest {

    @Test
    public void testStopwatch() throws InterruptedException {
        Long start = System.currentTimeMillis();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("处理耗时：" + (System.currentTimeMillis() - start) + "ms");
    }
}
