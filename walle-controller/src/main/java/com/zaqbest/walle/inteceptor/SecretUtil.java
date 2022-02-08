package com.zaqbest.walle.inteceptor;

import cn.hutool.crypto.symmetric.AES;
import com.zaqbest.walle.annotation.Sensitive;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SecretUtil {

    private static final String key = "1234567890123456";
    private static final AES aes = new AES(key.getBytes(StandardCharsets.UTF_8));

    private static String enc(String s){
        String ret ;
        try{
            ret = aes.encryptHex(s);
        } catch (Exception e){
            e.printStackTrace();
            ret = "";
        }
        return ret.toUpperCase(Locale.ROOT);
    }

    private static String den(String s){
        String ret ;
        try{
            ret = aes.decryptStr(s);
        } catch (Exception e){
            e.printStackTrace();
            ret = "";
        }
        return ret;
    }

    private static boolean isBasicClass(Class clazz){
        List<Class> basicClazzList = Arrays.asList(
                Number.class
                , CharSequence.class
                , Boolean.class
                , Collection.class);

        return basicClazzList.stream().anyMatch(e->e.isAssignableFrom(clazz));
    }

    public static void encrypt(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f: fields){
            f.setAccessible(true);
            if (f.isAnnotationPresent(Sensitive.class)){
                if (String.class.equals(f.getType()) && f.get(obj) != null){
                    f.set(obj, enc((String)f.get(obj)));
                }

                if (Collection.class.isAssignableFrom(f.getType()) && f.get(obj) != null){
                    Collection coll;
                    if (Set.class.isAssignableFrom(f.getType())){
                        coll = new HashSet();
                    } else{
                        coll = new ArrayList();
                    }
                    Iterable iterable = (Iterable) f.get(obj);
                    Iterator iterator = iterable.iterator();
                    while (iterator.hasNext()){
                        Object value =  iterator.next();
                        if (String.class.equals(value.getClass())){
                            coll.add(enc((String)value));
                        }

                        if (!isBasicClass(value.getClass())){
                            encrypt(value);
                        }
                    }

                    f.set(obj, coll);
                }
            }

            if (Collection.class.isAssignableFrom(f.getType()) && f.get(obj) != null){
                Iterable iterable = (Iterable) f.get(obj);
                Iterator iterator = iterable.iterator();
                while (iterator.hasNext()) {
                    Object value = iterator.next();
                    if (!isBasicClass(value.getClass())) {
                        encrypt(value);
                    }
                }
            }

            if (!isBasicClass(f.getType())){
                encrypt(f.get(obj));
            }
        }



    }

    public static void decrypt(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f: fields){
            f.setAccessible(true);
            if (f.isAnnotationPresent(Sensitive.class)){

                if (String.class.equals(f.getType()) && f.get(obj) != null) {
                    f.set(obj, den((String)f.get(obj)));
                }

                if (Collection.class.isAssignableFrom(f.getType()) && f.get(obj) != null){
                    Collection coll;
                    if (Set.class.isAssignableFrom(f.getType())){
                        coll = new HashSet();
                    } else{
                        coll = new ArrayList();
                    }
                    Iterable iterable = (Iterable) f.get(obj);
                    Iterator iterator = iterable.iterator();
                    while (iterator.hasNext()){
                        Object value =  iterator.next();
                        if (String.class.equals(value.getClass())){
                            coll.add(den((String)value));
                        }
                    }

                    f.set(obj, coll);
                }
            }

            if (Collection.class.isAssignableFrom(f.getType()) && f.get(obj) != null){
                Iterable iterable = (Iterable) f.get(obj);
                Iterator iterator = iterable.iterator();
                while (iterator.hasNext()) {
                    Object value = iterator.next();
                    if (!isBasicClass(value.getClass())) {
                        decrypt(value);
                    }
                }
            }

            if (!isBasicClass(f.getType())){
                decrypt(f.get(obj));
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
//        ReqVo reqVo = new ReqVo();
//        reqVo.setValue("hello");
//        reqVo.setClearValue("hello11111");
//        reqVo.setSenList(Arrays.asList("111","2222"));
//        reqVo.setStrSet(new HashSet(Arrays.asList("111","2222")));
//        reqVo.setClazz(new Clazz("aaaa"));
//        reqVo.setClazzList(Arrays.asList(new Clazz("aaaa"),new Clazz("bbbb")));
//        encrypt(reqVo);
//
//        System.out.println("加密后结果");
//        System.out.println(reqVo);
//
//        decrypt(reqVo);
//        System.out.println("解密后结果");
//        System.out.println(reqVo);

        for (int i = 0; i < 1000; i++){
            Long key = 0x7f98938fe846fef3L;

            System.out.println(i ^ key);
        }
        }
}

