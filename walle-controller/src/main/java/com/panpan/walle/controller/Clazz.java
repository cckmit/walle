package com.panpan.walle.controller;

import com.panpan.walle.annotation.Sensitive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Clazz {
    @Sensitive
    private String myvalue;
}
