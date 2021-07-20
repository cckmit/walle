package com.panpan.walle.study.jjkj;


import cn.hutool.core.codec.Base64;

import java.io.File;
import java.io.FileNotFoundException;

public class TextInPDFDemo {
    public static void main(String[] args) throws FileNotFoundException {
        String file = "D:\\OneDrive\\Documents\\聚均科技\\20210623-发票验真\\发票验真模板.pdf";
        String base64 = Base64.encode(new File(file));
        System.out.println(base64);
    }
}
