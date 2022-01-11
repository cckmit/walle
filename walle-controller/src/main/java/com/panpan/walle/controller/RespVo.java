package com.panpan.walle.controller;

import com.panpan.walle.annotation.Sensitive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespVo {
    @Sensitive
    private String value;
}
