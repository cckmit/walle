package com.panpan.walle.jjkj.guoxin;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

import java.nio.charset.StandardCharsets;

public class TmpUse {
    public static void main(String[] args) {
        aes();
    }

    private static void aes() {
        String key = "vCK5T9dfeOBA2Vjt";
        Long fileId = 1234L;

        AES aes = SecureUtil.aes(key.getBytes(StandardCharsets.UTF_8));
        //加密
        String encryptHex = aes.encryptHex(String.valueOf(fileId));
        System.out.println(encryptHex);

        Long fileIdEnc  = Long.valueOf(encryptHex, 16);
        System.out.println(fileIdEnc);

        //解密
        String decryptStr = aes.decryptStr(encryptHex);
        System.out.println(decryptStr);
    }
}
