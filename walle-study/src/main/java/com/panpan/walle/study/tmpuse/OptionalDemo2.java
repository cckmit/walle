package com.panpan.walle.study.tmpuse;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class OptionalDemo2 {
    public static void main(String[] args) {
        List<MyData> list = new ArrayList<>();
        list.add(new MyData("A", 1, 10));
        list.add(new MyData("B", 1, 10));
        list.add(new MyData("B", 1, 10));

        MyData myData = list.stream().filter(d -> d.state == "A").findFirst().orElse(null);
        System.out.println(JSON.toJSONString(myData));

    }
}

class MyData{
    public String state;
    public Integer begin;
    public Integer end;

    public MyData(String state, Integer begin, Integer end) {
        this.state = state;
        this.begin = begin;
        this.end = end;
    }
}
