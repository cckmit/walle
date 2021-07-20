package com.panpan.walle.study;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TransferSolution {
    public static void main(String[] args) {
        Resource res = new Resource();
        new Thread(()->{
            res.userA();
        }).start();
        new Thread(()->{
            res.userB();
        }).start();
        new Thread(()->{
            res.userC();
        }).start();

        try{
            res.lock.lock();
            res.con.signal();
        } finally {
            res.lock.unlock();
        }

    }
}

class Resource{
    int num = 1;
    public Lock lock = new ReentrantLock();
    public Condition con = lock.newCondition();
    public Condition conA = lock.newCondition();
    public Condition conB = lock.newCondition();


    public void userA(){
        lock.lock();
        try{
            while (num != 1){
                con.await();
            }

            System.out.println("A转账1元");
            num = 2;
            conA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void userB(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        try {

            while (num != 2){
                conA.await();
                System.out.println("conA.await()");
            }
            System.out.println("B转账1元");
            num = 3;
            conB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void userC(){
        lock.lock();
        try {
//            while (num != 3){
                System.out.println("CCCCC");
                conB.await();
//            }
            System.out.println("C转账1元");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
