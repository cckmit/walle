package com.panpan.walle.study.temp;

import java.util.concurrent.TimeUnit;

public class TempMain {
    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (Exception e){

            }
        }).start();

        Thread.currentThread().join();
    }
}
