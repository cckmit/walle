package com.panpan.walle.study.tmpuse.conditiondemo;

import java.util.Collection;

public class In<K, V> extends AbstractOperation<K, V>{

    private final String beginStr = "(";
    private final String endStr = ")";

    public In(K key, V value) {
        super(key, value);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("%s in ", key));
        stringBuffer.append(beginStr);
        stringBuffer.append(value);
        stringBuffer.append(endStr);

       return stringBuffer.toString();
    }
}
