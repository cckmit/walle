package com.panpan.walle.study.designpattern.structure.proxy;

public class RealSubject implements Subject{
    @Override
    public void action() {
        System.out.println("real subject action!");
    }
}
