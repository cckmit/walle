package com.panpan.walle.jjkj.guoxin;

import lombok.Data;

@Data
public class Enum {

    private String id;
    private String code;
    private String desc;

    public Enum(String id, String code, String desc) {
        this.id = id;
        this.code = code;
        this.desc = desc;
    }
}

