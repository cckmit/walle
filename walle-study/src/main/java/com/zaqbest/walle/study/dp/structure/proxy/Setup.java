package com.zaqbest.walle.study.dp.structure.proxy;

public class Setup {
    public static void main(String[] args) {
        Subject subject = new ProxySubject(new RealSubject());
        subject.action();
    }
}
