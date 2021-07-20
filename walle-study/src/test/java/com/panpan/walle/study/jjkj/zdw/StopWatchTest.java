package com.panpan.walle.study.jjkj.zdw;

import cn.hutool.core.date.StopWatch;

import java.util.concurrent.TimeUnit;

public class StopWatchTest {
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("task1");
        TimeUnit.SECONDS.sleep(1);
        stopWatch.stop();

        stopWatch.start("task2");
        TimeUnit.SECONDS.sleep(1);
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }
}
