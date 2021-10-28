package com.panpan.walle.study.tmpuse;

import cn.hutool.crypto.symmetric.AES;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;

public class TmpDemo {
//    //这里是通过反射移除了isRestricted 的变量修饰符：final
//    //然后将isRestricted 赋值为false即可
//    static {
//        //break JCE crypto policy limit
//        try {
//            Class<?> clazz = Class.forName("javax.crypto.JceSecurity");
//            Field nameField = clazz.getDeclaredField("isRestricted");
//
//            Field modifiersField = Field.class.getDeclaredField("modifiers");
//            modifiersField.setAccessible(true);
//            //modifiersField.setInt(nameField, nameField.getModifiers() & ~ Modifier.FINAL);
//            modifiersField.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL);
//
//            nameField.setAccessible(true);
//            nameField.set(null, java.lang.Boolean.FALSE);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
    public static void main(String[] args) throws Exception {
        byte[] res1 = encryptAES256("AAAA", "1234567812345678".getBytes(StandardCharsets.UTF_8));
        byte[] res2 = encryptAES2562("AAAA", "12345678123456781234567812345678".getBytes(StandardCharsets.UTF_8));

        System.out.println(1);
    }

    private static byte[] encryptAES256(String content, byte[] bytePassword) throws Exception {
        try {
            Cipher cipherInstance = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
            SecretKeySpec key = new SecretKeySpec(bytePassword, "AES");
            cipherInstance.init(Cipher.ENCRYPT_MODE, key);
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            return cipherInstance.doFinal(byteContent);
        } catch (Exception e) {
            throw e;
        }
    }

    private static byte[] encryptAES2562(String content, byte[] bytePassword) throws Exception {
        try {
            AES aes = new AES("ECB","PKCS7Padding", bytePassword);
            return aes.encrypt(content);
        } catch (Exception e) {
            throw e;
        }
    }
}
