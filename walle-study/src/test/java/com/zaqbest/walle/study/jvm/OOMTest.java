package com.zaqbest.walle.study.jvm;

import java.util.ArrayList;
import java.util.List;

public class OOMTest {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        while (true){
            list.add(new byte[100]);
        }
    }
}
