package com.panpan.walle.study.tmpuse;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class JsonDemo {
    public static void main(String[] args) {
        MyClass<Map<String, String>> myClass = new MyClass<>();
        myClass.setName("hello");
        myClass.setData(new HashMap<String, String>(){{
            put("aaa", "aaa1");
            put("bbb", "bbb2");
        }});

        String s = JSON.toJSONString(myClass);
        System.out.println(s);

        MyClass myClass1 = JSON.parseObject(s, MyClass.class);
        System.out.println(JSON.toJSONString(myClass1));
    }
}

class MyClass<T>{
    private String name;

    private T data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
