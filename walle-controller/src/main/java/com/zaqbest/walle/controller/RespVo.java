package com.zaqbest.walle.controller;

import com.zaqbest.walle.annotation.Sensitive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespVo {
    @Sensitive
    private String value;
}
