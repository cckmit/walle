package com.panpan.walle.controller;

import com.panpan.walle.annotation.Sensitive;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ReqVo {
    @Sensitive
    private String value;

    private String clearValue;

    @Sensitive
    private List<String> senList;

    @Sensitive
    private Set<String> strSet;

    private Clazz clazz;

    private List<Clazz> clazzList;
}
